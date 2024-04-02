package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.requisito.RequisitoDTO;
import br.unitins.topicos1.dto.requisito.RequisitoResponseDTO;
import br.unitins.topicos1.model.Requisito;
import br.unitins.topicos1.model.Desempenho;
import br.unitins.topicos1.model.Pais;
import br.unitins.topicos1.repository.RequisitoRepository;
import br.unitins.topicos1.repository.PaisRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class RequisitoServiceImpl implements RequisitoService {

    @Inject
    RequisitoRepository repository;

    @Inject
    PaisRepository PaisRepository;

    @Override
    @Transactional
    public RequisitoResponseDTO insert(@Valid RequisitoDTO dto) {
        Requisito novoRequisito = new Requisito();
        novoRequisito.setArmazenamento(dto.armazenamento());
        novoRequisito.setMemoria(dto.memoria());
        novoRequisito.setPlacaVideo(dto.placaVideo());
        novoRequisito.setProcessador(dto.processador());
        novoRequisito.setSistemaOperacional(dto.sistemaOperacional());
        //novoRequisito.setDesempenho();


        repository.persist(novoRequisito);

        return RequisitoResponseDTO.valueOf(novoRequisito);
    }

    @Override
    @Transactional
    public RequisitoResponseDTO update(RequisitoDTO dto, Long id) {

        Requisito requisito = repository.findById(id);
        if (requisito != null) {
            requisito.setArmazenamento(dto.armazenamento());
            requisito.setMemoria(dto.memoria());
            requisito.setPlacaVideo(dto.placaVideo());
            requisito.setProcessador(dto.processador());
            requisito.setSistemaOperacional(dto.sistemaOperacional());
            //requisito.setDesempenho();

        } else {
            throw new NotFoundException();
        }

        return RequisitoResponseDTO.valueOf(requisito);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public RequisitoResponseDTO findById(Long id) {
        return RequisitoResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<RequisitoResponseDTO> findByRequisito(String desempenho) {
        return repository.findByRequisitos(desempenho).stream()
                .map(e -> RequisitoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<RequisitoResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> RequisitoResponseDTO.valueOf(e)).toList();
    }

}
