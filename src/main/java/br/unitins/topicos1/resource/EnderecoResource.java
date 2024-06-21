package br.unitins.topicos1.resource;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.endereco.EnderecoDTO;
import br.unitins.topicos1.service.EnderecoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/endereco")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnderecoResource {

    @Inject
    EnderecoService service;

    @Inject
    JsonWebToken jwt;

    private static final Logger LOG = Logger.getLogger(EnderecoResource.class);

    @GET
    @RolesAllowed({ "User", "Admin" })
    public Response findByAll() {
        LOG.info("Listando todos os endereços.");
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({ "User", "Admin" })
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Listando o endereço do id %s", id);
        return Response.ok(service.findById(id)).build();
    }

    @GET
    @Path("/cep/{cep}")
    @RolesAllowed({ "User", "Admin" })
    public Response findByCep(@PathParam("cep") String cep) {
        LOG.infof("Listando o endereço do cep %s", cep);
        return Response.ok(service.findByCep(cep)).build();
    }

    @POST
    @Path("/insere-endereco")
    @RolesAllowed({ "User", "Admin" })
    public Response insert(EnderecoDTO dto) {
        LOG.info("Inserindo endereço.");
        String login = jwt.getSubject();
        LOG.info("quero saber se pegou o user" + login);
        return Response.status(Status.CREATED).entity(service.insert(dto, login)).build();
    }

    @PUT
    @Transactional
    @Path("/atualiza-endereco/{id}/{idEndereco}")
    @RolesAllowed({ "User", "Admin" })
    public Response update(EnderecoDTO dto, @PathParam("id") Long id, @PathParam("idEndereco") Long idEndereco) {
        LOG.info("Atualizando o endereço.");
        service.update(idEndereco, id, dto);

        LOG.info("Finalizando a atualização do endereço.");
        return Response.noContent().build();
    }

    @DELETE
    @Transactional
    @Path("/deleta-endereco/{id}/{idEndereco}")
    @RolesAllowed({ "User", "Admin" })
    public Response delete(@PathParam("id") Long id, @PathParam("idEndereco") Long idEndereco) {
        LOG.infof("Deletando endereço %s", idEndereco);
        service.delete(id, idEndereco);

        LOG.info("Endereço deletado.");
        return Response.noContent().build();
    }

    @GET
    @Path("/usuario/{id}")
    public Response findByUser(@PathParam("id") Long id) {
        LOG.infof("Listando os endereços do usuário %s", id);
        return Response.ok(service.findByUser(id)).build();
    }

}
