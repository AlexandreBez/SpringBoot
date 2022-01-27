package demo.springboot_angular.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import demo.springboot_angular.api.controller.converter.BigDecimalConverter;
import demo.springboot_angular.api.model.entity.Cliente;
import demo.springboot_angular.api.model.entity.ServicoPrestado;
import demo.springboot_angular.api.model.repository.jpa.ClienteRepository;
import demo.springboot_angular.api.model.repository.jpa.ServicoPrestadoRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoController {

    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository repository;
    private final BigDecimalConverter bigDecimalConverter;
    
    public ServicoPrestadoController(ClienteRepository clienteRepository, ServicoPrestadoRepository repository,
            BigDecimalConverter bigDecimalConverter) {
        this.clienteRepository = clienteRepository;
        this.repository = repository;
        this.bigDecimalConverter = bigDecimalConverter;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar( @RequestBody @Valid ServicoPrestadoDTO dto) {
        
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdCliente();

        Optional<Cliente> clienteOptional = clienteRepository.findById(idCliente);
        Cliente cliente = clienteRepository.findById(idCliente)
            .orElseThrow( 
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente.")
             );

        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor( bigDecimalConverter.coverter(dto.getPreco()));

        return repository.save(servicoPrestado);
    }
    
    @GetMapping
    public List<ServicoPrestado> pesquisar(
        @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
        @RequestParam(value = "mes", required = false) Integer mes
    ){
        return repository.findByNomeClienteAndMes("%"+nome+"%", mes);
    }
}