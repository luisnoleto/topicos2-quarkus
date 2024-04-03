package br.unitins.topicos1.dto.requisito;

import br.unitins.topicos1.model.Desempenho;
import br.unitins.topicos1.model.Requisito;

public record RequisitoResponseDTO(

    String armazenamento,
    String memoria,
    String processador,
    String placaVideo,
    String sistemaOperacional,
    Desempenho desempenho

) {
     public static RequisitoResponseDTO valueOf(Requisito requisito){
        return new RequisitoResponseDTO(
            requisito.getArmazenamento(),
            requisito.getMemoria(),
            requisito.getProcessador(),
            requisito.getPlacaVideo(),
            requisito.getSistemaOperacional(),
            requisito.getDesempenho()          
        );
    }
}