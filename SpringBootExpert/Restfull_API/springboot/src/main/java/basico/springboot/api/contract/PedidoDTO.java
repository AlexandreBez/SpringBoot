package basico.springboot.api.contract;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import basico.springboot.validation.NotEmptyList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDTO {
    
    @NotNull(message = "{campo.codigo-cliente.obrigatorio}")
    private Integer cliente;
    
    @NotNull(message = "E obrigatorio ter uma quantidade")
    private BigDecimal total;
    
    @NotEmptyList(message = "Pedido não pode ser realizado sem pedidos")
    private List<ItemPedidoDTO> items;
    
}