package br.unitins.topicos1.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.telefone.TelefoneDTO;
import br.unitins.topicos1.dto.usuario.CadastroUsuarioDTO;
import br.unitins.topicos1.dto.usuario.CadastroUsuarioResponseDTO;
import br.unitins.topicos1.dto.usuario.PerfilDTO;
import br.unitins.topicos1.dto.usuario.UpdateEmailDTO;
import br.unitins.topicos1.dto.usuario.UpdateNomeDTO;
import br.unitins.topicos1.dto.usuario.UpdateSenhaDTO;
import br.unitins.topicos1.dto.usuario.UpdateTelefoneDTO;
import br.unitins.topicos1.dto.usuario.UsuarioDTO;
import br.unitins.topicos1.dto.usuario.UsuarioResponseDTO;
import br.unitins.topicos1.model.Perfil;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.UsuarioRepository;
import br.unitins.topicos1.validation.ValidationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    UsuarioRepository repository;

    @Inject
    HashService hashService;

    @Inject
    JwtService jwtService;

    @Override
    @Transactional
    public UsuarioResponseDTO insert(@Valid UsuarioDTO dto) {

        if (repository.findByLogin(dto.login()) != null) {
            throw new ValidationException("login", "Login já existe.");
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(dto.nome());
        novoUsuario.setLogin(dto.login());
        novoUsuario.setCpf(dto.cpf());
        novoUsuario.setEmail(dto.email());
        novoUsuario.setSenha(hashService.getHashSenha(dto.senha()));
        // novoUsuario.setDataNascimento(dto.dataNascimento());

        novoUsuario.setPerfil(Perfil.ValueOf(1));

        if (dto.listaTelefone() != null &&
                !dto.listaTelefone().isEmpty()) {
            novoUsuario.setListaTelefone(new ArrayList<Telefone>());
            for (TelefoneDTO tel : dto.listaTelefone()) {
                Telefone telefone = new Telefone();
                telefone.setCodigoArea(tel.codigoArea());
                telefone.setNumero(tel.numero());
                novoUsuario.getListaTelefone().add(telefone);
                telefone.setUsuario(novoUsuario);
            }
        }

        repository.persist(novoUsuario);

        return UsuarioResponseDTO.valueOf(novoUsuario);
    }

    @Override
    @Transactional
    public CadastroUsuarioResponseDTO cadastrarUsuario(@Valid CadastroUsuarioDTO dto) {

        if (repository.findByLogin(dto.login()) != null) {
            throw new ValidationException("login", "Login já existe.");
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(dto.nome());
        novoUsuario.setLogin(dto.login());
        novoUsuario.setCpf(dto.cpf());
        novoUsuario.setEmail(dto.email());
        novoUsuario.setSenha(hashService.getHashSenha(dto.senha()));
        novoUsuario.setPerfil(Perfil.ValueOf(dto.perfil()));
        // novoUsuario.setDataNascimento(dto.dataNascimento());

        if (dto.listaTelefone() != null &&
                !dto.listaTelefone().isEmpty()) {
            novoUsuario.setListaTelefone(new ArrayList<Telefone>());
            for (TelefoneDTO tel : dto.listaTelefone()) {
                Telefone telefone = new Telefone();
                telefone.setCodigoArea(tel.codigoArea());
                telefone.setNumero(tel.numero());
                novoUsuario.getListaTelefone().add(telefone);
            }
        }

        repository.persist(novoUsuario);

        return CadastroUsuarioResponseDTO.valueOf(novoUsuario);
    }

    @Override
    @Transactional
    public PerfilDTO perfilNome(String login) {
        Usuario usuario = repository.findByLogin(login);
        if (usuario == null) {
            return new PerfilDTO(1, "USER");
        }

        Perfil perfil = usuario.getPerfil();
        return new PerfilDTO(perfil.ordinal() + 1, perfil.name());
    }

    @Override
    @Transactional
    public List<PerfilDTO> findAllPerfis() {
        return Arrays.stream(Perfil.values())
                .map(perfil -> new PerfilDTO(perfil.ordinal() + 1, perfil.name()))
                .collect(Collectors.toList());
    }

    // -------------------------------------------- UPDATE's usuario normal e com
    // jwt --------------------------------------------
    @Override
    @Transactional
    public UsuarioResponseDTO update(@Valid UsuarioDTO dto, Long id) {
        Usuario usuario = repository.findById(id);
        usuario.setLogin(dto.login());
        usuario.setNome(dto.nome());
        usuario.setCpf(dto.cpf());
        usuario.setSenha(dto.senha());

        List<Telefone> telefones = new ArrayList<Telefone>();

        if (dto.listaTelefone() != null && !dto.listaTelefone().isEmpty()) {
            usuario.setListaTelefone(new ArrayList<Telefone>());
            for (TelefoneDTO tel : dto.listaTelefone()) {
                Telefone telefone = new Telefone();

                telefone.setCodigoArea(tel.codigoArea());
                telefone.setNumero(tel.numero());

                telefones.add(telefone);
            }
        }

        usuario.setListaTelefone(telefones);

        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO updateSenha(@Valid UpdateSenhaDTO dto, String login) {

        Usuario usuario = repository.findByLogin(login);

        // Pedindo a senha do usuario como medida de proteção
        if (usuario.getSenha().equals(hashService.getHashSenha(dto.senhaAtual()))) {
            usuario.setSenha(hashService.getHashSenha(dto.novaSenha()));

        } else
            throw new ValidationException("Senha", "Senha atual incorreta.");

        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    @Transactional
    public UsuarioResponseDTO updateNome(@Valid UpdateNomeDTO dto, String login) {

        Usuario usuario = repository.findByLogin(login);

        // Pedindo a senha do usuario como medida de proteção
        if (usuario.getSenha().equals(hashService.getHashSenha(dto.senhaAtual()))) {
            usuario.setNome(dto.nome());

        } else
            throw new ValidationException("Senha", "Senha atual incorreta. ");

        return UsuarioResponseDTO.valueOf(usuario);

    }

    @Override
    @Transactional
    public UsuarioResponseDTO updateEmail(@Valid UpdateEmailDTO dto, String login) {

        Usuario usuario = repository.findByLogin(login);

        // Pedindo a senha do usuario como medida de proteção
        if (usuario.getSenha().equals(hashService.getHashSenha(dto.senhaAtual()))) {
            usuario.setEmail(dto.email());

        } else
            throw new ValidationException("Senha", "Senha atual incorreta. ");

        return UsuarioResponseDTO.valueOf(usuario);

    }

    @Override
    @Transactional
    public UsuarioResponseDTO updateTelefone(@Valid UpdateTelefoneDTO dto, String login) {

        Usuario usuario = repository.findByLogin(login);

        usuario.getListaTelefone().clear();

        List<Telefone> telefones = usuario.getListaTelefone();

        if (usuario.getSenha().equals(hashService.getHashSenha(dto.senhaAtual()))) {
            usuario.setListaTelefone(new ArrayList<Telefone>());
            for (TelefoneDTO tel : dto.listaTelefones()) {
                Telefone telefone = new Telefone();

                telefone.setCodigoArea(tel.codigoArea());
                telefone.setNumero(tel.numero());

                telefones.add(telefone);

                usuario.setListaTelefone(telefones);

            }

        } else
            throw new ValidationException("Senha", "Senha atual incorreta. ");

        return UsuarioResponseDTO.valueOf(usuario);
    }

    // -------------------------------------------- FIND's e afins
    // --------------------------------------------
    @Override
    @Transactional
    public void delete(Long id) {
        Usuario usuario = repository.findById(id);

        repository.delete(usuario);
    }

    @Override
    public UsuarioResponseDTO findById(Long id) {
        return UsuarioResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<UsuarioResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome)
                .stream()
                .map(e -> UsuarioResponseDTO.valueOf(e))
                .toList();
    }

    @Override
    public List<UsuarioResponseDTO> getAll(int page, int pageSize) {
        List<Usuario> usuarios = repository.findAll().page(page, pageSize).list();

        return usuarios.stream()
                .map(e -> UsuarioResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    public Usuario findByLoginAndSenha(String login, String senha) {
        if (login == null || senha == null)
            throw new ValidationException("login", "Login ou senha inválido");
        return repository.findByLoginAndSenha(login, senha);
    }

    @Override
    public CadastroUsuarioResponseDTO findByLoginAndSenhaPerfil(String login, String senha) {
        Usuario usuario = repository.findByLoginAndSenha(login, senha);
        if (usuario == null)
            throw new ValidationException("login", "Login ou senha inválido");

        return CadastroUsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    public UsuarioResponseDTO findByLogin(String login) {
        Usuario usuario = repository.findByLogin(login);
        if (usuario == null)
            throw new ValidationException("login", "Login inválido");

        return UsuarioResponseDTO.valueOf(usuario);
    }

    @Override
    public long count() {
        return repository.count();
    }

    public String getPerfilLabel(int perfilId) {

        switch (perfilId) {
            case 1:
                return "User";
            case 2:
                return "Admin";
            default:
                return "Admin";
        }

    }
}