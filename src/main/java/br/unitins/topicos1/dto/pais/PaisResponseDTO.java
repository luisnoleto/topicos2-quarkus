package br.unitins.topicos1.dto.pais;

import br.unitins.topicos1.model.Pais;

public record PaisResponseDTO(
        Long id,
        String nome,
        String sigla,
        boolean ativo) {
    public static PaisResponseDTO valueOf(Pais pais) {
        return new PaisResponseDTO(
                pais.getId(),
                pais.getNome(),
                pais.getSigla(),
                pais.isAtivo());
    }
}
