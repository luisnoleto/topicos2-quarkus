package br.unitins.topicos1.dto.desenvolvedora;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DesenvolvedoraDTO(

                @NotBlank(message = "O campo nome não pode ser nulo") 
                String nome,
                @NotBlank(message = "O campo cnpj não pode ser nulo") 
                String cnpj,
                @NotNull(message = "O campo pais não pode ser nulo") 
                Long paisId) {

}
