package br.unitins.topicos1.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UpdateEmailDTO(
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    String senhaAtual,
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    @Email
    String email
) {
} 
