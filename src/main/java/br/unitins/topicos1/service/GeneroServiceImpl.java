package br.unitins.topicos1.service;

import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.genero.GeneroDTO;
import br.unitins.topicos1.dto.genero.GeneroResponseDTO;
import br.unitins.topicos1.model.Genero;
import br.unitins.topicos1.repository.GeneroRepository;
import br.unitins.topicos1.repository.PaisRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class GeneroServiceImpl implements GeneroService {

    @Inject
    GeneroRepository repository;

    @Inject
    PaisRepository PaisRepository;

    @Override
    @Transactional
    public GeneroResponseDTO insert(@Valid GeneroDTO dto) {
        Genero novoGenero = new Genero();
        novoGenero.setNome(dto.nome());

        repository.persist(novoGenero);

        return GeneroResponseDTO.valueOf(novoGenero);
    }

    @Override
    @Transactional
    public GeneroResponseDTO update(GeneroDTO dto, Long id) {

        Genero genero = repository.findById(id);
        if (genero != null) {
            genero.setNome(dto.nome());

        } else {
            throw new NotFoundException();
        }

        return GeneroResponseDTO.valueOf(genero);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public GeneroResponseDTO findById(Long id) {
        return GeneroResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<GeneroResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> GeneroResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<GeneroResponseDTO> findByAll(int page, int pageSize) {
        List<Genero> generos = repository.findAll().page(page, pageSize).list();

        return generos.stream()
                .map(e -> GeneroResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public GeneroResponseDTO alterarSituacao(Long id) {
        Genero genero = repository.findById(id);

        if (genero.isAtivo() == true) {
            genero.setAtivo(false);
        } else {
            genero.setAtivo(true);

        }

        return GeneroResponseDTO.valueOf(genero);
    }

    @Override
    public List<GeneroResponseDTO> findByAtivo(boolean ativo) {
        return repository.findByAtivo(ativo).stream()
                .map(e -> GeneroResponseDTO.valueOf(e)).toList();
    }

}
