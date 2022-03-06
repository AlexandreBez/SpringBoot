package com.junit;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class PrimeiroTest {
    
    @Mock
    Calculadora calculadora;
    
    int numero1 = 10, numero2 = 5;
    
    @BeforeEach
    public void setUp() {
        calculadora = new Calculadora();
    }
    
    @Test
    public void estruturaDeTeste(){
        // cenario
        int numero1 = 10, numero2 = 5;
       
        //execucao
        int resultado = numero1 + numero2;
          
        //verificações
        // Assertions.assertThat(resultado).isBetween(14, 16);
        Assertions.assertThat(resultado).isBetween(14, 16);
    }
}
