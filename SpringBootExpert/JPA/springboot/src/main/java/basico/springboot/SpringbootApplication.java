package basico.springboot;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import basico.springboot.db.components.Cliente;
import basico.springboot.db.components.Pedido;
import basico.springboot.db.container.Clientes;
import basico.springboot.db.container.Pedidos;

@SpringBootApplication
public class SpringbootApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes, @Autowired Pedidos pedidos) {
		return args -> {

			System.out.println("salvando cliente");

			Cliente cliente = new Cliente("Fulano");
			clientes.save(cliente);

			Pedido p = new Pedido();
			p.setCliente(cliente);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(100));

			pedidos.save(p);

			boolean existe = clientes.existsByNome("Cliente");

			Cliente fulano = clientes.findClienteFetchPedidos(cliente.getId());

			pedidos.findByCliente(fulano).forEach(System.out::println);

			// System.out.println(fulano);
			// System.out.println(fulano.getPedidos());

			// List<Cliente> todosClientes = clientes.findAll();
			// todosClientes.forEach(System.out::println);

			// System.out.println("atualizando cliente");
			// todosClientes.forEach(c -> {
			// 	c.setNome(c.getNome() + " atualizado.");
			// 	clientes.save(c);
			// });

			// System.out.println("buscando cliente");
			// clientes.findByNomeLike("Cli").forEach(System.out::println);

			// System.out.println("deletando cliente");
			// clientes.findAll().forEach(c -> {
			// 	clientes.delete(c);
			// });

			// todosClientes = clientes.findAll();
			// if(todosClientes.isEmpty()){ 
			// 	System.out.println("Nenhum cliente encontrado");
			// }else{ 
			// 	todosClientes.forEach(System.out::println);
			// }
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
