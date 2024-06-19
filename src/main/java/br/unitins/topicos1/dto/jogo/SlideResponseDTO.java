package br.unitins.topicos1.dto.jogo;

import br.unitins.topicos1.model.Slide;

public record SlideResponseDTO(
        Long id,
        String nomeImagem,
        JogoResponseDTO jogoResponseDTO) {
    public static SlideResponseDTO valueOf(Slide slide) {

        return new SlideResponseDTO(
                slide.getId(),
                slide.getNomeImagem(),
                JogoResponseDTO.valueOf(slide.getJogoId()));

    }
}
