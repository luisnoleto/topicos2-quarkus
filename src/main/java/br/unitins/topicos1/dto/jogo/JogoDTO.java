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

    @NotBlank(message = "O campo nome não pode ser nulo.")
    String processador,

    @NotBlank(message = "O campo nome não pode ser nulo.")
    String memoria,

    @NotBlank(message = "O campo nome não pode ser nulo.")
    String placaVideo,

    @NotBlank(message = "O campo nome não pode ser nulo.")
    String sistemaOperacional,
    
    @NotBlank(message = "O campo nome não pode ser nulo.")
    String armazenamento,

    //@NotNull(message = "O campo nome não pode ser nulo.")
    Integer classificacao,
    @NotNull(message = "O campo nome não pode ser nulo.")
    Long idPlataforma,
    @NotNull(message = "O campo nome não pode ser nulo.")
    Long idDesenvolvedora,

    @NotEmpty(message = "O campo nome não pode ser nulo.")
    List<Long> listaIdGeneros,
    


    String nomeImagem

) {

    
}
