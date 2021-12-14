package basico.springboot.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import basico.springboot.api.contract.CredenciaisDTO;
import basico.springboot.api.contract.TokenDTO;
import basico.springboot.api.service.SenhaInvalidaException;
import basico.springboot.api.service.UsuarioServiceImple;
import basico.springboot.db.components.Usuario;
import basico.springboot.token.JwtService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    
    private final UsuarioServiceImple usuarioServiceImple;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody @Valid Usuario usuario) {
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        return usuarioServiceImple.salvar(usuario);
    }

    @PostMapping("/auth")
    public TokenDTO autenticar(@RequestBody CredenciaisDTO credenciais){
        
        try {
            Usuario usuario =  Usuario.builder()
                                        .login(credenciais.getLogin())
                                        .senha(credenciais.getSenha())
                                        .build();

            UserDetails usuarioAutenticado = usuarioServiceImple.autenticar(usuario);

            String token = jwtService.gerarTokens(usuario);
            return new TokenDTO(usuario.getLogin(), token);
        } catch (UsernameNotFoundException | SenhaInvalidaException e) {
          throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());  
        } 
        
    }
}