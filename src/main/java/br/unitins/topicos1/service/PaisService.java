package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.pais.PaisDTO;
import br.unitins.topicos1.dto.pais.PaisResponseDTO;
import jakarta.validation.Valid;

public interface PaisService {

    public PaisResponseDTO insert(@Valid PaisDTO dto);

    public PaisResponseDTO update(PaisDTO dto, Long id);

    public void delete(Long id);

    public PaisResponseDTO findById(Long id);

    public List<PaisResponseDTO> findByNome(String nome);

    public List<PaisResponseDTO> findByAll();

}
