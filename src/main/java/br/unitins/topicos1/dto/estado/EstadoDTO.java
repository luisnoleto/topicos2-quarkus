package br.unitins.topicos1.dto.estado;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EstadoDTO(
    @NotBlank(message = "O campo nome não pode ser nulo")
    String nome,
    @Size(min = 2, max = 2)
    String sigla
) {
    
}
