package br.unitins.topicos1.dto.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.unitins.topicos1.dto.endereco.EnderecoResponseDTO;
import br.unitins.topicos1.dto.itempedido.ItemPedidoResponseDTO;
import br.unitins.topicos1.dto.usuario.UsuarioResponseDTO;
import br.unitins.topicos1.model.FormaPagamento;
import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.model.StatusPedido;

public record PedidoResponseDTO(
        Long id,
        LocalDateTime dataCompra,
        UsuarioResponseDTO usuario,
        EnderecoResponseDTO endereco,
        FormaPagamento pagamento,
        Double totalPedido,
        List<ItemPedidoResponseDTO> itens,
        StatusPedido statusPedido) {
    public static PedidoResponseDTO valueOf(Pedido pedido) {
        return new PedidoResponseDTO(
                pedido.getId(),
                pedido.getdataCompra(),
                UsuarioResponseDTO.valueOf(pedido.getUsuario()),
                EnderecoResponseDTO.valueOf(pedido.getEndereco()),
                pedido.getPagamento(),
                pedido.getTotalPedido(),
                ItemPedidoResponseDTO.valueOf(pedido.getItens()),
                pedido.getStatusPedido());
    }
}
