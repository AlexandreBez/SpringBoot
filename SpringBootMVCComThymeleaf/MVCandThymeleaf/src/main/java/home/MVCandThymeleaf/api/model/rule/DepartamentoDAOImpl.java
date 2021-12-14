package home.MVCandThymeleaf.api.model.rule;

import org.springframework.stereotype.Repository;

import home.MVCandThymeleaf.api.model.components.Departamento;
import home.MVCandThymeleaf.api.model.container.AbstractDAO;
import home.MVCandThymeleaf.api.model.rule.interfaces.DepartamentoInterface;

@Repository
public class DepartamentoDAOImpl extends AbstractDAO<Departamento, Long> implements DepartamentoInterface{

    
}