package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.jogo.JogoDTO;
import br.unitins.topicos1.dto.jogo.JogoResponseDTO;
import br.unitins.topicos1.dto.usuario.UsuarioResponseDTO;
import br.unitins.topicos1.model.Genero;
import br.unitins.topicos1.model.Jogo;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.JogoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class JogoServiceImpl implements JogoService {

    @Inject
    JogoRepository repository;

    @Override
    @Transactional
    public JogoResponseDTO insert(JogoDTO dto) {
        Jogo novoJogo = new Jogo();
        novoJogo.setNome(dto.nome());
        novoJogo.setDescricao(dto.descricao());
        novoJogo.setPreco(dto.preco()); 
        novoJogo.setEstoque(dto.estoque());
    

        novoJogo.setGenero(Genero.ValueOf(dto.idGenero()));

        repository.persist(novoJogo);

        return JogoResponseDTO.valueOf(novoJogo);
    }

    @Override
    @Transactional
    public JogoResponseDTO update(JogoDTO dto, Long id) {

        Jogo jogo = repository.findById(id);

        if (jogo != null) {
            jogo.setNome(dto.nome());
            jogo.setDescricao(dto.descricao());
            jogo.setPreco(dto.preco());
            jogo.setGenero(Genero.ValueOf(dto.idGenero()));

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
    public List<JogoResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome)
                .stream()
                .map(e -> JogoResponseDTO.valueOf(e))
                .toList();
    }

    @Override
    public List<JogoResponseDTO> findByAll() {
        return repository.findAll()
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

}
