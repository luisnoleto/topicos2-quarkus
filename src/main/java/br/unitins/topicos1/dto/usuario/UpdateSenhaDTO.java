package br.unitins.topicos1.dto.usuario;


import jakarta.validation.constraints.NotEmpty;

public record UpdateSenhaDTO(
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    String senhaAtual,
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    String novaSenha
) {
   
}
