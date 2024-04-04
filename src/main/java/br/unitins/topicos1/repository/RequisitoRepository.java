package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.Requisito;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RequisitoRepository implements PanacheRepository<Requisito>{
    public PanacheQuery<Requisito> findByRequisitos(String desempenho) {
        return find("UPPER(desempenho) LIKE UPPER(?1) ", "%"+desempenho.toUpperCase()+"%");
    }
}

