package home.MVCandThymeleaf.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import home.MVCandThymeleaf.api.model.components.Departamento;
import home.MVCandThymeleaf.api.model.service.interfaces.DepartamentoServiceInterface;

@Component
public class StringToDepartamento implements Converter<String, Departamento>{

    @Autowired
    private DepartamentoServiceInterface service;

    @Override
    public Departamento convert(String text) {
        if (text.isEmpty()) {
            return null;
        }

        Long id = Long.valueOf(text);
        return service.buscarPorId(id);
    }
    
}