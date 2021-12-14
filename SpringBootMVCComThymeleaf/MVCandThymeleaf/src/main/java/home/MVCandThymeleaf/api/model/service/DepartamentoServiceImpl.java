package home.MVCandThymeleaf.api.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import home.MVCandThymeleaf.api.model.components.Departamento;
import home.MVCandThymeleaf.api.model.rule.DepartamentoDAOImpl;
import home.MVCandThymeleaf.api.model.service.interfaces.DepartamentoServiceInterface;

@Service
@Transactional(readOnly = false)
public class DepartamentoServiceImpl implements DepartamentoServiceInterface{

    @Autowired
    private DepartamentoDAOImpl dao;

    @Override
    public void salvar(Departamento departamento) {
        dao.save(departamento);
    }

    @Override
    public void editar(Departamento departamento) {
        dao.update(departamento);
    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Departamento buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Departamento> buscarTodos() {
        return dao.findAll();
    }    
}