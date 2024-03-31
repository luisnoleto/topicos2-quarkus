package br.unitins.topicos1.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Classificacao {
    
    LIVRE(1,"Livre"),
    DEZ_ANOS(2, "10 anos"),
    DOZE_ANOS(3, "12 anos"),
    QUATORZE_ANOS(4, "14 anos"),
    DEZESSEIS_ANOS(5, "16 anos"),
    DEZOITO_ANOS(6, "18 anos");

    private final Integer id;
    private final String label;
    
    private Classificacao(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Classificacao ValueOf(Integer id) throws IllegalArgumentException {
        if (id ==null)
            return null;
        for (Classificacao escolha :Classificacao.values()) {
            if (escolha.getId().equals(id))
                return escolha;
        }

        throw new IllegalArgumentException("Id inválido" + id);
    }
}
