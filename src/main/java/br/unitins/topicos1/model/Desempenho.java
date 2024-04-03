package br.unitins.topicos1.model;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Desempenho {
    
    ALTO(1,"Pix"),
    LEVE(2, "Boleto"),
    MEDIO(3, "Cartão de Crédito");

    private final Integer id;
    private final String label;
    
    private Desempenho(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Desempenho ValueOf(Integer id) throws IllegalArgumentException {
        if (id ==null)
            return null;
        for (Desempenho escolha :Desempenho.values()) {
            if (escolha.getId().equals(id))
                return escolha;
        }

        throw new IllegalArgumentException("Id inválido" + id);
    }
}
