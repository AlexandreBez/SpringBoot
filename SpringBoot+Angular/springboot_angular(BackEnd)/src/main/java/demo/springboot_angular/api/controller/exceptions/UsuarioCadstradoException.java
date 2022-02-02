package demo.springboot_angular.api.controller.exceptions;

public class UsuarioCadstradoException extends RuntimeException {
    
    public UsuarioCadstradoException(
        String login
    ){
        super("Usuário já cadastrado para o login " + login);
    }
}