package br.unitins.topicos1.model.converterjpa;

import br.unitins.topicos1.model.TipoChavePix;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TipoChavePixConverter implements AttributeConverter<TipoChavePix, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TipoChavePix tipo) {
        
        return (tipo == null ? null : tipo.getId());
    }

    @Override
    public TipoChavePix convertToEntityAttribute(Integer id) {
        
        return TipoChavePix.ValueOf(id);
    }


    
}