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
    Cidade idCidade


) {
     public static EnderecoResponseDTO valueOf(Endereco endereco){
        return new EnderecoResponseDTO(
            endereco.getId(),
            endereco.getCep(),
            endereco.getLogradouro(),
            endereco.getNumero(),
            endereco.getComplemento(),  
            endereco.getBairro(),
            endereco.getIdCidade()
            );
    
        }
}
