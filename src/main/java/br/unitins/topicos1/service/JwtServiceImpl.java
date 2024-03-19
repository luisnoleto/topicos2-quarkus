package br.unitins.topicos1.service;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import br.unitins.topicos1.dto.usuario.UsuarioResponseDTO;
import br.unitins.topicos1.model.Perfil;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JwtServiceImpl implements JwtService {

    private static final Duration EXPIRATION_TIME = Duration.ofHours(24);

    @Override
    public String generateJwt(UsuarioResponseDTO dto) {
        Instant now = Instant.now();
        Instant expiryDate = now.plus(EXPIRATION_TIME);


        Set<String> roles = new HashSet<String>();
        roles.add(Perfil.ValueOf(1).getLabel());
        roles.add(Perfil.ValueOf(2).getLabel());

        return Jwt.issuer("unitins-jwt")
            .subject(dto.login())
            .groups(roles)
            .expiresAt(expiryDate)
            .sign();
    }
    
}