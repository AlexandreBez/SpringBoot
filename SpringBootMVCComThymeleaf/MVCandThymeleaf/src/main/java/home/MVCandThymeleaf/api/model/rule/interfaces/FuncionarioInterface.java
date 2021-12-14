package home.MVCandThymeleaf.api.model.rule.interfaces;

import java.util.List;

import home.MVCandThymeleaf.api.model.components.Funcionario;

public interface FuncionarioInterface {
    
    void save(Funcionario Funcionario);

    void update(Funcionario Funcionario);

    void delete(Long id);

    Funcionario findById(Long id);

    List<Funcionario> findAll();
}