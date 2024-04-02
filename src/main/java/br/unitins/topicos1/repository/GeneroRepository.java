package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Genero;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GeneroRepository implements PanacheRepository<Genero> {
    public List<Genero> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%" + nome + "%").list();
    }
}