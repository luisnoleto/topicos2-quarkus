package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Desenvolvedora;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DesenvolvedoraRepository implements PanacheRepository<Desenvolvedora> {
    public List<Desenvolvedora> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%" + nome + "%").list();
    }
}
