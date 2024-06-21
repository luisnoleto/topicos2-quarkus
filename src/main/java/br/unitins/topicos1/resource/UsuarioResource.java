package br.unitins.topicos1.resource;

import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.endereco.EnderecoResponseDTO;
import br.unitins.topicos1.dto.usuario.UsuarioDTO;
import br.unitins.topicos1.dto.usuario.UsuarioResponseDTO;
import br.unitins.topicos1.repository.UsuarioRepository;
import br.unitins.topicos1.service.UsuarioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService service;

    @Inject
    UsuarioRepository usuarioRepository;

    private static final Logger LOG = Logger.getLogger(UsuarioResource.class);

    @POST
    @Path("/cadastro")
    // @RolesAllowed("Admin")
    public Response insert(@Valid UsuarioDTO dto) {
        LOG.info("Received usuario data: " + dto);

        if (usuarioRepository.findByLogin(dto.login()) != null) {
            LOG.info("Usuario não inserido, login já existente");
            throw new WebApplicationException("Login já existe.", Response.Status.BAD_REQUEST);
        } else {
            LOG.info("Usuario inserido");
            UsuarioResponseDTO retorno = service.insert(dto);
            LOG.info("Inserido: " + retorno);
            return Response.status(201).entity(retorno).build();
        }
    }

    @PUT
    @Transactional
    @Path("/{id}")
    @RolesAllowed("Admin")
    public Response update(@Valid UsuarioDTO dto, @PathParam("id") Long id) {
        LOG.infof("Atualizando o dados do Usuario %s", id);
        service.update(dto, id);

        return Response.noContent().build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    @RolesAllowed("Admin")
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Deletando Usuario %s", id);
        service.delete(id);

        return Response.noContent().build();
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
    @RolesAllowed("Admin")
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("Procurando o Usuario %s", id);

        return Response.ok(service.findById(id)).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    @RolesAllowed("Admin")
    public Response findByNome(@PathParam("nome") String nome) {
        LOG.infof("Buscando usuario pelo nome: %s", nome);

        return Response.ok(service.findByNome(nome)).build();
    }

    @GET
    @Path("/count")
    public long count() {
        return service.count();
    }

    @GET
    @Path("/search/endereco/{idUsuario}/{indiceEndereco}")
    public Response findEnderecoByUsuario(@PathParam("idUsuario") Long idUsuario,
            @PathParam("indiceEndereco") int indiceEndereco) {
        LOG.infof("Buscando endereço %d do usuário %d", indiceEndereco, idUsuario);

        EnderecoResponseDTO enderecoResponse = service.findEnderecoByUsuario(idUsuario, indiceEndereco);
        return Response.ok(enderecoResponse).build();
    }
}
