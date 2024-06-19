package br.unitins.topicos1.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import br.unitins.topicos1.repository.JogoRepository;
import br.unitins.topicos1.repository.SlideRepository;
import br.unitins.topicos1.model.Jogo;
import br.unitins.topicos1.model.Slide;
import jakarta.validation.ValidationException;
import jakarta.ws.rs.NotFoundException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class CarouselFileService implements CarouselService {
    private final String PATH_USER = System.getProperty("user.home") +
            File.separator + "quarkus" +
            File.separator + "images" +
            File.separator + "carousel" + File.separator;

    private static final List<String> SUPPORTED_MIME_TYPES = Arrays.asList("image/jpeg", "image/jpg", "image/png",
            "image/gif");
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 10; // 10mb

    @Inject
    JogoRepository jogoRepository;

    @Inject
    SlideRepository slideRepository;

    @Override
    @Transactional
    public void salvar(Long jogoId, String nomeImagemCarousel, byte[] imagemCarousel) {
        try {
            Jogo jogo = jogoRepository.findById(jogoId);
            if (jogo == null) {
                throw new NotFoundException("Jogo not found");
            }

            String novoNomeImagem = salvarImagem(imagemCarousel, nomeImagemCarousel);
            Slide slide = new Slide();
            slide.setNomeImagem(novoNomeImagem);
            slide.setJogoId(jogo);
            slideRepository.persist(slide);

        } catch (Exception e) {
            throw new ValidationException("Failed to save carousel slide", e);
        }
    }

    @Override
    @Transactional
    public void removerPorJogoId(Long jogoId) {
        try {
            Slide slide = slideRepository.find("jogoId.id", jogoId).firstResult();
            if (slide == null) {
                throw new NotFoundException("Slide not found");
            }

            slideRepository.delete("jogoId.id", jogoId);
            File file = new File(PATH_USER + slide.getNomeImagem());
            file.delete();
        } catch (Exception e) {
            throw new ValidationException("Failed to remove carousel slide", e);
        }
    }

    private String salvarImagem(byte[] imagemCarousel, String nomeImagemCarousel) throws IOException {
        File diretorio = new File(PATH_USER);
        if (!diretorio.exists())
            diretorio.mkdirs();

        File file = new File(diretorio, nomeImagemCarousel);
        file.createNewFile();

        String mimeType = Files.probeContentType(file.toPath());
        if (mimeType == null) {
            throw new IOException("Could not determine MIME type of the file.");
        }
        if (!SUPPORTED_MIME_TYPES.contains(mimeType)) {
            throw new IOException("Tipo de imagem não suportada.");
        }

        if (imagemCarousel.length > MAX_FILE_SIZE)
            throw new IOException("Arquivo muito grande.");

        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(imagemCarousel);
            fos.flush();
        }

        return nomeImagemCarousel;
    }

    @Override
    public File download(String nomeArquivo) {
        File file = new File(PATH_USER + nomeArquivo);
        return file;
    }

    @Override
    public List<Slide> getAllSlides() {
        return slideRepository.findAll().list();
    }
}
