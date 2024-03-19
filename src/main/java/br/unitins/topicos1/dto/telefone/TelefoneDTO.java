package br.unitins.topicos1.dto.telefone;

import br.unitins.topicos1.model.Telefone;
import jakarta.validation.constraints.Size;

public record TelefoneDTO(
    @Size(max = 2, min = 2, message = "O número deve conter obrigatoriamente dois dígitos")
    String codigoArea,

    @Size(max = 9, min = 9, message = "O número deve conter obrigatoriamente nove dígitos")
    String numero

) {
    public static TelefoneDTO valueOf(Telefone telefone){
        return new TelefoneDTO(
            telefone.getCodigoArea(), 
            telefone.getNumero()
        );
    }
}
