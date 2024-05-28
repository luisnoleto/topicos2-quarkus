package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.Jogo;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JogoRepository implements PanacheRepository<Jogo> {
    public PanacheQuery<Jogo> findByNome(String nome) {
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE UPPER(?1) ", "%" + nome.toUpperCase() + "%");
    }
}
