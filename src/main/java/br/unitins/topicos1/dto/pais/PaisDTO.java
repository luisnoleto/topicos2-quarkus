package br.unitins.topicos1.dto.pais;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PaisDTO(
                @NotBlank(message = "O campo nome não pode ser nulo") 
                String nome,

                @Size(min = 2) 
                String sigla,
                
                boolean ativo) {

}
