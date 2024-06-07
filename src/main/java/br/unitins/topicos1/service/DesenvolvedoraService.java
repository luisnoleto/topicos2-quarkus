package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.desenvolvedora.DesenvolvedoraDTO;
import br.unitins.topicos1.dto.desenvolvedora.DesenvolvedoraResponseDTO;
import jakarta.validation.Valid;

public interface DesenvolvedoraService {

    //Recursos basicos CRUD
    DesenvolvedoraResponseDTO create(@Valid DesenvolvedoraDTO dto);

    DesenvolvedoraResponseDTO update(DesenvolvedoraDTO dto, Long id);

    void delete(Long id);

    DesenvolvedoraResponseDTO findById(Long id);

    List<DesenvolvedoraResponseDTO> getAll(int page, int pageSize);

    //Recursos extras
    List<DesenvolvedoraResponseDTO> findByNome(String nome);

    long count();

    DesenvolvedoraResponseDTO alterarSituacao(Long id);

}
