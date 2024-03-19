package br.unitins.topicos1.dto.itempedido;

import jakarta.validation.constraints.NotEmpty;

public record ItemPedidoDTO (
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    Integer quantidade,
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    Double preco,
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    Long idProduto
) {
    
}

