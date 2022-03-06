package com.junit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CadastroPessoasTest {
    
    @Test
    @DisplayName("Deve criar o cadastro de pessoas")
    public void deveCriarCadastroDePessoas(){

        // Cenario e Execução
        CadastroPessoas cadastro = new CadastroPessoas();
        
        // Verificação
        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test
    @DisplayName("Deve adicionar uma pessoas")
    public void deveAdicionarUmaPessoa() {
        
        // Cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa= new Pessoa();
        pessoa.setNome("Wilson");

        // Execução
        cadastroPessoas.adicionar(pessoa);

        // verificação
        Assertions.assertThat(cadastroPessoas.getPessoas())
            .isNotEmpty()
            .hasSize(1)
            .contains(pessoa);
    }
    
    @Test
    @DisplayName("Deve trazer erro ao adicionar pessoa com nome vazio")
    public void nãoDeveAdicionarPessoaComNomeVazio(){
        // Cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        
        // Execução
        org.junit.jupiter.api.Assertions.assertThrows(
                PessoaSemNotException.class, () -> cadastroPessoas.adicionar(pessoa)
        );
        
    }
    
    @Test
    @DisplayName("Deve remover o cadastro de pessoa")
    public void deveRemoverUmaPessoa(){
        //cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Wilson");
        cadastroPessoas.adicionar(pessoa);
        
        // execução
        cadastroPessoas.remover(pessoa);
        
        // Verificação
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();
                
    }
    
    @Test()
    @DisplayName("Deve lançar erro ao excluir cadastro de pessoas que não existe")
    public void deveLancarErroAoTentarRemoverPessoaInexistente(){
        //cenario
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        
        // execução
        org.junit.jupiter.api.Assertions.assertThrows(
                CadastroVazioException.class, () -> cadastroPessoas.remover(pessoa)
        );
    }

}