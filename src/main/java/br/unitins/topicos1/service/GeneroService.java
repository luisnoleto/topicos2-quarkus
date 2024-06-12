package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.genero.GeneroDTO;
import br.unitins.topicos1.dto.genero.GeneroResponseDTO;
import jakarta.validation.Valid;

public interface GeneroService {

    public GeneroResponseDTO insert(@Valid GeneroDTO dto);

    public GeneroResponseDTO update(GeneroDTO dto, Long id);

    public void delete(Long id);

    public GeneroResponseDTO findById(Long id);

    public List<GeneroResponseDTO> findByNome(String nome);

    public List<GeneroResponseDTO> findByAll(int page, int pageSize);

    public long count();

    GeneroResponseDTO alterarSituacao(Long id);

    List<GeneroResponseDTO> findByAtivo(boolean ativo);
}
