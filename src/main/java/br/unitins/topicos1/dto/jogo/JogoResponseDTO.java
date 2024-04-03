package br.unitins.topicos1.dto.jogo;

import java.util.List;

import br.unitins.topicos1.dto.genero.GeneroResponseDTO;
import br.unitins.topicos1.dto.plataforma.PlataformaResponseDTO;
import br.unitins.topicos1.dto.requisito.RequisitoResponseDTO;
import br.unitins.topicos1.model.Classificacao;
import br.unitins.topicos1.model.Jogo;


public record JogoResponseDTO(
        Long id,
        String nome,
        String descricao,
        Double preco,
        int estoque,
        List<GeneroResponseDTO> listaGenero,
        //PlataformaResponseDTO plataforma,
        RequisitoResponseDTO requisito,
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
                        .map(t -> GeneroResponseDTO.valueOf(t)).toList(),
               // PlataformaResponseDTO.valueOf(jogo.getPlataforma()),
                RequisitoResponseDTO.valueOf(jogo.getRequisito()),
                jogo.getClassificacao(),

                jogo.getNomeImagem());
    }

}