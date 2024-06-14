package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.usuario.CadastroUsuarioResponseDTO;
import br.unitins.topicos1.dto.usuario.UsuarioResponseDTO;
import br.unitins.topicos1.model.Usuario;

public interface JwtService {

    public String generateJwt(UsuarioResponseDTO dto);
}