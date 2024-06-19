package br.unitins.topicos1.dto.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record UpdateCPFDTO(   
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    String senhaAtual,    
    @NotBlank(message = "O CPF não pode estar em branco") @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "Formato de CPF inválido ---- Ex. 999.999.999-99") 
    String cpf) {
}
