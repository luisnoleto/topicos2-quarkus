package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.desenvolvedora.DesenvolvedoraDTO;
import br.unitins.topicos1.dto.desenvolvedora.DesenvolvedoraResponseDTO;
import br.unitins.topicos1.model.Desenvolvedora;
import br.unitins.topicos1.model.Pais;
import br.unitins.topicos1.repository.DesenvolvedoraRepository;
import br.unitins.topicos1.repository.PaisRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class DesenvolvedoraServiceImpl implements DesenvolvedoraService {

    @Inject
    DesenvolvedoraRepository repository;

    @Inject
    PaisRepository PaisRepository;

    @Override
    @Transactional
    public DesenvolvedoraResponseDTO insert(@Valid DesenvolvedoraDTO dto) {
        Desenvolvedora novoDesenvolvedora = new Desenvolvedora();
        novoDesenvolvedora.setNome(dto.nome());
        novoDesenvolvedora.setCnpj(dto.cnpj());

        Pais pais = PaisRepository.findById(dto.pais());
        novoDesenvolvedora.setPais(pais);

        repository.persist(novoDesenvolvedora);

        return DesenvolvedoraResponseDTO.valueOf(novoDesenvolvedora);
    }

    @Override
    @Transactional
    public DesenvolvedoraResponseDTO update(DesenvolvedoraDTO dto, Long id) {

        Desenvolvedora desenvolvedora = repository.findById(id);

        if (desenvolvedora != null) {
            desenvolvedora.setNome(dto.nome());
            desenvolvedora.setCnpj(dto.cnpj());
            desenvolvedora.setPais(PaisRepository.findById(dto.pais()));

        } else {
            throw new NotFoundException();
        }

        return DesenvolvedoraResponseDTO.valueOf(desenvolvedora);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public DesenvolvedoraResponseDTO findById(Long id) {
        return DesenvolvedoraResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<DesenvolvedoraResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> DesenvolvedoraResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<DesenvolvedoraResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> DesenvolvedoraResponseDTO.valueOf(e)).toList();
    }

}
