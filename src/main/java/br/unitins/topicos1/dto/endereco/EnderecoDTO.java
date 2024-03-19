package br.unitins.topicos1.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(
    @NotBlank(message = "O cep não pode ser nulo.")
    @Pattern(regexp = "(^\\d{5}-\\d{3}$)", message = "Preencha o cep de acordo com o formato xxxxx-xxx")
    String cep,

    @NotEmpty(message = "O campo logradoro não pode ser nulo.")
    String logradouro,
    @NotNull(message = "O campo numero não pode ser nulo")
    Integer numero,
    @NotEmpty(message = "O campo complemento não pode ser nulo.")
    String complemento,
    @NotEmpty(message = "O campo bairro não pode ser nulo.")
    String bairro,
    
    @NotNull(message = "O campo cidade não pode ser nulo")
    Long idCidade
) {

    
}
