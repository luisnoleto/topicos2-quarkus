package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.usuario.CadastroUsuarioResponseDTO;
import br.unitins.topicos1.dto.usuario.LoginDTO;
import br.unitins.topicos1.dto.usuario.UsuarioResponseDTO;
import br.unitins.topicos1.service.HashService;
import br.unitins.topicos1.service.JwtService;
import br.unitins.topicos1.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

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
    public Response login(@Valid LoginDTO dto) {
    
        String hashSenha = hashService.getHashSenha(dto.senha());

        CadastroUsuarioResponseDTO result = null;
        if(dto.perfil() == 1)
            result = service.findByLoginAndSenhaPerfil(dto.login(), hashSenha);
        else if(dto.perfil()==2){
            result = service.findByLoginAndSenhaPerfil(dto.login(), hashSenha);
        } else{
            return Response.status(Status.NOT_FOUND).entity("Perfil não encontrado.").build();
        }

        return Response.ok(result).header("Authorization", jwtService.generateJwt(result)).build();
    }

}
