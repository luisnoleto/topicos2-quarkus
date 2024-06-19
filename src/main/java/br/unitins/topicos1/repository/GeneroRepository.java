package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Genero;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GeneroRepository implements PanacheRepository<Genero> {
    public PanacheQuery<Genero> findByNome(String nome) {
        if (nome == null) {
            return null;
        }
        return find("UPPER(nome) LIKE UPPER(?1) ", "%" + nome.toUpperCase() + "%");
    }

    public List<Genero> findByAtivo(boolean ativo) {
        if (ativo) {
            return find("ativo", true).list();
        } else {
            return List.of();
        }
    }
}