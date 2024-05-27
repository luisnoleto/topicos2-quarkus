package br.unitins.topicos1.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.estado.EstadoDTO;
import br.unitins.topicos1.dto.estado.EstadoResponseDTO;
import br.unitins.topicos1.model.Estado;
import br.unitins.topicos1.repository.EstadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class EstadoServiceImpl implements EstadoService {

    @Inject
    EstadoRepository repository;

    @Override
    @Transactional
    public EstadoResponseDTO create(@Valid EstadoDTO dto) {
        Estado novoEstado = new Estado();
        novoEstado.setNomeEstado(dto.nome());
        novoEstado.setSigla(dto.sigla());

        repository.persist(novoEstado);

        return EstadoResponseDTO.valueOf(novoEstado);
    }

    @Override
    @Transactional
    public EstadoResponseDTO update(Long id, EstadoDTO dto) {
        
        Estado estado = repository.findById(id);
        if (estado != null) {
            estado.setNomeEstado(dto.nome());
            estado.setSigla(dto.sigla());
        } else 
            throw new NotFoundException();

        return EstadoResponseDTO.valueOf(estado);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Estado estado = repository.findById(id);

        if (estado == null) {
            throw new NotFoundException();
        } 
        repository.delete(estado);

    }

    @Override
    public EstadoResponseDTO findById(Long id) {
        return EstadoResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<EstadoResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
            .map(e -> EstadoResponseDTO.valueOf(e)).toList();
    }

  @Override
    public List<EstadoResponseDTO> getAll(int page, int pageSize) {
        List<Estado> list = repository
                                .findAll()
                                .page(page, pageSize)
                                .list();
        
        return list.stream().map(e -> EstadoResponseDTO.valueOf(e)).collect(Collectors.toList());
    } 

    @Override
    public long count() {
        return repository.count();
    }
}
