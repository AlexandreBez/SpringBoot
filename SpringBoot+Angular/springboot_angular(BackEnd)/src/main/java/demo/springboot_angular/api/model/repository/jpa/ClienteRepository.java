package demo.springboot_angular.api.model.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.springboot_angular.api.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}