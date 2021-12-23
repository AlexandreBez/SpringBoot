package home.MVCandThymeleaf.api.model.service.interfaces;

import java.util.List;

import home.MVCandThymeleaf.api.model.components.Funcionario;

public interface FuncionarioServiceInterface {
    
    void salvar(Funcionario funcionario);

    void editar(Funcionario funcionario);

    void excluir(Long id);

    Funcionario buscarPorId(Long id);

    List<Funcionario> buscarTodos();

    List<Funcionario> buscarPorNome(String nome);

    List<Funcionario> buscarPorCargo(Long id);
}