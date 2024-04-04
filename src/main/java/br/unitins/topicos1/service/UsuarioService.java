package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.usuario.UsuarioDTO;
import br.unitins.topicos1.dto.usuario.UsuarioResponseDTO;
import br.unitins.topicos1.dto.usuario.CadastroUsuarioDTO;
import br.unitins.topicos1.dto.usuario.CadastroUsuarioResponseDTO;
import br.unitins.topicos1.dto.usuario.UpdateEmailDTO;
import br.unitins.topicos1.dto.usuario.UpdateNomeDTO;
import br.unitins.topicos1.dto.usuario.UpdateSenhaDTO;
import br.unitins.topicos1.dto.usuario.UpdateTelefoneDTO;
import jakarta.validation.Valid;

public interface UsuarioService {

    public UsuarioResponseDTO insert(@Valid UsuarioDTO dto);

    public UsuarioResponseDTO update(@Valid UsuarioDTO dto, Long id);

    public void delete(Long id);

    public UsuarioResponseDTO findById(Long id);

    public List<UsuarioResponseDTO> findByNome(String nome);

    public UsuarioResponseDTO findByLoginAndSenha(String login, String senha);

    public UsuarioResponseDTO findByLogin(String login);

    public List<UsuarioResponseDTO> findByAll();

    public UsuarioResponseDTO updateSenha(@Valid UpdateSenhaDTO dto, String login);

    public UsuarioResponseDTO updateNome(@Valid UpdateNomeDTO dto, String login);

    public UsuarioResponseDTO updateEmail(@Valid UpdateEmailDTO dto, String login);

    public UsuarioResponseDTO updateTelefone(@Valid UpdateTelefoneDTO dto, String login);

    public CadastroUsuarioResponseDTO cadastrarUsuario(@Valid CadastroUsuarioDTO dto);

    public CadastroUsuarioResponseDTO findByLoginAndSenhaPerfil(String login, String hashSenha);

}
