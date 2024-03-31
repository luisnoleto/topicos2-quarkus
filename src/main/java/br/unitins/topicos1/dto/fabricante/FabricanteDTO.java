package br.unitins.topicos1.dto.fabricante;

import br.unitins.topicos1.model.Fabricante;
import jakarta.validation.constraints.NotEmpty;

public record FabricanteDTO(
        @NotEmpty(message = "O campo nome não pode ser nulo.")
        String nome

) {
    public static FabricanteDTO valueOf(Fabricante fabricante) {
        return new FabricanteDTO(
                fabricante.getNome()
        );
    }
}
