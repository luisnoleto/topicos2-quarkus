package br.unitins.topicos1.dto.jogo;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record JogoDTO(
    @NotBlank(message = "O campo nome não pode ser nulo.")
    String nome,
    @NotBlank(message = "O campo nome não pode ser nulo.")
    String descricao,

    @NotNull(message = "O campo nome não pode ser nulo.")
    Double preco,  
    @NotNull(message = "O campo nome não pode ser nulo.")
    int estoque,
    @NotNull(message = "O campo nome não pode ser nulo.")
    Integer classificacao,
    //@NotNull(message = "O campo nome não pode ser nulo.")
    Long idPlataforma,
    @NotNull(message = "O campo nome não pode ser nulo.")
    Long idRequisito,

    @NotEmpty(message = "O campo nome não pode ser nulo.")
    List<Long> listaIdGeneros,
    


    String nomeImagem

) {

    
}
