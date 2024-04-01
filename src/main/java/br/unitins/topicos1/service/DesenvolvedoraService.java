package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.desenvolvedora.DesenvolvedoraDTO;
import br.unitins.topicos1.dto.desenvolvedora.DesenvolvedoraResponseDTO;
import jakarta.validation.Valid;

public interface DesenvolvedoraService {

    public DesenvolvedoraResponseDTO insert(@Valid DesenvolvedoraDTO dto);

    public DesenvolvedoraResponseDTO update(DesenvolvedoraDTO dto, Long id);

    public void delete(Long id);

    public DesenvolvedoraResponseDTO findById(Long id);

    public List<DesenvolvedoraResponseDTO> findByNome(String nome);

    public List<DesenvolvedoraResponseDTO> findByAll();

}
