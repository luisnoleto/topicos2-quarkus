package br.unitins.topicos1.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.unitins.topicos1.dto.itempedido.ItemPedidoDTO;
import br.unitins.topicos1.dto.pedido.PedidoDTO;
import br.unitins.topicos1.dto.pedido.PedidoResponseDTO;
import br.unitins.topicos1.model.Endereco;
import br.unitins.topicos1.model.FormaPagamento;
import br.unitins.topicos1.model.ItemPedido;
import br.unitins.topicos1.model.Jogo;
import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.model.StatusPedido;
import br.unitins.topicos1.model.Usuario;
import br.unitins.topicos1.repository.JogoRepository;
import br.unitins.topicos1.repository.PedidoRepository;
import br.unitins.topicos1.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    JogoRepository jogoRepository;

    @Inject
    PedidoRepository pedidoRepository;

    @Override
    @Transactional
    public PedidoResponseDTO insert(String login, @Valid PedidoDTO dto) {
        Pedido novoPedido = new Pedido();
        Usuario usuario = usuarioRepository.findByLogin(login);

        novoPedido.setUsuario(usuario);
        novoPedido.setDataCompra(LocalDateTime.now());

        // Front-end resolve facil facil a excessão desse possivel erro, não deixando o
        // usuario escolher além do seus endereços listados
        for (Endereco end : usuario.getListaEndereco()) {
            if (dto.endereco() == end.getId()) {
                novoPedido.setEndereco(end);
            }

        }

        novoPedido.setPagamento(FormaPagamento.ValueOf(dto.pagamento()));

        novoPedido.setStatusPedido(StatusPedido.PROCESSANDO);

        // calculo do total do pedido
        Double total = 0.0;
        for (ItemPedidoDTO itemDto : dto.itens()) {
            total += (itemDto.preco() * itemDto.quantidade());
        }
        novoPedido.setTotalPedido(total);

        // adicionando os itens do pedido
        novoPedido.setItens(new ArrayList<ItemPedido>());
        for (ItemPedidoDTO itemDto : dto.itens()) {
            ItemPedido item = new ItemPedido();
            item.setPreco(itemDto.preco());
            item.setQuantidade(itemDto.quantidade());
            item.setPedido(novoPedido);
            Jogo jogo = jogoRepository.findById(itemDto.idProduto());
            item.setJogo(jogo);

            // atualizado o estoque
            jogo.setEstoque(jogo.getEstoque() - item.getQuantidade());

            novoPedido.getItens().add(item);
        }

        // salvando no banco
        pedidoRepository.persist(novoPedido);

        return PedidoResponseDTO.valueOf(novoPedido);

    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        return PedidoResponseDTO.valueOf(pedidoRepository.findById(id));
    }

    @Override
    public List<PedidoResponseDTO> getAll(int page, int pageSize) {
        List<Pedido> list = pedidoRepository.findAll().page(page, pageSize).list();

        return list.stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public List<PedidoResponseDTO> findByAll(String login) {
        return pedidoRepository.listAll().stream()
                .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public long count() {
        return pedidoRepository.count();
    }

    // @Override
    // public List<PedidoResponseDTO> findByUsuario(String login) {
    // Usuario usuario = usuarioRepository.findByLogin(login);
    // return pedidoRepository.findByUsuario(usuario).stream()
    // .map(e -> PedidoResponseDTO.valueOf(e)).toList();
    // }
    @Override
    public List<PedidoResponseDTO> findByUsuarioId(Long usuarioId) {
        List<Pedido> pedidos = pedidoRepository.findByUsuarioId(usuarioId);
        return pedidos.stream()
                .map(PedidoResponseDTO::valueOf)
                .collect(Collectors.toList());
    }
}
