package basico.springboot.api.service;

public class PedidoNaoEncotradoException extends RuntimeException{
    
    public PedidoNaoEncotradoException() {
        super("Pedido não encontrado");
    }
}