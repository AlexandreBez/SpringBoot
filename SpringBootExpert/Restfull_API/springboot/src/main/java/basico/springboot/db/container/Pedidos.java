package basico.springboot.db.container;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import basico.springboot.db.components.Cliente;
import basico.springboot.db.components.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer>{
    
    List<Pedido> findByCliente(Cliente cliente);

    @Query(" select p from Pedido p left join fetch p.itens where p.id =:id")
    Optional<Pedido> findByIdFetchItens(Integer id);
}