package basico.springboot.db.container;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import basico.springboot.db.components.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Integer>{
 
    Optional<Usuario> findByLogin(String login);
}