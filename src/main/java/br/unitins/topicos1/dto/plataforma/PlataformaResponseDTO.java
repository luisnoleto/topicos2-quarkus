package br.unitins.topicos1.dto.plataforma;

import br.unitins.topicos1.dto.fabricante.FabricanteResponseDTO;
import br.unitins.topicos1.model.Plataforma;

public record PlataformaResponseDTO(
                String nome,
                FabricanteResponseDTO fabricante

) {
        public static PlataformaResponseDTO valueOf(Plataforma plataforma) {
                return new PlataformaResponseDTO(
                                plataforma.getNome(),
                                FabricanteResponseDTO.valueOf(plataforma.getFabricante())

                );
        }
}
