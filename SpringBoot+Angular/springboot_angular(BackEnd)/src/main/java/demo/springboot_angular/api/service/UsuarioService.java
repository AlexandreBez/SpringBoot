package demo.springboot_angular.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import demo.springboot_angular.api.controller.exceptions.UsuarioCadstradoException;
import demo.springboot_angular.api.model.entity.Usuario;
import demo.springboot_angular.api.model.repository.jpa.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{

    @Autowired
    private UsuarioRepository repository;

    public Usuario salvar(Usuario usuario){
        boolean exists = repository.existsByUsername(usuario.getUsername());

        if (exists) {
            throw new UsuarioCadstradoException(usuario.getUsername());
        }

        return repository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = repository
            .findByUserName(username)
            .orElseThrow(
                () -> new UsernameNotFoundException("Login não encontrado.")
            );

            return User
                .builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles("USER")
                .build()
            ;
    }
    

}