package home.MVCandThymeleaf.api.model.service.interfaces;

import java.util.List;

import home.MVCandThymeleaf.api.model.components.Departamento;

public interface DepartamentoServiceInterface {
    
    void salvar(Departamento Departamento);

    void editar(Departamento Departamento);

    void excluir(Long id);

    Departamento buscarPorId(Long id);

    List<Departamento> buscarTodos();
}