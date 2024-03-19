package br.unitins.topicos1.model.converterjpa;


import br.unitins.topicos1.model.StatusPedido;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusPedidoConverter implements AttributeConverter<StatusPedido, Integer> {

    @Override
    public Integer convertToDatabaseColumn(StatusPedido status) {
        return (status == null ? null : status.getId());
    }

    @Override
    public StatusPedido convertToEntityAttribute(Integer id) {
        return StatusPedido.valueOf(id);
    }
    
}
