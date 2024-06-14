package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.pedido.PedidoDTO;
import br.unitins.topicos1.dto.pedido.PedidoResponseDTO;
import jakarta.validation.Valid;

public interface PedidoService {

    PedidoResponseDTO insert(String login, @Valid PedidoDTO dto);

    PedidoResponseDTO findById(Long id);

    List<PedidoResponseDTO> getAll(int page, int pageSize);

    // Recurso extra
    List<PedidoResponseDTO> findByAll(String login);

    long count();

    List<PedidoResponseDTO> findByUsuarioId(Long usuarioId);
}
