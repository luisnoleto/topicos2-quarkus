package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.jogo.JogoDTO;
import br.unitins.topicos1.dto.jogo.JogoResponseDTO;



public interface JogoService {

    //Recursos basicos CRUD
    JogoResponseDTO create(JogoDTO dto);

    JogoResponseDTO update(JogoDTO dto, Long id);

    void delete(Long id);

    JogoResponseDTO findById(Long id);

    List<JogoResponseDTO> findAll(int page , int pageSize); 

    //Recursos extras
    List<JogoResponseDTO> findByNome(String nome);

    JogoResponseDTO updateNomeImagem(Long id, String nomeImagem);

    long count();

    JogoResponseDTO alterarSituacao(Long id);
}
