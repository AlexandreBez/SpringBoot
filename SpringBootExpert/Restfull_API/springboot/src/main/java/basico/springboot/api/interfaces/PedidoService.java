package basico.springboot.api.interfaces;

import java.util.Optional;

import basico.springboot.api.contract.PedidoDTO;
import basico.springboot.api.enums.StatusPedido;
import basico.springboot.db.components.Pedido;

public interface PedidoService {
    
    Pedido salvar(PedidoDTO dto);
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void AtualizaStatus(Integer id, StatusPedido statusPedido);
}