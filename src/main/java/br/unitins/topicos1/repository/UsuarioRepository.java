package br.unitins.topicos1.repository;

import java.util.List;

import br.unitins.topicos1.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {
    public List<Usuario> findByNome(String nome) {
        return find("UPPER(nome) LIKE UPPER(?1) ", "%" + nome + "%").list();
    }

    public Usuario findByLogin(String login) {
        try {
            return find("login = ?1 ", login).singleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }

    }

    public PanacheQuery<Usuario> findByLoginAndSenha(String login, String senha) {
        return find("login = ?1 and senha = ?2", login, senha);
    }
}
