package br.unitins.topicos1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Desenvolvedora extends DefaultEntity {

    private String nome;
    private String cnpj;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(@NotNull(message = "O campo pais não pode ser nulo") Pais pais) {
        this.pais = pais;
    }
}
