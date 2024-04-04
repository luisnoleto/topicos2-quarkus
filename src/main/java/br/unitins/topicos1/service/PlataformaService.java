package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.plataforma.PlataformaDTO;
import br.unitins.topicos1.dto.plataforma.PlataformaResponseDTO;
import jakarta.validation.Valid;

public interface PlataformaService {

    public PlataformaResponseDTO insert(@Valid PlataformaDTO dto);

    public PlataformaResponseDTO update(PlataformaDTO dto, Long id);

    public void delete(Long id);

    public PlataformaResponseDTO findById(Long id);

    public List<PlataformaResponseDTO> findByNome(String nome);

    public List<PlataformaResponseDTO> findByAll();

}
