package br.unitins.topicos1.dto.boleto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BoletoDTO(

                @NotBlank(message = "O número do boleto deve ser informado.") String numeroBoleto,

                @NotNull() @JsonFormat(pattern = "yyyy-MM-dd") LocalDateTime dataEmissao,

                @NotNull() @JsonFormat(pattern = "yyyy-MM-dd") LocalDateTime dataVencimento

) {

}
