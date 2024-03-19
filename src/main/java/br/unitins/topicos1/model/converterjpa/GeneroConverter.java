package br.unitins.topicos1.model.converterjpa;

import br.unitins.topicos1.model.Genero;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class GeneroConverter implements AttributeConverter<Genero, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Genero genero) {
        
        return (genero == null ? null : genero.getId());
    }

    @Override
    public Genero convertToEntityAttribute(Integer id) {
        
        return Genero.ValueOf(id);
    }

    
}
 