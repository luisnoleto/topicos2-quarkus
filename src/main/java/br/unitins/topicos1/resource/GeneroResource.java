package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.genero.GeneroDTO;
import br.unitins.topicos1.dto.genero.GeneroResponseDTO;
import br.unitins.topicos1.service.GeneroService;
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

@Path("/generos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GeneroResource {

    @Inject
    GeneroService service;

    private static final Logger LOG = Logger.getLogger(GeneroResource.class);

    @POST
    @RolesAllowed({ "Admin" })
    public Response insert(GeneroDTO dto) {
        LOG.info("Iniciando insert genero");
        GeneroResponseDTO retorno = service.insert(dto);
        // return Response.status(Status.CREATED).entity(retorno).build();
        return Response.status(201).entity(retorno).build();
    }

    @PUT
    @Transactional
    @Path("/{id}")
    @RolesAllowed({ "Admin" })
    public Response update(GeneroDTO dto, @PathParam("id") Long id) {
        service.update(dto, id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    @RolesAllowed({ "Admin" })
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @RolesAllowed({ "Admin" })
    public Response findAll(
        @QueryParam("page") @DefaultValue("0") int page, 
        @QueryParam("pageSize") @DefaultValue("100") int pageSize
    ) {
        LOG.debug("Encontrando Países.");
        return Response.ok(service.findByAll(page, pageSize)).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({ "Admin" })
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(service.findById(id)).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    @RolesAllowed({ "Admin" })
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(service.findByNome(nome)).build();
    }

    @GET
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

    @GET
    @RolesAllowed("Admin")
    @Path("/search/ativo/{ativo}")
    public Response findByAtivo(@PathParam("ativo") boolean ativo) {
        return Response.ok(service.findByAtivo(ativo)).build();
    }

}
