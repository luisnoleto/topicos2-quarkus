package br.unitins.topicos1.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Genero {
    
    AVENTURA(1, "Aventura"),
    ACAO(2, "Ação"),
    RPG(3, "RPG"),
    ESTRATEGIA(4, "Estratégia"),
    TIRO(5, "Tiro"),
    ESPORTE(6, "Esporte"),
    SIMULACAO(7, "Simulação"),
    CORRIDA(8, "Corrida"),
    LUTA(9, "Luta"),
    TERROR(10, "Terror");

    private final Integer id;
    private final String label;
    
    private Genero(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Genero ValueOf(Integer id) throws IllegalArgumentException {
        if (id ==null)
            return null;
        for (Genero genero :Genero.values()) {
            if (genero.getId().equals(id))
                return genero;
        }

        throw new IllegalArgumentException("Id inválido" + id);
    }
}
