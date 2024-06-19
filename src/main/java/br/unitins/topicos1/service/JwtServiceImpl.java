package br.unitins.topicos1.service;

import java.time.Duration;
import java.time.Instant;
import br.unitins.topicos1.dto.usuario.UsuarioResponseDTO;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class JwtServiceImpl implements JwtService {

    private static final Duration EXPIRATION_TIME = Duration.ofHours(24);

    @Inject
    UsuarioService usuarioService;

    @Override
    public String generateJwt(UsuarioResponseDTO usuario) {
        Instant now = Instant.now();
        Instant expiryDate = now.plus(EXPIRATION_TIME);

        String role = usuarioService.getPerfilLabel(usuario.perfil());

        return Jwt.issuer("unitins-jwt")
                .subject(usuario.login())
                .groups(role)
                .expiresAt(expiryDate)
                .sign();
    }
}
