package basico.springboot.api.service;

public class SenhaInvalidaException extends RuntimeException{
 
    public SenhaInvalidaException() {
        super("Senha Invalida");
    }
}