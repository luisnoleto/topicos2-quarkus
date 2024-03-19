package br.unitins.topicos1.dto.pedido;


import java.util.List;

import br.unitins.topicos1.dto.itempedido.ItemPedidoDTO;
import jakarta.validation.constraints.NotNull;

public record PedidoDTO (
    @NotNull(message = "O campo Pagamento não pode ser nulo")
    Integer pagamento,
    @NotNull(message = "O campo endereco não pode ser nulo")
    Long endereco,
    @NotNull(message = "O campo Itens não pode ser nulo")
    List<ItemPedidoDTO> itens
) {

}
