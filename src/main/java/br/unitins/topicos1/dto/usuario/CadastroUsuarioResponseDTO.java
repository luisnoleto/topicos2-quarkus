package br.unitins.topicos1.dto.usuario;

import java.util.List;

import br.unitins.topicos1.dto.telefone.TelefoneDTO;
import br.unitins.topicos1.model.Usuario;

public record CadastroUsuarioResponseDTO(

        Long id,
        String nome,
        String login,
        String email,
        // Perfil perfil,

        List<TelefoneDTO> listaTelefone) {
    public static CadastroUsuarioResponseDTO valueOf(Usuario usuario) {

        return new CadastroUsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getLogin(),
                usuario.getEmail(),
                // usuario.getPerfil(),
                usuario.getListaTelefone()
                        .stream()
                        .map(t -> TelefoneDTO.valueOf(t)).toList());
    }
}
