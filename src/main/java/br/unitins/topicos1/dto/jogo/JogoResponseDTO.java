package br.unitins.topicos1.dto.jogo;

import java.util.List;

import br.unitins.topicos1.dto.genero.GeneroDTO;
import br.unitins.topicos1.dto.plataforma.PlataformaDTO;
import br.unitins.topicos1.dto.requisito.RequisitoDTO;
import br.unitins.topicos1.model.Classificacao;
import br.unitins.topicos1.model.Jogo;


public record JogoResponseDTO(
        Long id,
        String nome,
        String descricao,
        Double preco,
        int estoque,
        List<GeneroDTO> listaGenero,
        PlataformaDTO plataforma,
        RequisitoDTO requisito,
        Classificacao classificacao,

        String nomeImagem) {
    public static JogoResponseDTO valueOf(Jogo jogo) {

        return new JogoResponseDTO(
                jogo.getId(),
                jogo.getNome(),
                jogo.getDescricao(),
                jogo.getPreco(),
                jogo.getEstoque(),
                jogo.getListaGeneros().stream()
                        .map(t -> GeneroDTO.valueOf(t)).toList(),
                PlataformaDTO.valueOf(jogo.getPlataforma()),
                RequisitoDTO.valueOf(jogo.getRequisito()),
                jogo.getClassificacao(),

                jogo.getNomeImagem());
    }

}