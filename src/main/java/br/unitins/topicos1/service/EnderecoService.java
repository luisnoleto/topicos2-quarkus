package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.endereco.EnderecoDTO;
import br.unitins.topicos1.dto.endereco.EnderecoResponseDTO;
import jakarta.validation.Valid;

public interface EnderecoService {

    public EnderecoResponseDTO insert(@Valid EnderecoDTO dto, String login);

    public EnderecoResponseDTO update(Long idUsuario, Long idEndereco, @Valid EnderecoDTO dto);

    public void delete(Long idUsuario, Long idEndereco);

    public EnderecoResponseDTO findById(Long id);

    public List<EnderecoResponseDTO> findByCep(String cep);

    public List<EnderecoResponseDTO> findByUser(Long id);

    public List<EnderecoResponseDTO> findByAll();

}
