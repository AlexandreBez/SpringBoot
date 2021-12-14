package home.MVCandThymeleaf.api.model.rule;

import org.springframework.stereotype.Repository;

import home.MVCandThymeleaf.api.model.components.Cargo;
import home.MVCandThymeleaf.api.model.container.AbstractDAO;
import home.MVCandThymeleaf.api.model.rule.interfaces.CargoInterface;

@Repository
public class CargoDAOImpl extends AbstractDAO<Cargo, Long> implements CargoInterface{
    
}