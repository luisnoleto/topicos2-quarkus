package br.unitins.topicos1.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import br.unitins.topicos1.repository.JogoRepository;
import br.unitins.topicos1.model.Jogo;
import jakarta.validation.ValidationException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class JogoFileService implements FileService {
    private final String PATH_USER = System.getProperty("user.home") +
            File.separator + "quarkus" +
            File.separator + "images" +
            File.separator + "usuario" + File.separator;

    private static final List<String> SUPPORTED_MIME_TYPES = Arrays.asList("image/jpeg", "image/jpg", "image/png",
            "image/gif");

    private static final int MAX_FILE_SIZE = 1024 * 1024 * 10; // 10mb

    @Inject
    JogoRepository jogoRepository;

    @Override
    @Transactional
    public void salvar(Long id, String nomeImagem, byte[] imagem) {
        Jogo jogo = jogoRepository.findById(id);

        try {
            String novoNomeImagem = salvarImagem(imagem, nomeImagem);
            jogo.setNomeImagem(novoNomeImagem);
            // excluir a imagem antiga (trabalho pra quem????)
        } catch (IOException e) {
            e.printStackTrace();
            throw new ValidationException(e.getMessage());
        }
    }

    private String salvarImagem(byte[] imagem, String nomeImagem) throws IOException {
        // verificando o tipo da imagem

        File file = new File(nomeImagem);
        file.createNewFile();
        String mimeType = Files.probeContentType(file.toPath());
        if (mimeType == null) {
            throw new IOException("Could not determine MIME type of the file.");
        }
        if (!SUPPORTED_MIME_TYPES.contains(mimeType)) {
            throw new IOException("Tipo de imagem não suportada.");
        }

        // verificando o tamanho do arquivo - nao permitir maior que 10 megas
        if (imagem.length > MAX_FILE_SIZE)
            throw new IOException("Arquivo muito grande.");

        // criando as pastas quando não existir
        File diretorio = new File(PATH_USER);
        if (!diretorio.exists())
            diretorio.mkdirs();

        // gerando o nome do arquivo
        String nomeArquivo = UUID.randomUUID()
                + "." + mimeType.substring(mimeType.lastIndexOf("/") + 1);

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(imagem);
        // garantindo o envio do ultimo lote de bytes
        fos.flush();
        fos.close();

        return nomeArquivo;
    }

    @Override
    public File download(String nomeArquivo) {
        File file = new File(PATH_USER + nomeArquivo);
        return file;
    }
}