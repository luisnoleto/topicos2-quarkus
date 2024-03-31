package br.unitins.topicos1.dto.requisito;

import br.unitins.topicos1.model.Requisito;


public record RequisitoDTO(
    
    String armazenamento,
    String memoria,
    String processador,
    String placaVideo,
    String sistemaOperacional

) {
    public static RequisitoDTO valueOf(Requisito requisito){
        return new RequisitoDTO(
            requisito.getArmazenamento(),
            requisito.getMemoria(),
            requisito.getProcessador(),
            requisito.getPlacaVideo(),
            requisito.getSistemaOperacional()          
        );
    }
}
