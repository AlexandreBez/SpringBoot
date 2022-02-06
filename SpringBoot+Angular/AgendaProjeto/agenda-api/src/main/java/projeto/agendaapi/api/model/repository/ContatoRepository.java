package projeto.agendaapi.api.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.agendaapi.api.model.entity.Contato;

// JPA contact repository (CRUD)
public interface ContatoRepository extends JpaRepository<Contato, Integer>{
    
}