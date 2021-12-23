package home.MVCandThymeleaf.api.controller;

import java.security.Provider.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import home.MVCandThymeleaf.api.model.components.Cargo;
import home.MVCandThymeleaf.api.model.service.interfaces.CargoServiceInterface;

@Component
public class StringToCargoConversor implements Converter<String, Cargo>{

    @Autowired
    private CargoServiceInterface service;
    
    @Override
    public Cargo convert(String text){
        if(text.isEmpty()){
            return null;
        }
        Long id = Long.valueOf(text);
        return service.buscarPorId(id);
    }
}