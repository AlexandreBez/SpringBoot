package home.MVCandThymeleaf.api.model.rule.interfaces;

import java.util.List;

import home.MVCandThymeleaf.api.model.components.Departamento;

public interface DepartamentoInterface {
    
    void save(Departamento departamento);

    void update(Departamento departamento);

    void delete(Long id);

    Departamento findById(Long id);

    List<Departamento> findAll();
}