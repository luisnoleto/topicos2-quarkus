package br.unitins.topicos1.dto.pix;

import br.unitins.topicos1.model.Pix;
import br.unitins.topicos1.model.TipoChavePix;


public record PixResponseDTO(
    Double valor,
    String chavePix,
    TipoChavePix tipoChavePix
) {
        public static PixResponseDTO valueOf(Pix pix){
        return new PixResponseDTO(
            pix.getValor(),
            pix.getChavePix(),
            pix.getTipoChavePix()
        );
    }
}
