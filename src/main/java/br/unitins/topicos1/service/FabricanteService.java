package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.fabricante.FabricanteDTO;
import br.unitins.topicos1.dto.fabricante.FabricanteResponseDTO;
import jakarta.validation.Valid;

public interface FabricanteService {

    //Recursos basicos CRUD
    FabricanteResponseDTO insert(@Valid FabricanteDTO dto);

    FabricanteResponseDTO update(FabricanteDTO dto, Long id);

    void delete(Long id);

    FabricanteResponseDTO findById(Long id);

    List<FabricanteResponseDTO> getAll(int page, int pageSize);
    
    //Recursos extras
    List<FabricanteResponseDTO> findByNome(String nome);

    long count();

    FabricanteResponseDTO alterarSituacao(Long id);
}
