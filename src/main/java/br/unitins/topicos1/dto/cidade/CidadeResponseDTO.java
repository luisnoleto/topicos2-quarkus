package br.unitins.topicos1.dto.cidade;

import br.unitins.topicos1.dto.estado.EstadoResponseDTO;
import br.unitins.topicos1.model.Cidade;

public record CidadeResponseDTO(
    Long id,
    String nome,
    EstadoResponseDTO estado
) {
   public static CidadeResponseDTO valueOf(Cidade cidade){
    return new CidadeResponseDTO(
        cidade.getId(),
        cidade.getNomeCidade(),
        EstadoResponseDTO.valueOf(cidade.getEstado())
    );
   } 
}
