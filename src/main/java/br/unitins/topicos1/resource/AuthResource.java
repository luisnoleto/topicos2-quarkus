package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.usuario.LoginDTO;
import br.unitins.topicos1.dto.usuario.UsuarioResponseDTO;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.service.HashService;
import br.unitins.topicos1.service.JwtService;
import br.unitins.topicos1.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    UsuarioService service;

    @Inject
    HashService hashService;

    @Inject
    JwtService jwtService;

    private static final Logger LOG = Logger.getLogger(AuthResource.class);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(LoginDTO dto) {
        LOG.infof("Fazendo login de usuário: %s", dto.login());

        String hashSenha = hashService.getHashSenha(dto.senha());
        Usuario usuario = service.findByLoginAndSenha(dto.login(), hashSenha);

        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Usuario não encontrado").build();
        } else {
            UsuarioResponseDTO usuarioDTO = UsuarioResponseDTO.valueOf(usuario);
            return Response.ok(usuarioDTO)
                    .header("Authorization", jwtService.generateJwt(usuarioDTO))
                    .build();
        }
    }
}