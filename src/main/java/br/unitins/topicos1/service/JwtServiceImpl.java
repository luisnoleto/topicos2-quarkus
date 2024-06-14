package br.unitins.topicos1.service;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.usuario.CadastroUsuarioResponseDTO;
import br.unitins.topicos1.dto.usuario.UsuarioResponseDTO;
import br.unitins.topicos1.model.Perfil;
import br.unitins.topicos1.model.Usuario;
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
