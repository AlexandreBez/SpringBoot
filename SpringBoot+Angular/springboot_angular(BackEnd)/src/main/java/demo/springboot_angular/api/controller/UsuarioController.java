/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo.springboot_angular.api.controller;

import demo.springboot_angular.api.controller.exceptions.UsuarioCadstradoException;
import demo.springboot_angular.api.model.entity.Usuario;
import demo.springboot_angular.api.model.repository.jpa.UsuarioRepository;
import demo.springboot_angular.api.service.UsuarioService;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author lucas
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    
    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    public UsuarioService getService() {
        return service;
    }

    public void setService(UsuarioService service) {
        this.service = service;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(
            @RequestBody @Valid Usuario usuario
    ){
        try {
            service.salvar(usuario);
        } catch (UsuarioCadstradoException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        
    }
}
