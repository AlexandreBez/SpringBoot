package com.sprinboot.api.controller;

import com.sprinboot.api.model.components.Cliente;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class MeuResource {
    
    // @RequestMapping(value = "/api/clientes/{id}", method = RequestMethod.GET)
    // public Cliente obterDadosDoCliente( @PathVariable Long id){
    //     Cliente cliente = new Cliente("Fulano", "000.000.000-00");
    //     return cliente;
    // }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente obterDadosDoCliente( @PathVariable Long id){
        System.out.printf("Id recebido via url: %d", id);
        Cliente cliente = new Cliente("Fulano", "000.000.000-00");
        return cliente;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente salvarCliente(@RequestBody Cliente cliente) { 
        // service.save(cliente)
        return cliente;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletaCliente(@PathVariable Long id){
        // service.buscarPorId(id)
        //service.delete(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente atualizaCliente(@PathVariable Long id, @RequestBody Cliente cliente){
        // service.buscarPorId(id)
        //service.update(id);
        return cliente;
    }
}