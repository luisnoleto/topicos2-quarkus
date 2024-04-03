package br.unitins.topicos1.dto.jogo;

import java.util.List;

import br.unitins.topicos1.dto.genero.GeneroDTO;
import jakarta.validation.constraints.NotEmpty;

public record JogoDTO(
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    String nome,
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    String descricao,
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    Double preco,  
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    int estoque,
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    Integer classificacao,
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    Long plataforma,
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    Long requisito,

    List<GeneroDTO> listaGeneros,
    


    String nomeImagem

) {

    
}
