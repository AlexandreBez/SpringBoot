package basico.springboot.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import basico.springboot.Devlopment;

@Devlopment
public class MyConfiguration {
    
    @Bean
    public CommandLineRunner executar() {
            return args -> {
                System.out.println("RODANDO DESENVOLVIMENTO");
            };
    }
}