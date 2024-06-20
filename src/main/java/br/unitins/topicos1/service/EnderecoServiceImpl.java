package br.unitins.topicos1.service;

import java.util.List;
import br.unitins.topicos1.dto.endereco.EnderecoDTO;
import br.unitins.topicos1.dto.endereco.EnderecoResponseDTO;
import br.unitins.topicos1.model.Cidade;
import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.CidadeRepository;
import br.unitins.topicos1.repository.EnderecoRepository;
import br.unitins.topicos1.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class EnderecoServiceImpl implements EnderecoService {

    @Inject
    UsuarioRepository repositoryUser;

    @Inject
    EnderecoRepository repositoryEnd;

    @Inject
    CidadeRepository repositoryCidade;

    @Inject
    UsuarioService usuarioService;

    @Override
    @Transactional
    public EnderecoResponseDTO insert(@Valid EnderecoDTO dto, String login) {
        Usuario usuario = repositoryUser.findByLogin(login);
        Cidade cidade = repositoryCidade.findById(dto.idCidade());

        if (cidade == null) {
            throw new NotFoundException("Cidade não encontrada");
        }

        Endereco endereco = new Endereco();
        endereco.setBairro(dto.bairro());
        endereco.setCep(dto.cep());
        endereco.setLogradouro(dto.logradouro());
        endereco.setNumero(dto.numero());
        endereco.setComplemento(dto.complemento());
        endereco.setCidade(cidade);

        usuario.getListaEndereco().add(endereco);

        repositoryEnd.persist(endereco);

        return EnderecoResponseDTO.valueOf(endereco);
    }

    @Override
    @Transactional
    public EnderecoResponseDTO update(Long idUsuario, Long idEndereco, @Valid EnderecoDTO dto) {
        Usuario usuario = repositoryUser.findById(idUsuario);
        Endereco endereco = repositoryEnd.findById(idEndereco);

        if (endereco == null || !usuario.getListaEndereco().contains(endereco)) {
            throw new NotFoundException("Endereço não encontrado");
        }

        Cidade cidade = repositoryCidade.findById(dto.idCidade());

        if (cidade == null) {
            throw new NotFoundException("Cidade não encontrada");
        }

        endereco.setBairro(dto.bairro());
        endereco.setCep(dto.cep());
        endereco.setLogradouro(dto.logradouro());
        endereco.setNumero(dto.numero());
        endereco.setComplemento(dto.complemento());
        endereco.setCidade(cidade);

        repositoryEnd.persist(endereco);

        return EnderecoResponseDTO.valueOf(endereco);
    }

    @Override
    public void delete(Long idUsuario, Long idEndereco) {
        Usuario usuario = repositoryUser.findById(idUsuario);
        Endereco endereco = repositoryEnd.findById(idEndereco);

        if (endereco == null || !usuario.getListaEndereco().contains(endereco)) {
            throw new NotFoundException("Endereço não encontrado");
        }

        usuario.getListaEndereco().remove(endereco);

        if (!repositoryEnd.deleteById(idEndereco)) {
            throw new NotFoundException();
        }
    }

    @Override
    public EnderecoResponseDTO findById(Long id) {
        Endereco endereco = repositoryEnd.findById(id);
        if (endereco == null) {
            throw new NotFoundException("Endereço não encontrado");
        }
        return EnderecoResponseDTO.valueOf(endereco);
    }

    @Override
    public List<EnderecoResponseDTO> findByCep(String cep) {
        return repositoryEnd.findByCep(cep).stream()
                .map(EnderecoResponseDTO::valueOf).toList();
    }

    @Override
    public List<EnderecoResponseDTO> findByAll() {
        return repositoryEnd.listAll().stream()
                .map(EnderecoResponseDTO::valueOf).toList();
    }

    @Override
    public List<EnderecoResponseDTO> findByUser(Long id) {
        Usuario usuario = repositoryUser.findById(id);
        if (usuario == null) {
            throw new NotFoundException("Usuário não encontrado");
        }
        return usuario.getListaEndereco().stream()
                .map(EnderecoResponseDTO::valueOf).toList();
    }
}
