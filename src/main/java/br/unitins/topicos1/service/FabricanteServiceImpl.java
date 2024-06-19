package br.unitins.topicos1.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.fabricante.FabricanteDTO;
import br.unitins.topicos1.dto.fabricante.FabricanteResponseDTO;
import br.unitins.topicos1.model.Fabricante;
import br.unitins.topicos1.repository.FabricanteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class FabricanteServiceImpl implements FabricanteService {

    @Inject
    FabricanteRepository repository;

    @Override
    @Transactional
    public FabricanteResponseDTO insert(@Valid FabricanteDTO dto) {
        Fabricante novoFabricante = new Fabricante();
        novoFabricante.setNome(dto.nome());

        repository.persist(novoFabricante);

        return FabricanteResponseDTO.valueOf(novoFabricante);
    }

    @Override
    @Transactional
    public FabricanteResponseDTO update(FabricanteDTO dto, Long id) {

        Fabricante fabricante = repository.findById(id);
        if (fabricante != null) {
            fabricante.setNome(dto.nome());

        } else {
            throw new NotFoundException();
        }

        return FabricanteResponseDTO.valueOf(fabricante);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public FabricanteResponseDTO findById(Long id) {
        return FabricanteResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<FabricanteResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> FabricanteResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<FabricanteResponseDTO> getAll(int page, int pageSize) {
        List<Fabricante> fabricantes = repository
                .findAll()
                .page(page, pageSize)
                .list();

        return fabricantes.stream()
                .map(e -> FabricanteResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public FabricanteResponseDTO alterarSituacao(Long id) {
        Fabricante fabricante = repository.findById(id);

        if (fabricante.isAtivo() == true) {
            fabricante.setAtivo(false);
        } else {
            fabricante.setAtivo(true);

        }

        return FabricanteResponseDTO.valueOf(fabricante);
    }

    @Override
    public List<FabricanteResponseDTO> findByAtivo(boolean ativo) {
        return repository.findByAtivo(ativo).stream()
                .map(e -> FabricanteResponseDTO.valueOf(e)).toList();
    }

}
