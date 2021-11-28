package basico.springboot.db.container;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsPedido extends JpaRepository<ItemsPedido, Integer>{
    
}