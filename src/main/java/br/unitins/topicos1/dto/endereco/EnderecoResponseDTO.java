package br.unitins.topicos1.dto.endereco;

import br.unitins.topicos1.model.Cidade;
import br.unitins.topicos1.model.Endereco;

public record EnderecoResponseDTO(
        Long id,
        String cep,
        String logradouro,
        Integer numero,
        String complemento,
        String bairro,
        Long idCidade,
        String nomeCidade,
        Long idEstado,
        String nomeEstado) {
    public static EnderecoResponseDTO valueOf(Endereco endereco) {
        Cidade cidade = endereco.getCidade();
        return new EnderecoResponseDTO(
                endereco.getId(),
                endereco.getCep(),
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                cidade.getId(),
                cidade.getNomeCidade(),
                cidade.getEstado().getId(),
                cidade.getEstado().getNomeEstado());
    }
}
