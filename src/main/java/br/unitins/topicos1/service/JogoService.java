package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.jogo.JogoDTO;
import br.unitins.topicos1.dto.jogo.JogoResponseDTO;



public interface JogoService {

    public JogoResponseDTO insert(JogoDTO dto);

    public JogoResponseDTO update(JogoDTO dto, Long id);

    public void delete(Long id);

    public JogoResponseDTO findById(Long id);

    public List<JogoResponseDTO> findByNome(String nome);

    public List<JogoResponseDTO> findAll(int page , int pageSize); 

    public JogoResponseDTO updateNomeImagem(Long id, String nomeImagem);

    public long count();
}
