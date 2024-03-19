package br.unitins.topicos1.model;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoChavePix {
    
    
    ALEATORIA(1, "Aleatoria"),
    CPF_CNPJ(2, "CPF/CNPJ"),
    EMAIL(3, "Email"),
    CELULAR(4, "Celular");
    
    private final Integer id;
    private final String label;
    
    private TipoChavePix(Integer id, String label) {
        this.id = id;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static TipoChavePix ValueOf(Integer id) throws IllegalArgumentException {
        if (id ==null)
            return null;
        for (TipoChavePix tipo :TipoChavePix.values()) {
            if (tipo.getId().equals(id))
                return tipo;
        }

        throw new IllegalArgumentException("Id inválido" + id);
    }
}

