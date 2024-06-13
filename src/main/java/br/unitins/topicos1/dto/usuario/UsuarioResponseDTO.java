package br.unitins.topicos1.dto.usuario;

import java.util.List;

import br.unitins.topicos1.dto.telefone.TelefoneDTO;
import br.unitins.topicos1.model.Usuario;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String login,
        String email,
        int perfil,
        List<TelefoneDTO> listaTelefone) {
    public static UsuarioResponseDTO valueOf(Usuario usuario) {

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getLogin(),
                usuario.getEmail(),
                usuario.getPerfil().getId(),
                usuario.getListaTelefone()
                        .stream()
                        .map(t -> TelefoneDTO.valueOf(t)).toList());
    }
}
