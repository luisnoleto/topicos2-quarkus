package br.unitins.topicos1.service;
import java.util.List;

import br.unitins.topicos1.dto.cidade.CidadeDTO;
import br.unitins.topicos1.dto.cidade.CidadeResponseDTO;

public interface CidadeService {

        // recursos basicos
        List<CidadeResponseDTO> getAll();

        CidadeResponseDTO findById(Long id);
    
        CidadeResponseDTO create(CidadeDTO dto);
    
        CidadeResponseDTO update(Long id, CidadeDTO dto);
    
        void delete(Long id);
    
        // recursos extras
    
        List<CidadeResponseDTO> findByNome(String nome);
    
        long count();
}