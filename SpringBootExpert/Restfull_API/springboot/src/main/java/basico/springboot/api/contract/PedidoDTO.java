package basico.springboot.api.contract;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDTO {
    
    @NotNull(message = "Informe o codigo do cliente")
    private Integer cliente;
    
    @NotNull(message = "E obrigatorio ter uma quantidade")
    private BigDecimal total;
    
    private List<ItemPedidoDTO> items;
    
}