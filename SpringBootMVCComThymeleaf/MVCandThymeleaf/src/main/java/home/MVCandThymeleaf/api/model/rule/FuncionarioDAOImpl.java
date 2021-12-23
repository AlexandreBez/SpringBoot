package home.MVCandThymeleaf.api.model.rule;

import java.util.List;

import org.springframework.stereotype.Repository;

import home.MVCandThymeleaf.api.model.components.Funcionario;
import home.MVCandThymeleaf.api.model.container.AbstractDAO;
import home.MVCandThymeleaf.api.model.rule.interfaces.FuncionarioInterface;

@Repository
public class FuncionarioDAOImpl extends AbstractDAO<Funcionario, Long> implements FuncionarioInterface{

    @Override
    public List<Funcionario> findByNome(String nome) {
        return createQuery("select f from Funcionario f where f.nome like concat('%', ?1, '%')", nome);
    }

    @Override
    public List<Funcionario> findByCargoId(Long id) {
        return createQuery("select f from Funcionario f where f.cargo.id = ?1", id);
    }

}