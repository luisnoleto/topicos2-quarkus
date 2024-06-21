package br.unitins.topicos1.service;

import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.model.StatusPedido;
import br.unitins.topicos1.repository.PedidoRepository;
import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import org.jboss.logging.Logger;

@ApplicationScoped
public class PedidoStatusAlterar {

    @Inject
    PedidoRepository pedidoRepository;

    @Inject
    Logger logger;

    @Scheduled(every = "{pedido.update.interval}")
    @Transactional
    void updatePedidoStatus() {
        logger.info("Tarefa para atualizar status dos pedidos");

        List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.PROCESSANDO);
        pedidos.addAll(pedidoRepository.findByStatus(StatusPedido.PAGO));

        pedidos.forEach(pedido -> {
            try {
                LocalDateTime dataCompra = pedido.getDataCompra();
                LocalDateTime now = LocalDateTime.now();

                logger.info("Verificando pedido " + pedido.getId() + " com status atual: " + pedido.getStatusPedido());

                if (dataCompra.plusMinutes(2).isBefore(now)) {
                    if (pedido.getStatusPedido() != StatusPedido.ENVIADA) {
                        pedido.setStatusPedido(StatusPedido.ENVIADA);
                        pedidoRepository.persist(pedido);
                        logger.info("Pedido " + pedido.getId() + " agora está " + StatusPedido.ENVIADA);
                    } else {
                        logger.info("Pedido " + pedido.getId() + " já está " + StatusPedido.ENVIADA);
                    }
                } else if (dataCompra.plusMinutes(1).isBefore(now)) {
                    if (pedido.getStatusPedido() != StatusPedido.PAGO
                            && pedido.getStatusPedido() != StatusPedido.ENVIADA) {
                        pedido.setStatusPedido(StatusPedido.PAGO);
                        pedidoRepository.persist(pedido);
                        logger.info("Pedido " + pedido.getId() + " agora está " + StatusPedido.PAGO);
                    } else {
                        logger.info("Pedido " + pedido.getId() + " já está " + StatusPedido.PAGO + " ou "
                                + StatusPedido.ENVIADA);
                    }
                }
            } catch (Exception e) {
                logger.error("Erro ao atualizar o pedido " + pedido.getId(), e);
            }
        });
    }
}
