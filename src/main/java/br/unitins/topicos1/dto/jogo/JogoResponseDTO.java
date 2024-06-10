package br.unitins.topicos1.dto.jogo;

import java.util.List;

import br.unitins.topicos1.dto.desenvolvedora.DesenvolvedoraResponseDTO;
import br.unitins.topicos1.dto.genero.GeneroResponseDTO;
import br.unitins.topicos1.dto.plataforma.PlataformaResponseDTO;
import br.unitins.topicos1.model.Classificacao;
import br.unitins.topicos1.model.Jogo;


public record JogoResponseDTO(
        Long id,
        String nome,
        String descricao,
        Double preco,
        int estoque,
        String processador,
        String memoria,
        String placaVideo,
        String sistemaOperacional,
        String armazenamento,
        boolean ativo,
        List<GeneroResponseDTO> listaGenero,
        PlataformaResponseDTO plataforma,
        Classificacao classificacao,
        DesenvolvedoraResponseDTO desenvolvedora,

        String nomeImagem) {
    public static JogoResponseDTO valueOf(Jogo jogo) {

        return new JogoResponseDTO(
                jogo.getId(),
                jogo.getNome(),
                jogo.getDescricao(),
                jogo.getPreco(),
                jogo.getEstoque(),
                jogo.getProcessador(),
                jogo.getMemoria(),
                jogo.getPlacaVideo(),
                jogo.getSistemaOperacional(),
                jogo.getArmazenamento(),
                jogo.isAtivo(),
                jogo.getListaGeneros().stream()
                        .map(t -> GeneroResponseDTO.valueOf(t)).toList(),
                PlataformaResponseDTO.valueOf(jogo.getPlataforma()),
                jogo.getClassificacao(),
                DesenvolvedoraResponseDTO.valueOf(jogo.getDesenvolvedora()),

                jogo.getNomeImagem());
    }

}