package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Pais;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaisRepository implements PanacheRepository<Pais> {
    public List<Pais> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%" + nome + "%").list();
    }

        public List<Pais> findByAtivo(boolean ativo) {
        if (ativo) {
            return find("ativo", true).list();
        } else {
            return List.of(); 
        }
    }
}