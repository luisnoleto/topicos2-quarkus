package br.unitins.topicos1.dto.requisito;

import br.unitins.topicos1.model.Desempenho;

public record DesempenhoDTO(Integer id, String label) {
    public static DesempenhoDTO valueOf(Desempenho desempenho) {
        return new DesempenhoDTO(desempenho.ordinal() + 1, desempenho.getLabel());
    }
}
