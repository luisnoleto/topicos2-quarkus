package br.unitins.topicos1.model.converterjpa;

import br.unitins.topicos1.model.FormaPagamento;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class FormaPagamentoConverter implements AttributeConverter<FormaPagamento, Integer> {

    @Override
    public Integer convertToDatabaseColumn(FormaPagamento tipo) {
        
        return (tipo == null ? null : tipo.getId());
    }

    @Override
    public FormaPagamento convertToEntityAttribute(Integer id) {
        
        return FormaPagamento.ValueOf(id);
    }


    
}