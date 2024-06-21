package br.unitins.topicos1.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.cidade.CidadeDTO;
import br.unitins.topicos1.dto.cidade.CidadeResponseDTO;
import br.unitins.topicos1.dto.desenvolvedora.DesenvolvedoraResponseDTO;
import br.unitins.topicos1.dto.genero.GeneroResponseDTO;
import br.unitins.topicos1.model.Cidade;
import br.unitins.topicos1.model.Desenvolvedora;
import br.unitins.topicos1.model.Genero;
import br.unitins.topicos1.repository.CidadeRepository;
import br.unitins.topicos1.repository.EstadoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class CidadeServiceImpl implements CidadeService {

    @Inject
    CidadeRepository cidadeRepository;

    @Inject
    EstadoRepository estadoRepository;

    @Inject
    Validator validator;


    @Override
    public List<CidadeResponseDTO> getAll(int page, int pageSize) {
        List<Cidade> desenvolvedoras = cidadeRepository
                                                        .findAll()
                                                        .page(page,pageSize)
                                                        .list();

        return desenvolvedoras.stream()
                .map(e -> CidadeResponseDTO.valueOf(e)).collect(Collectors.toList());
    }


    @Override
    public CidadeResponseDTO findById(Long id) {
        Cidade cidade = cidadeRepository.findById(id);
        if (cidade == null)
            throw new NotFoundException("Cidade não encontrada.");
        return CidadeResponseDTO.valueOf(cidade);
    }

    @Override
    @Transactional
    public CidadeResponseDTO create(CidadeDTO cidadeDTO) throws ConstraintViolationException {
        validar(cidadeDTO);

        Cidade entity = new Cidade();
        entity.setNomeCidade(cidadeDTO.nome());
        entity.setEstado(estadoRepository.findById(cidadeDTO.idEstado()));

        cidadeRepository.persist(entity);

        return CidadeResponseDTO.valueOf(entity);
    }

    @Override
    @Transactional
    public CidadeResponseDTO update(Long id, CidadeDTO cidadeDTO) throws ConstraintViolationException {
        validar(cidadeDTO);

        Cidade entity = cidadeRepository.findById(id);

        entity.setNomeCidade(cidadeDTO.nome());
        entity.setEstado(estadoRepository.findById(cidadeDTO.idEstado()));

        return CidadeResponseDTO.valueOf(entity);
    }

    private void validar(CidadeDTO cidadeDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<CidadeDTO>> violations = validator.validate(cidadeDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        cidadeRepository.deleteById(id);
    }

    @Override
    public List<CidadeResponseDTO> findByNome(String nome) {
        List<Cidade> list = cidadeRepository.findByNome(nome);
        return list.stream().map(e -> CidadeResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return cidadeRepository.count();
    }
}