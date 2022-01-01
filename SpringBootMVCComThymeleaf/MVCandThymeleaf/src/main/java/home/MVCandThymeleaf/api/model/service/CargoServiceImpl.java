package home.MVCandThymeleaf.api.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import home.MVCandThymeleaf.api.model.components.Cargo;
import home.MVCandThymeleaf.api.model.rule.CargoDAOImpl;
import home.MVCandThymeleaf.api.model.service.interfaces.CargoServiceInterface;
import home.MVCandThymeleaf.api.pagination.PaginacaoUtil;

@Service
public class CargoServiceImpl implements CargoServiceInterface{

    @Autowired
    private CargoDAOImpl dao;

    @Override
    @Transactional(readOnly = false)
    public void salvar(Cargo cargo) {
        dao.save(cargo);
    }

    @Override
    @Transactional(readOnly = false)
    public void editar(Cargo cargo) {
        dao.update(cargo);
    }

    @Override
    @Transactional(readOnly = false)
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Cargo buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cargo> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public boolean cargoTemFuncionario(Long id) {

        if (buscarPorId(id).getFuncionarios().isEmpty()){
            return false;
        }
    
        return true;
    }

    @Override
    public PaginacaoUtil<Cargo> buscaPagina(int pagina, String direcao){   
        return dao.buscaPagina(pagina, direcao);
    }    
    
}