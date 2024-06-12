package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.plataforma.PlataformaDTO;
import br.unitins.topicos1.dto.plataforma.PlataformaResponseDTO;
import jakarta.validation.Valid;

public interface PlataformaService {

    PlataformaResponseDTO insert(@Valid PlataformaDTO dto);

    PlataformaResponseDTO update(PlataformaDTO dto, Long id);

    void delete(Long id);

    PlataformaResponseDTO findById(Long id);

    List<PlataformaResponseDTO> findByNome(String nome);

    List<PlataformaResponseDTO> getAll(int page, int pageSize); 

    long count();

    PlataformaResponseDTO alterarSituacao(Long id);

    List<PlataformaResponseDTO> findByAtivo(boolean ativo);

}
