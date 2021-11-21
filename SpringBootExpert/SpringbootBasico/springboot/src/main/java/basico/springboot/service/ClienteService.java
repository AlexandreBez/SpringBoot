package basico.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basico.springboot.db.ClientesRepository;
import basico.springboot.model.Cliente;

@Service
public class ClienteService {

    private ClientesRepository repository;
    
    public ClienteService(ClientesRepository repository){
        this.repository = repository;
    }

    // @Autowired
    // public void setRepository(ClientesRepository repository){
    //     this.repository = repository;
    // }

    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        this.repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){
        //aplica validação
    }
}