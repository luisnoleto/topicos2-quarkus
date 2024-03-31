package br.unitins.topicos1.resource;

import java.io.IOException;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.topicos1.dto.jogo.JogoDTO;
import br.unitins.topicos1.dto.jogo.JogoResponseDTO;
import br.unitins.topicos1.form.JogoImageForm;
import br.unitins.topicos1.service.FileService;
import br.unitins.topicos1.service.JogoFileService;
import br.unitins.topicos1.service.JogoService;
import br.unitins.topicos1.service.JwtService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;
import br.unitins.topicos1.application.Error;

@Path("/jogos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JogoResource {

    @Inject
    JsonWebToken jwt;

    @Inject
    JogoService jogoService;

    @Inject
    JogoFileService jogoFileService;

    @Inject
    JwtService jwtService;

    private static final Logger LOG = Logger.getLogger(JogoResource.class);

    @POST
    //@RolesAllowed({ "Admin" })
    public Response insert(@Valid JogoDTO dto) {
        return Response.status(Status.CREATED).entity(jogoService.insert(dto)).build();
    }

    @PUT
    @Path("/{id}")
   // @RolesAllowed({ "Admin" })
    public Response update(@Valid JogoDTO dto, @PathParam("id") Long id) {
        LOG.infof("Iniciando  o update do jogo %s", id);
        jogoService.update(dto, id);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
   // @RolesAllowed({ "Admin" })
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Iniciando  o delete do jogo %s", id);
        jogoService.delete(id);

        return Response.noContent().build();
    }

    @GET
    public Response findAll() {
        

        return Response.ok(jogoService.findAll()).build();
    }

    @GET
    @Path("/{id}")
   // @RolesAllowed({ "Admin" })
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Iniciando  a busca pelo jogo %s", id);

        

;
        return Response.ok(jogoService.findById(id)).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        LOG.infof("Iniciando  a busca pelo jogo %s", nome);

        return Response.ok(jogoService.findByNome(nome)).build();
    }

    
    @PATCH
    @Path("/upload/imagem/{id}")
   // @RolesAllowed({ "Admin" })
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@MultipartForm JogoImageForm form, @PathParam("id") Long id) throws IOException {
        LOG.info("Iniciando a inserção de imagem");
        String nomeImagem;
        nomeImagem = jogoFileService.salvar(form.getNomeImagem(), form.getImagem());
        JogoResponseDTO jogoDTO = jogoService.findById(id);
        jogoDTO = jogoService.updateNomeImagem(jogoDTO.id(), nomeImagem);

        return Response.ok(jogoDTO).build();
    }

    @GET
    @Path("/download/imagem/jogo/{nomeImagem}")
    //@RolesAllowed({"Admin" })
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("nomeImagem") String nomeImagem) {
        LOG.info("Iniciando a inserção download imagem");
        ResponseBuilder response = Response.ok(jogoFileService.obter(nomeImagem));
        response.header("Content-Disposition", "attachment;filename="+nomeImagem);
        return response.build();
    }
    
}
