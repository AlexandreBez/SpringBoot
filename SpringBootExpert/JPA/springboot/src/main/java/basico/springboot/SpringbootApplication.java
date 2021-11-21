package basico.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import basico.springboot.db.components.Cliente;
import basico.springboot.db.container.Clientes;

@SpringBootApplication
public class SpringbootApplication {

	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {

			System.out.println("salvando cliente");

			clientes.salvar(new Cliente("Cliente"));
			clientes.salvar(new Cliente("Cliente 2"));

			// List<Cliente> todosClientes = clientes.obterTodos();
			// todosClientes.forEach(System.out::println);

			// System.out.println("atualizando cliente");
			// todosClientes.forEach(c -> {
			// 	c.setNome(c.getNome() + " atualizado.");
			// 	clientes.Atualizar(c);
			// });

			// System.out.println("buscando cliente");
			// clientes.buscarPorNome("Cli").forEach(System.out::println);

			// System.out.println("deletando cliente");
			// clientes.obterTodos().forEach(c -> {
			// 	clientes.deletar(c);
			// });

			// todosClientes = clientes.obterTodos();
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
