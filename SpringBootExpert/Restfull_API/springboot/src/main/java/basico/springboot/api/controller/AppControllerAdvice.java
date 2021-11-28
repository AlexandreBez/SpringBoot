package basico.springboot.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import basico.springboot.api.ApiErrors;
import basico.springboot.api.service.PedidoNaoEncotradoException;
import basico.springboot.api.service.RegraNegocioException;

@RestControllerAdvice
public class AppControllerAdvice {
    
    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleRegraNegocioException(RegraNegocioException exc){
        String mensagemErro = exc.getMessage();
        return new ApiErrors(mensagemErro);
    }

    @ExceptionHandler(PedidoNaoEncotradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handlePedidoNotFoundException(PedidoNaoEncotradoException exc){
        return new ApiErrors(exc.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleMethodNotValidException(MethodArgumentNotValidException exc){
        List<String> errors = exc
                                .getBindingResult()
                                .getAllErrors()
                                .stream()
                                .map( erro -> erro.getDefaultMessage())
                                .collect(Collectors.toList());
                                
        return new ApiErrors(errors);
    }
}