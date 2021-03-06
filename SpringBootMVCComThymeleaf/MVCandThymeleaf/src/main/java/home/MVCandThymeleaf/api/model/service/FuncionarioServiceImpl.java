package home.MVCandThymeleaf.api.model.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import home.MVCandThymeleaf.api.model.components.Funcionario;
import home.MVCandThymeleaf.api.model.rule.FuncionarioDAOImpl;
import home.MVCandThymeleaf.api.model.rule.interfaces.FuncionarioInterface;
import home.MVCandThymeleaf.api.model.service.interfaces.FuncionarioServiceInterface;

@Service
@Transactional(readOnly = false)
public class FuncionarioServiceImpl implements FuncionarioServiceInterface{

    @Autowired
    private FuncionarioInterface dao;

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

    @Override
    public List<Funcionario> buscarPorNome(String nome) {
        return dao.findByNome(nome);
    }

    @Override
    public List<Funcionario> buscarPorCargo(Long id) {
        return dao.findByCargoId(id);
    }

    @Override
    public List<Funcionario> buscarPorDatas(LocalDate entrada, LocalDate saida) {
        if (entrada != null && saida != null) {
            return dao.findByDataEntradaDataSaida(entrada, saida);
        } else if(entrada != null){
            return dao.findByDataEntrada(entrada);
        } else if(saida != null){
            return dao.findByDataSaida(saida);
        } else {
            return new ArrayList<>();
        }
    }
    
}