package br.unitins.topicos1.dto.usuario;

import jakarta.validation.constraints.NotEmpty;

public record UpdateLoginDTO(   
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    String senhaAtual,    
    @NotEmpty(message = "O campo login não pode ser nulo.")
    String loginNovo) {
}
