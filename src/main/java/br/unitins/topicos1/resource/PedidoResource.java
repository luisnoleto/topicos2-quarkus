package br.unitins.topicos1.resource;

import br.unitins.topicos1.dto.pedido.PedidoDTO;
import br.unitins.topicos1.dto.pedido.PedidoResponseDTO;

import br.unitins.topicos1.service.PedidoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.util.List;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

@Path("/pedidos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {

    @Inject
    PedidoService service;

    @Inject
    JsonWebToken jwt;

    private static final Logger LOG = Logger.getLogger(PedidoResource.class);

    @POST
    @Path("/fazendopedido")
    @RolesAllowed({ "User", "Admin" })
    public Response insert(@Valid PedidoDTO dto) {
        LOG.info("Iniciando inserção de Pedido");
        String login = jwt.getSubject();
        LOG.infof("usuario logado %s", login);
        PedidoResponseDTO retorno = service.insert(login,dto);
        LOG.info("Finalizando o processo de pedido.");
        return Response.status(201).entity(retorno).build();
    }



    @GET
    @RolesAllowed({ "User", "Admin" })
    public Response findByAll() {
        LOG.info("Iniciando busca de Pedidos");
        String login = jwt.getSubject();
        List<PedidoResponseDTO> pedidos = service.findByAll(login);
        return Response.ok(pedidos).build();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({ "User", "Admin" })
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Iniciando busca do Pedido : %s", id);
        PedidoResponseDTO pedido = service.findById(id);
        if (pedido != null) {
            return Response.ok(pedido).build();
        } else {
            return Response.status(Status.NOT_FOUND).build();
        }
    }


}
