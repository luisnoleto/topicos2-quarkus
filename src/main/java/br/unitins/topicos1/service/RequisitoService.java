package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.requisito.RequisitoDTO;
import br.unitins.topicos1.dto.requisito.RequisitoResponseDTO;
import jakarta.validation.Valid;

public interface RequisitoService {

    public RequisitoResponseDTO insert(@Valid RequisitoDTO dto);

    public RequisitoResponseDTO update(RequisitoDTO dto, Long id);

    public void delete(Long id);

    public RequisitoResponseDTO findById(Long id);

    public List<RequisitoResponseDTO> findByRequisito(String nome);

    public List<RequisitoResponseDTO> findByAll();

}
