package br.unitins.topicos1.dto.fabricante;

import br.unitins.topicos1.model.Fabricante;

public record FabricanteResponseDTO(

        Long id,
        String nome,
        boolean ativo
) {
    public static FabricanteResponseDTO valueOf(Fabricante fabricante) {
        return new FabricanteResponseDTO(
                fabricante.getId(),
                fabricante.getNome(),
                fabricante.isAtivo()
        );
    }
}   
