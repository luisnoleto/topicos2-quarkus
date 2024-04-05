package br.unitins.topicos1.dto.usuario;

import java.util.Date;
import java.util.List;

import br.unitins.topicos1.dto.telefone.TelefoneDTO;
import br.unitins.topicos1.model.Perfil;
import br.unitins.topicos1.model.Usuario;

public record CadastroUsuarioResponseDTO(

        Long id,
        String nome,
        String login,
        String email,
        String cpf,
        PerfilDTO perfil,

        // Date dataNascimento,

        List<TelefoneDTO> listaTelefone) {
    public static CadastroUsuarioResponseDTO valueOf(Usuario usuario) {

        return new CadastroUsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getLogin(),
                usuario.getEmail(),
                usuario.getCpf(),
                PerfilDTO.valueOf(usuario.getPerfil()),
                // usuario.getDataNascimento(),
                usuario.getListaTelefone()
                        .stream()
                        .map(t -> TelefoneDTO.valueOf(t)).toList());
    }
}
