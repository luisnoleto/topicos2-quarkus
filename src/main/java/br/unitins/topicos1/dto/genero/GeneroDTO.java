package br.unitins.topicos1.dto.genero;

import br.unitins.topicos1.model.Genero;
import jakarta.validation.constraints.Size;

public record GeneroDTO(
    @Size(max = 50, min = 3, message = "O nome deve conter entre 3 e 50 caracteres")
    String nome

) { 
    
}
