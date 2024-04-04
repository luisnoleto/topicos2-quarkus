package br.unitins.topicos1.repository;

import br.unitins.topicos1.model.Plataforma;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PlataformaRepository implements PanacheRepository<Plataforma>{
    public PanacheQuery<Plataforma> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%"+nome.toUpperCase()+"%");
    }
}
