package br.unitins.topicos1.dto.usuario;

import java.util.List;

import br.unitins.topicos1.dto.telefone.TelefoneDTO;
import br.unitins.topicos1.model.Usuario;

public record UsuarioResponseDTO(
    
    String nome,
    String login,
    String email,
    List<TelefoneDTO> listaTelefone
) { 
    public static UsuarioResponseDTO valueOf(Usuario usuario){

        return new UsuarioResponseDTO(

            usuario.getNome(),
            usuario.getLogin(),
            usuario.getEmail(),
            usuario.getListaTelefone()
                .stream()
                .map(t -> TelefoneDTO.valueOf(t)).toList()
        );
    }
}
