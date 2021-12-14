package home.MVCandThymeleaf.api.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import home.MVCandThymeleaf.api.model.components.Funcionario;
import home.MVCandThymeleaf.api.model.rule.FuncionarioDAOImpl;
import home.MVCandThymeleaf.api.model.service.interfaces.FuncionarioServiceInterface;

@Service
@Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioServiceInterface{

    @Autowired
    private FuncionarioDAOImpl dao;

    @Override
    public void salvar(Funcionario funcionario) {
        dao.save(funcionario);
    }

    @Override
    public void editar(Funcionario funcionario) {
        dao.update(funcionario);
    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Funcionario buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Funcionario> buscarTodos() {
        return dao.findAll();
    }
    
}