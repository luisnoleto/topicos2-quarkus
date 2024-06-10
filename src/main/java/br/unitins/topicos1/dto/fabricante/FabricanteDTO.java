package br.unitins.topicos1.dto.fabricante;

import jakarta.validation.constraints.NotEmpty;

public record FabricanteDTO(
        @NotEmpty(message = "O campo nome não pode ser nulo.")
        String nome,

        boolean ativo

) {

}





