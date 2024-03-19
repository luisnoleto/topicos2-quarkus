package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.pedido.PedidoDTO;
import br.unitins.topicos1.dto.pedido.PedidoResponseDTO;
import jakarta.validation.Valid;

public interface PedidoService {
    
    public PedidoResponseDTO insert(String login, @Valid PedidoDTO dto);
    public PedidoResponseDTO findById(Long id);
    // public List<PedidoResponseDTO> findByAll();
    public List<PedidoResponseDTO> findByAll(String login);
}
