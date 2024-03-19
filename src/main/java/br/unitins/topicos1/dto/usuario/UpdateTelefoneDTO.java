package br.unitins.topicos1.dto.usuario;

import java.util.List;

import br.unitins.topicos1.dto.telefone.TelefoneDTO;
import jakarta.validation.constraints.NotEmpty;


public record UpdateTelefoneDTO(
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    String senhaAtual,
    @NotEmpty(message = "O campo nome não pode ser nulo.")
    List<TelefoneDTO> listaTelefones

) {

}
