package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.usuario.UsuarioDTO;
import br.unitins.topicos1.dto.usuario.UsuarioResponseDTO;
import br.unitins.topicos1.dto.usuario.CadastroUsuarioDTO;
import br.unitins.topicos1.dto.usuario.CadastroUsuarioResponseDTO;
import br.unitins.topicos1.dto.usuario.PerfilDTO;
import br.unitins.topicos1.dto.usuario.UpdateEmailDTO;
import br.unitins.topicos1.dto.usuario.UpdateNomeDTO;
import br.unitins.topicos1.dto.usuario.UpdateSenhaDTO;
import br.unitins.topicos1.dto.usuario.UpdateTelefoneDTO;
import jakarta.validation.Valid;

public interface UsuarioService {

    UsuarioResponseDTO insert(@Valid UsuarioDTO dto);

    UsuarioResponseDTO update(@Valid UsuarioDTO dto, Long id);

    void delete(Long id);

    UsuarioResponseDTO findById(Long id);

    List<UsuarioResponseDTO> findByNome(String nome);

    UsuarioResponseDTO findByLoginAndSenha(String login, String senha);

    UsuarioResponseDTO findByLogin(String login);

    List<UsuarioResponseDTO> getAll(int page, int pageSize);

    long count();

    UsuarioResponseDTO updateSenha(@Valid UpdateSenhaDTO dto, String login);

    UsuarioResponseDTO updateNome(@Valid UpdateNomeDTO dto, String login);

    UsuarioResponseDTO updateEmail(@Valid UpdateEmailDTO dto, String login);

    UsuarioResponseDTO updateTelefone(@Valid UpdateTelefoneDTO dto, String login);

    CadastroUsuarioResponseDTO cadastrarUsuario(@Valid CadastroUsuarioDTO dto);

    CadastroUsuarioResponseDTO findByLoginAndSenhaPerfil(String login, String hashSenha);

    PerfilDTO perfilNome(String login);

    List<PerfilDTO> findAllPerfis();

}
