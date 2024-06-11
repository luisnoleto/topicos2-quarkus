package br.unitins.topicos1.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.desenvolvedora.DesenvolvedoraResponseDTO;
import br.unitins.topicos1.dto.pais.PaisDTO;
import br.unitins.topicos1.dto.pais.PaisResponseDTO;
import br.unitins.topicos1.model.Desenvolvedora;
import br.unitins.topicos1.model.Pais;
import br.unitins.topicos1.repository.PaisRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class PaisServiceImpl implements PaisService {

    @Inject
    PaisRepository repository;

    @Override
    @Transactional
    public PaisResponseDTO insert(@Valid PaisDTO dto) {
        Pais novoPais = new Pais();
        novoPais.setNome(dto.nome());
        novoPais.setSigla(dto.sigla());

        repository.persist(novoPais);

        return PaisResponseDTO.valueOf(novoPais);
    }

    @Override
    @Transactional
    public PaisResponseDTO update(PaisDTO dto, Long id) {

        Pais pais = repository.findById(id);
        if (pais != null) {
            pais.setNome(dto.nome());
            pais.setSigla(dto.sigla());
        } else
            throw new NotFoundException();

        return PaisResponseDTO.valueOf(pais);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public PaisResponseDTO findById(Long id) {
        return PaisResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<PaisResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> PaisResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<PaisResponseDTO> getAll(int page, int pageSize) {
        List<Pais> paises = repository.findAll().page(page, pageSize).list();

        return paises.stream()
                .map(e -> PaisResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return repository.count();
    }

     @Override
    public PaisResponseDTO alterarSituacao(Long id) {
        Pais pais = repository.findById(id);

        if (pais.isAtivo() == true) {
            pais.setAtivo(false);
        } else {
            pais.setAtivo(true);

        }

        return PaisResponseDTO.valueOf(pais);
    }
}   
