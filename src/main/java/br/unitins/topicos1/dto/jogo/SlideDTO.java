package br.unitins.topicos1.dto.jogo;

import jakarta.validation.constraints.NotBlank;

public class SlideDTO {

    public record JogoDTO(
            @NotBlank(message = "O campo nome não pode ser nulo.") String nomeImagem,
            @NotBlank(message = "O campo nome não pode ser nulo.") Long jogoId

    ) {

    }

}
