package br.unitins.topicos1.dto.cidade;

import jakarta.validation.constraints.NotBlank;

public record CidadeDTO(
    @NotBlank(message = "O campo cidade deve ser preenchido.")
    String nome,
    Long idEstado
) {
    
}
