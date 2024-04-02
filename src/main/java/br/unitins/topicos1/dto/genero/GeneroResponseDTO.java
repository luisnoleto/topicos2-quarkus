package br.unitins.topicos1.dto.genero;

import br.unitins.topicos1.model.Genero;

public record GeneroResponseDTO(

        Long id,
        String nome
) {
    public static GeneroResponseDTO valueOf(Genero genero) {
        return new GeneroResponseDTO(
                genero.getId(),
                genero.getNome()
        );
    }
}   
