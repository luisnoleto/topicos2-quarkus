package br.unitins.topicos1.dto.plataforma;

import br.unitins.topicos1.dto.fabricante.FabricanteResponseDTO;
import br.unitins.topicos1.model.Plataforma;

public record PlataformaResponseDTO(
                Long id,
                String nome,
                FabricanteResponseDTO fabricante,
                boolean ativo

) {
        public static PlataformaResponseDTO valueOf(Plataforma plataforma) {
                return new PlataformaResponseDTO(
                                plataforma.getId(),
                                plataforma.getNome(),
                                FabricanteResponseDTO.valueOf(plataforma.getFabricante()),
                                plataforma.isAtivo()

                );
        }
}
