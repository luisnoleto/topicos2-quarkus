package br.unitins.topicos1.dto.jogo;

import br.unitins.topicos1.model.Classificacao;

public record ClassificacaoResponseDTO(Integer id, String label) {

    public static ClassificacaoResponseDTO valueOf(Classificacao classificacao) {
        return new ClassificacaoResponseDTO(classificacao.getId(), classificacao.getLabel());
    }
}
