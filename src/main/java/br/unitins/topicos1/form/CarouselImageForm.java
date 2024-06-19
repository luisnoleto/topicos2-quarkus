package br.unitins.topicos1.form;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.core.MediaType;

public class CarouselImageForm {

    @FormParam("jogoId")
    @PartType(MediaType.TEXT_PLAIN)
    private Long jogoId;

    @FormParam("nomeImagemCarousel")
    @PartType(MediaType.TEXT_PLAIN)
    private String nomeImagemCarousel;

    @FormParam("imagemCarousel")
    @PartType("application/octet-stream")
    private byte[] imagemCarousel;

    public String getNomeImagemCarousel() {
        return nomeImagemCarousel;
    }

    public void setNomeImagemCarousel(String nomeImagemCarousel) {
        this.nomeImagemCarousel = nomeImagemCarousel;
    }

    public byte[] getImagemCarousel() {
        return imagemCarousel;
    }

    public void setImageCarousel(byte[] imagemCarousel) {
        this.imagemCarousel = imagemCarousel;
    }

    public Long getJogoId() {
        return jogoId;
    }

    public void setJogoId(Long jogoId) {
        this.jogoId = jogoId;
    }

}
