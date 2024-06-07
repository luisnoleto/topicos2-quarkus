package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.desenvolvedora.DesenvolvedoraDTO;
import br.unitins.topicos1.dto.desenvolvedora.DesenvolvedoraResponseDTO;
import br.unitins.topicos1.service.DesenvolvedoraService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/desenvolvedora")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DesenvoledoraResource {

    @Inject
    DesenvolvedoraService service;

    private static final Logger LOG = Logger.getLogger(DesenvoledoraResource.class);

    @POST
    @Path("/cadastro")
    @RolesAllowed("Admin")
    public Response insert(DesenvolvedoraDTO dto) {
        LOG.info("Iniciando insert desenvolvedora");
        DesenvolvedoraResponseDTO retorno = service.create(dto);
        // return Response.status(Status.CREATED).entity(retorno).build();
        return Response.status(201).entity(retorno).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    @RolesAllowed("Admin")
    public Response update(DesenvolvedoraDTO dto, @PathParam("id") Long id) {
        service.update(dto, id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    @RolesAllowed("Admin")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @RolesAllowed("Admin")
    public Response findAll(
        @QueryParam("page") @DefaultValue("0") int page,
        @QueryParam("pageSize") @DefaultValue("100") int pageSize) {
            
        return Response.ok(service.getAll(page, pageSize)).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }

    @GET
    @RolesAllowed("Admin")
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(service.findByNome(nome)).build();
    }

    @GET
    @RolesAllowed("Admin")
    @Path("/count")
    public long count() {
        return service.count();
    }

    @PATCH
    @Transactional
    @Path("/alterarSituacao/{id}")
    @RolesAllowed("Admin")
    public Response alterarSituacao(@PathParam("id") Long id) {
        return Response.ok(service.alterarSituacao(id)).build();
    }

}
