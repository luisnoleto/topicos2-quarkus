package br.unitins.topicos1.model.converterjpa;

import br.unitins.topicos1.model.Desempenho;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class DesempenhoConverter implements AttributeConverter<Desempenho, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Desempenho tipo) {
        
        return (tipo == null ? null : tipo.getId());
    }

    @Override
    public Desempenho convertToEntityAttribute(Integer id) {
        
        return Desempenho.ValueOf(id);
    }


    
}