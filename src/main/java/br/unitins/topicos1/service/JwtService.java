package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.usuario.UsuarioResponseDTO;

public interface JwtService {

    public String generateJwt(UsuarioResponseDTO dto);
}