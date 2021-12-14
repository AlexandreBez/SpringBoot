package home.MVCandThymeleaf.api.model.rule;

import org.springframework.stereotype.Repository;

import home.MVCandThymeleaf.api.model.components.Funcionario;
import home.MVCandThymeleaf.api.model.container.AbstractDAO;
import home.MVCandThymeleaf.api.model.rule.interfaces.FuncionarioInterface;

@Repository
public class FuncionarioDAOImpl extends AbstractDAO<Funcionario, Long> implements FuncionarioInterface{
    
}