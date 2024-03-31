package br.unitins.topicos1.model;
import jakarta.persistence.Entity;

@Entity
public class Plataforma extends DefaultEntity{

    private String nome;
    private Fabricante fabricante;

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}
