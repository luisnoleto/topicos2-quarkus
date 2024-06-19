package br.unitins.topicos1.resource;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import br.unitins.topicos1.dto.jogo.SlideResponseDTO;
import br.unitins.topicos1.form.CarouselImageForm;
import br.unitins.topicos1.service.CarouselFileService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/carousel")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.MULTIPART_FORM_DATA)
public class CarouselResource {
    @Inject
    CarouselFileService carouselFileService;
    private static final Logger LOG = Logger.getLogger(CarouselResource.class);

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarCarousel(@MultipartForm CarouselImageForm form) {
        try {
            if (form.getImagemCarousel() == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity("Image data is missing").build();
            }

            carouselFileService.salvar(form.getJogoId(), form.getNomeImagemCarousel(), form.getImagemCarousel());

            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to process upload: " + e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/remove/{jogoId}")
    public Response removeCarouselByJogoId(@PathParam("jogoId") Long jogoId) {
        try {
            carouselFileService.removerPorJogoId(jogoId);
            LOG.info("Removida a imagem do jogo com id: " + jogoId);
            return Response.noContent().build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to remove carousel image: " + e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/download/{nomeImagemCarousel}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadCarousel(@PathParam("nomeImagemCarousel") String nomeImagemCarousel) {
        LOG.info("Downloading image: " + nomeImagemCarousel);

        if (nomeImagemCarousel == null || nomeImagemCarousel.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Image name is missing").build();
        }

        File file = carouselFileService.download(nomeImagemCarousel);
        if (file == null || !file.exists()) {
            return Response.status(Response.Status.NOT_FOUND).entity("File not found").build();
        }

        Response.ResponseBuilder response = Response.ok(file);
        response.header("Content-Disposition", "attachment;filename=" + nomeImagemCarousel);
        return response.build();
    }

    @GET
    @Path("/slides")
    public Response getCarouselSlides() {
        List<SlideResponseDTO> slides = carouselFileService.getAllSlides().stream()
                .map(SlideResponseDTO::valueOf)
                .collect(Collectors.toList());
        return Response.ok(slides).build();
    }
}