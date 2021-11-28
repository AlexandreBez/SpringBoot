package basico.springboot.api.contract;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizacaoStatusPedidoDTO {
    private String novoStatus;
}