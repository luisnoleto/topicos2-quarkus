package br.unitins.topicos1.dto.plataforma;

import br.unitins.topicos1.dto.fabricante.FabricanteDTO;
import br.unitins.topicos1.model.Plataforma;

public record PlataformaDTO(
    
    String nome,
    FabricanteDTO fabricante

) {
    public static PlataformaDTO valueOf(Plataforma plataforma){
        return new PlataformaDTO(
            plataforma.getNome(),
            FabricanteDTO.valueOf(plataforma.getFabricante())
    
        );
    }
}
