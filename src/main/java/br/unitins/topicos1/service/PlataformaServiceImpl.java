package br.unitins.topicos1.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.plataforma.PlataformaDTO;
import br.unitins.topicos1.dto.plataforma.PlataformaResponseDTO;
import br.unitins.topicos1.model.Plataforma;
import br.unitins.topicos1.model.Fabricante;
import br.unitins.topicos1.repository.PlataformaRepository;
import br.unitins.topicos1.repository.FabricanteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PlataformaServiceImpl implements PlataformaService {

    @Inject
    PlataformaRepository repository;

    @Inject
    FabricanteRepository FabricanteRepository;

    @Override
    @Transactional
    public PlataformaResponseDTO insert(@Valid PlataformaDTO dto) {
        Plataforma novoPlataforma = new Plataforma();
        novoPlataforma.setNome(dto.nome());

        Fabricante fabricante = FabricanteRepository.findById(dto.fabricante());
        novoPlataforma.setFabricante(fabricante);

        repository.persist(novoPlataforma);

        return PlataformaResponseDTO.valueOf(novoPlataforma);
    }

    @Override
    @Transactional
    public PlataformaResponseDTO update(PlataformaDTO dto, Long id) {

        Plataforma plataforma = repository.findById(id);

        if (plataforma != null) {
            plataforma.setNome(dto.nome());
            plataforma.setFabricante(FabricanteRepository.findById(dto.fabricante()));

        } else {
            throw new NotFoundException();
        }

        return PlataformaResponseDTO.valueOf(plataforma);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public PlataformaResponseDTO findById(Long id) {
        return PlataformaResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<PlataformaResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> PlataformaResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PlataformaResponseDTO> getAll(int page, int pageSize) {
        List<Plataforma> list = repository.findAll().page(page, pageSize).list();

        return list.stream()
                .map(e -> PlataformaResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return repository.count();
    }

}
