package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.fabricante.FabricanteDTO;
import br.unitins.topicos1.dto.fabricante.FabricanteResponseDTO;
import jakarta.validation.Valid;

public interface FabricanteService {

    public FabricanteResponseDTO insert(@Valid FabricanteDTO dto);

    public FabricanteResponseDTO update(FabricanteDTO dto, Long id);

    public void delete(Long id);

    public FabricanteResponseDTO findById(Long id);

    public List<FabricanteResponseDTO> findByNome(String nome);

    public List<FabricanteResponseDTO> findByAll();

}
