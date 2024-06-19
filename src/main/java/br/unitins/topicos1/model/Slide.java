package br.unitins.topicos1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Slide extends DefaultEntity {

    @Column
    private String nomeImagem;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jogo")
    private Jogo jogoId;

    public String getNomeImagem() {
        return nomeImagem;
    }

    public void setNomeImagem(String nomeImagem) {
        this.nomeImagem = nomeImagem;
    }

    public Jogo getJogoId() {
        return jogoId;
    }

    public void setJogoId(Jogo jogoId) {
        this.jogoId = jogoId;
    }

}