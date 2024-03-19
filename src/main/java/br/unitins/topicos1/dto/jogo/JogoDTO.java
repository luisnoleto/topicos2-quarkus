package br.unitins.topicos1.dto.jogo;

import jakarta.validation.constraints.NotEmpty;

public record JogoDTO(
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    String nome,
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    String descricao,
 
    Double preco,  
   
    int estoque,
    
    Integer idGenero,

    String nomeImagem

) {

    
}
