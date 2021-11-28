package basico.springboot.db.container;

import org.springframework.data.jpa.repository.JpaRepository;

import basico.springboot.db.components.Produto;

public interface Produtos extends JpaRepository<Produto, Integer>{
    
    
}