package br.unitins.topicos1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import br.unitins.topicos1.dto.jogo.JogoDTO;
import br.unitins.topicos1.dto.jogo.JogoResponseDTO;
import br.unitins.topicos1.model.Classificacao;
import br.unitins.topicos1.model.Desenvolvedora;
import br.unitins.topicos1.model.Genero;
import br.unitins.topicos1.model.Jogo;
import br.unitins.topicos1.model.Plataforma;
import br.unitins.topicos1.repository.DesenvolvedoraRepository;
import br.unitins.topicos1.repository.GeneroRepository;
import br.unitins.topicos1.repository.JogoRepository;
import br.unitins.topicos1.repository.PlataformaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class JogoServiceImpl implements JogoService {
    @Inject
    JogoRepository repository;
    @Inject
    PlataformaRepository plataformaRepository;

    @Inject
    GeneroRepository generoRepository;
    @Inject
    DesenvolvedoraRepository desenvolvedoraRepository;

    @Override
    @Transactional
    public JogoResponseDTO create(JogoDTO dto) {
        Jogo novoJogo = new Jogo();
        Plataforma plataforma = plataformaRepository.findById(dto.idPlataforma());
        Desenvolvedora desenvolvedora = desenvolvedoraRepository.findById(dto.idDesenvolvedora());

        novoJogo.setNome(dto.nome());
        novoJogo.setDescricao(dto.descricao());
        novoJogo.setPreco(dto.preco());
        novoJogo.setEstoque(dto.estoque());
        novoJogo.setProcessador(dto.processador());
        novoJogo.setMemoria(dto.memoria());
        novoJogo.setPlacaVideo(dto.placaVideo());
        novoJogo.setArmazenamento(dto.armazenamento());
        novoJogo.setSistemaOperacional(dto.sistemaOperacional());

        novoJogo.setDesenvolvedora(desenvolvedora);
        novoJogo.setPlataforma(plataforma);

        novoJogo.setClassificacao(Classificacao.ValueOf(dto.classificacao()));

        if (dto.listaIdGeneros() != null &&
                !dto.listaIdGeneros().isEmpty()) {
            novoJogo.setListaGeneros(new ArrayList<Genero>());
            for (Long idGenero : dto.listaIdGeneros()) {
                Genero genero = generoRepository.findById(idGenero);
                novoJogo.getListaGeneros().add(genero);
            }
        }
        novoJogo.setNomeImagem(dto.nomeImagem());

        repository.persist(novoJogo);

        return JogoResponseDTO.valueOf(novoJogo);
    }

    @Override
    @Transactional
    public JogoResponseDTO update(JogoDTO dto, Long id) {

        Jogo jogo = repository.findById(id);
        Plataforma plataforma = plataformaRepository.findById(dto.idPlataforma());
        Desenvolvedora desenvolvedora = desenvolvedoraRepository.findById(dto.idDesenvolvedora());

        if (jogo != null) {
            jogo.setNome(dto.nome());
            jogo.setDescricao(dto.descricao());
            jogo.setPreco(dto.preco());
            jogo.setEstoque(dto.estoque());
            jogo.setProcessador(dto.processador());
            jogo.setMemoria(dto.memoria());
            jogo.setPlacaVideo(dto.placaVideo());
            jogo.setArmazenamento(dto.armazenamento());
            jogo.setSistemaOperacional(dto.sistemaOperacional());
            
            
            jogo.setDesenvolvedora(desenvolvedora);
            jogo.setPlataforma(plataforma);

            jogo.setClassificacao(Classificacao.ValueOf(dto.classificacao()));

            List<Genero> generos = new ArrayList<Genero>();

            if (dto.listaIdGeneros() != null &&
                    !dto.listaIdGeneros().isEmpty()) {
                jogo.setListaGeneros(new ArrayList<Genero>());
                for (Long idGenero : dto.listaIdGeneros()) {
                    Genero genero = generoRepository.findById(idGenero);
                    jogo.getListaGeneros().add(genero);
                }
            }

            jogo.setListaGeneros(generos);

        } else {
            throw new NotFoundException();

        }

        return JogoResponseDTO.valueOf(jogo);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Jogo jogo = repository.findById(id);

        repository.delete(jogo);
    }

    @Override
    public JogoResponseDTO findById(Long id) {
        Jogo jogo = repository.findById(id);

        return JogoResponseDTO.valueOf(jogo);
    }

    @Override
    public List<JogoResponseDTO> findAll(int page, int pageSize) {
        List<Jogo> jogos = repository
                .findAll()
                .page(page, pageSize)
                .list();

        return jogos.stream().map(e -> JogoResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public List<JogoResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome)
                .stream()
                .map(e -> JogoResponseDTO.valueOf(e))
                .toList();
    }

    @Override
    @Transactional
    public JogoResponseDTO updateNomeImagem(Long id, String nomeImagem) {
        Jogo jogo = repository.findById(id);
        jogo.setNomeImagem(nomeImagem);
        return JogoResponseDTO.valueOf(jogo);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public JogoResponseDTO alterarSituacao(Long id) {
        Jogo jogo = repository.findById(id);

        if (jogo.isAtivo() == true) {
            jogo.setAtivo(false);
        } else {
            jogo.setAtivo(true);

        }

        return JogoResponseDTO.valueOf(jogo);
    }

    @Override
    public List<JogoResponseDTO> findByAtivo(boolean ativo) {
        return repository.findByAtivo(ativo).stream()
                .map(e -> JogoResponseDTO.valueOf(e)).toList();
    }

}
