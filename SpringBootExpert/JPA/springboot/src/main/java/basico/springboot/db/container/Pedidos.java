package basico.springboot.db.container;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import basico.springboot.db.components.Cliente;
import basico.springboot.db.components.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer>{
    
    List<Pedido> findByCliente(Cliente cliente);
}