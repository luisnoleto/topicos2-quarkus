package br.unitins.topicos1.dto.desenvolvedora;

import br.unitins.topicos1.dto.pais.PaisResponseDTO;
import br.unitins.topicos1.model.Desenvolvedora;

public record DesenvolvedoraResponseDTO(
        Long id,
        String nome,
        String cnpj,
        PaisResponseDTO pais,
        boolean ativo) {

    public static DesenvolvedoraResponseDTO valueOf(Desenvolvedora desenvolvedora) {
        return new DesenvolvedoraResponseDTO(
                desenvolvedora.getId(),
                desenvolvedora.getNome(),
                desenvolvedora.getCnpj(),
                PaisResponseDTO.valueOf(desenvolvedora.getPais())
                , desenvolvedora.isAtivo());
    }
}