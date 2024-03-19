package br.unitins.topicos1.dto.estado;

import br.unitins.topicos1.model.Estado;

public record EstadoResponseDTO(
    Long id,
    String nome,
    String sigla
) { 
    public static EstadoResponseDTO valueOf(Estado estado){
        return new EstadoResponseDTO(
            estado.getId(), 
            estado.getNomeEstado(),
            estado.getSigla());
    }
}
