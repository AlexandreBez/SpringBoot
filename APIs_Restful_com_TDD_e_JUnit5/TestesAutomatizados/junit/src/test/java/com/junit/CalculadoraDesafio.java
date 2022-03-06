package com.junit;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraDesafio {

    Calculadora calculadora;

    @Before
    public void setUp(){
        calculadora = new Calculadora();
    }
    
    @Test
    public void testeSomar(){

        // Cenário
        int num1 = 10, num2 = 5;

        // Execução
        int resultado = calculadora.somar(num1, num2);

        // Verificações
        Assertions.assertThat(resultado).isEqualTo(15);

    }

    @Test(expected = RuntimeException.class)
    public void testeNãoSomaNegativo(){

        // Cenário
        int num1 = -10;
        int num2 = 5;

        // Execução
        calculadora.somar(num1, num2);
    }

    @Test()
    public void testeSubtrair(){

        // Cenário
        int num1 = 10;
        int num2 = 5;

        // Execução
        int resultado = calculadora.subtrair(num1, num2);

        // Verificação
        Assertions.assertThat(resultado).isEqualTo(5);
    }

    @Test()
    public void testeMultiplicar(){

        // Cenário
        int num1 = 10;
        int num2 = 5;

        // Execução
        int resultado = calculadora.multiplicar(num1, num2);

        // Verificação
        Assertions.assertThat(resultado).isEqualTo(50);
    }

    @Test
    public void testeDividir(){

        // Cenário
        int num1 = 10;
        int num2 = 2;

        // Execução
        int resultado = calculadora.dividir(num1, num2);

        // Verificação
        Assertions.assertThat(resultado).isEqualTo(5);
    }


}

class Calculadora {

    int somar(int num, int num2) {

        if (num < 0 || num2 < 0) {
            throw new RuntimeException("Não é permitido somar numeros negativos.");
        }

        return num + num2;
    }

    int subtrair(int num, int num2) {
        return num - num2;
    }

    int multiplicar(int num, int num2) {
        return num * num2;
    }

    int dividir(int num, int num2) {
        return num / num2;
    }
}