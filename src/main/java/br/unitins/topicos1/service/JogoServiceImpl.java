package br.unitins.topicos1.service;

import java.util.ArrayList;
import java.util.List;

import br.unitins.topicos1.dto.endereco.EnderecoResponseDTO;
import br.unitins.topicos1.dto.genero.GeneroDTO;
import br.unitins.topicos1.dto.jogo.JogoDTO;
import br.unitins.topicos1.dto.jogo.JogoResponseDTO;
import br.unitins.topicos1.dto.telefone.TelefoneDTO;
import br.unitins.topicos1.model.Classificacao;
import br.unitins.topicos1.model.FormaPagamento;
import br.unitins.topicos1.model.Genero;
import br.unitins.topicos1.model.Jogo;
import br.unitins.topicos1.model.Plataforma;
import br.unitins.topicos1.model.Requisito;
import br.unitins.topicos1.model.Telefone;
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


        novoJogo.setPlataforma(Plataforma.ValueOf(dto.plataforma()));
        novoJogo.setRequisito(Requisito.ValueOf(dto.requisito()));
        novoJogo.setClassificacao(Classificacao.ValueOf(dto.classificacao()));

     

        if (dto.listaGeneros() != null &&
                !dto.listaGeneros().isEmpty()) {
            novoJogo.setListaGeneros(new ArrayList<Genero>());
            for (GeneroDTO gen : dto.listaGeneros()) {
                Genero genero = new Genero();
                genero.setNome(gen.nome());

                novoJogo.getListaGeneros().add(genero);
            }
        }

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

            List<Genero> generos = new ArrayList<Genero>();

            if (dto.listaGeneros() != null && !dto.listaGeneros().isEmpty()) {
                jogo.setListaGeneros(new ArrayList<Genero>());
                for (GeneroDTO gen : dto.listaGeneros()) {
                    Genero genero = new Genero();

                    genero.setNome(gen.nome());

                    generos.add(genero);
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
    public List<JogoResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome)
                .stream()
                .map(e -> JogoResponseDTO.valueOf(e))
                .toList();
    }

    @Override
    public List<JogoResponseDTO> findAll() {
        return repository.findAll().list().stream()
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
