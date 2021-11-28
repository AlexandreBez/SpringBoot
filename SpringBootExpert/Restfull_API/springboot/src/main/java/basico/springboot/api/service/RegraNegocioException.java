package basico.springboot.api.service;

public class RegraNegocioException extends RuntimeException{
    
    public RegraNegocioException(String message){
        super(message);
    }
}