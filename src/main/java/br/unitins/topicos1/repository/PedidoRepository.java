package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.model.StatusPedido;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class PedidoRepository implements PanacheRepository<Pedido> {

    @PersistenceContext
    EntityManager em;

    public List<Pedido> findAll(String login) {
        return find("usuario.login = ?1", login).list();
    }

    public List<Pedido> findByUsuarioId(Long usuarioId) {
        return find("usuario.id = ?1", usuarioId).list();
    }

    public List<Pedido> findByStatus(StatusPedido status) {
        return list("statusPedido", status);
    }

    public Pedido merge(Pedido pedido) {
        return em.merge(pedido);
    }
}
