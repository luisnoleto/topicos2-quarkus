package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.pais.PaisDTO;
import br.unitins.topicos1.dto.pais.PaisResponseDTO;
import jakarta.validation.Valid;

public interface PaisService {

    PaisResponseDTO insert(@Valid PaisDTO dto);

    PaisResponseDTO update(PaisDTO dto, Long id);

    void delete(Long id);

    PaisResponseDTO findById(Long id);

    List<PaisResponseDTO> findByNome(String nome);

    List<PaisResponseDTO> getAll(int page, int pageSize);

    long count();

}
