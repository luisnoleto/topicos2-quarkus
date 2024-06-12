package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Desempenho;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DesempenhoRepository implements PanacheRepository<Desempenho> {
    public PanacheQuery<Desempenho> findByNome(String nome) {
        if (nome == null)
            return null;
        return find("UPPER(nome) LIKE UPPER(?1) ", "%" + nome.toUpperCase() + "%");
    }


}




