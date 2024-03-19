package br.unitins.topicos1.dto.pix;

import jakarta.validation.constraints.NotBlank;

public record PixDTO(

        @NotBlank(message = "A chave pix deve ser informada.") 
        String chavePix,

        @NotBlank(message = "O tipo da chave deve ser informado.") 
        Integer tipoChavePix

) {

}
