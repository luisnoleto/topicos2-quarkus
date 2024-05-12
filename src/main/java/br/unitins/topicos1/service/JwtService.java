package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.usuario.CadastroUsuarioResponseDTO;

public interface JwtService {

    public String generateJwt(CadastroUsuarioResponseDTO dto);
}