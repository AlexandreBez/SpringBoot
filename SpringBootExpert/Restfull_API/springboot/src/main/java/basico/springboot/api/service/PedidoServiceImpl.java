package basico.springboot.api.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import basico.springboot.api.contract.ItemPedidoDTO;
import basico.springboot.api.contract.PedidoDTO;
import basico.springboot.api.enums.StatusPedido;
import basico.springboot.api.interfaces.PedidoService;
import basico.springboot.db.components.Cliente;
import basico.springboot.db.components.ItemPedido;
import basico.springboot.db.components.Pedido;
import basico.springboot.db.components.Produto;
import basico.springboot.db.container.Clientes;
import basico.springboot.db.container.ItemsPedido;
import basico.springboot.db.container.Pedidos;
import basico.springboot.db.container.Produtos;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService{
    
    private final Pedidos repository;
    private final Clientes clientesRepository;
    private final Produtos produtosRepository;
    private final ItemsPedido itemsPedidoRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {

        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository
        .findById(idCliente)
        .orElseThrow( () -> new RegraNegocioException("Codigo de cliente inválido") );

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.REALIZADO);

        List<ItemPedido> itemPedidos = converterItems(pedido, dto.getItems());
        repository.save(pedido);
        itemsPedidoRepository.saveAll(itemPedidos);
        pedido.setItens(itemPedidos);

        return pedido;
    }

    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items){
        if (items.isEmpty()) {
            throw new RegraNegocioException("Não e possivel realizar um pedido sem items.");
        }

        return items
                .stream()
                .map( dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = produtosRepository
                                    .findById(idProduto)
                                    .orElseThrow( 
                                        () -> new RegraNegocioException(
                                            "Codigo de produto invalido" + idProduto 
                                    ));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);

                    return itemPedido;
                }).collect(Collectors.toList());
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return repository.findByIdFetchItens(id);
    }

    @Override
    @Transactional
    public void AtualizaStatus(Integer id, StatusPedido statusPedido) { 
        repository
                .findById(id)
                .map( pedido -> {
                    pedido.setStatus(statusPedido);
                    return repository.save(pedido);
                }).orElseThrow( () -> new PedidoNaoEncotradoException() );
    }
}