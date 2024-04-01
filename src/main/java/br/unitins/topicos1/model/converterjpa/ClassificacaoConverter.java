package br.unitins.topicos1.model.converterjpa;


import br.unitins.topicos1.model.Classificacao;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ClassificacaoConverter implements AttributeConverter<Classificacao, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Classificacao classificacao) {
        return (classificacao == null ? null : classificacao.getId());
    }

    @Override
    public Classificacao convertToEntityAttribute(Integer id) {
        return Classificacao.ValueOf(id);
    }
    
}
