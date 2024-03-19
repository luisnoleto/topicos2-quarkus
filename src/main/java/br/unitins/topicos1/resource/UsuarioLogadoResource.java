package br.unitins.topicos1.resource;

import java.io.IOException;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.logging.Logger;

import br.unitins.topicos1.service.FileService;
import br.unitins.topicos1.service.JogoService;
import br.unitins.topicos1.service.UsuarioService;
import br.unitins.topicos1.application.Error;
import br.unitins.topicos1.dto.endereco.EnderecoDTO;
import br.unitins.topicos1.dto.jogo.JogoResponseDTO;
import br.unitins.topicos1.dto.usuario.CadastroUsuarioDTO;
import br.unitins.topicos1.dto.usuario.CadastroUsuarioResponseDTO;
import br.unitins.topicos1.dto.usuario.UpdateEmailDTO;
import br.unitins.topicos1.dto.usuario.UpdateNomeDTO;
import br.unitins.topicos1.dto.usuario.UpdateSenhaDTO;
import br.unitins.topicos1.dto.usuario.UpdateTelefoneDTO;
import br.unitins.topicos1.dto.usuario.UsuarioDTO;
import br.unitins.topicos1.dto.usuario.UsuarioResponseDTO;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.UsuarioRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;


@Path("/usuariologado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class UsuarioLogadoResource {

    @Inject
    JsonWebToken jwt;

    @Inject
    UsuarioService usuarioService;

    @Inject
    FileService usuarioFileService;

    @Inject
    JogoService jogoService;

    @Inject
    UsuarioRepository usuarioRepository;

    private static final Logger LOG = Logger.getLogger(UsuarioLogadoResource.class);

    @GET
    @Path("/meusdados")
    @RolesAllowed({ "User", "Admin" })
    public Response getUsuario() {

        String login = jwt.getSubject();


        return Response.ok(usuarioService.findByLogin(login)).build();
    }

    @POST
    @Path("/cadastro")
    @RolesAllowed("Admin")
    public Response cadastrarUsuario(@Valid CadastroUsuarioDTO dto) {
        LOG.info("Iniciando a inserção de usuario");

        if (usuarioRepository.findByLogin(dto.login()) != null) {
            LOG.info("Usuario não inserido, login já existente");
        } else
            LOG.info("Usuario inserido");


        CadastroUsuarioResponseDTO retorno = usuarioService.cadastrarUsuario(dto);

        LOG.infof("Terminando a inserção do usuario", dto.nome());
        return Response.status(201).entity(retorno).build();
    }

    @PATCH
    @Path("/alterar/senha")
    @RolesAllowed({ "User", "Admin" })
    public Response updateSenha(@Valid UpdateSenhaDTO dto){
        LOG.info("Iniciando  o Update de senha");

        String login = jwt.getSubject();

        UsuarioResponseDTO retorno = usuarioService.updateSenha(dto, login);
        


        return Response.status(201).entity(retorno).build();
    }

    @PATCH
    @Path("/alterar/nome")
    @RolesAllowed({ "User", "Admin" })
    public Response updateNome(@Valid UpdateNomeDTO dto){
        LOG.info("Iniciando a o Update de nome");
        String login = jwt.getSubject();

        UsuarioResponseDTO retorno = usuarioService.updateNome(dto, login);
        
      
        return Response.status(201).entity(retorno).build();
    }

    @PATCH
    @Path("/alterar/email")
    @RolesAllowed({ "User", "Admin" })
    public Response updateEmail(@Valid UpdateEmailDTO dto){
        LOG.info("Iniciando a o Update de email");
        String login = jwt.getSubject();

        UsuarioResponseDTO retorno = usuarioService.updateEmail(dto, login);
        LOG.info("Encerrando o update de email");        
        return Response.status(201).entity(retorno).build();
    }

    @PATCH
    @Path("/alterar/telefone")
    @RolesAllowed({ "User", "Admin" })
    public Response updateTelefone(@Valid UpdateTelefoneDTO dto){
        LOG.info("Iniciando a o Update de telefone");
        String login = jwt.getSubject();

        UsuarioResponseDTO retorno = usuarioService.updateTelefone(dto, login);

        return Response.status(201).entity(retorno).build();
    }

    // --------------------------------- 

}
