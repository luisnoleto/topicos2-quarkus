package br.unitins.topicos1.dto.jogo;

import br.unitins.topicos1.model.Genero;
import br.unitins.topicos1.model.Jogo;

public record JogoResponseDTO(
        Long id,
        String nome,
        String descricao,
        Double preco,
        int estoque,
        Genero genero,
        String nomeImagem) {
    public static JogoResponseDTO valueOf(Jogo jogo) {

        return new JogoResponseDTO(
                jogo.getId(),
                jogo.getNome(),
                jogo.getDescricao(),
                jogo.getPreco(),
                jogo.getEstoque(),
                jogo.getGenero(), 
                jogo.getNomeImagem());
    }

}