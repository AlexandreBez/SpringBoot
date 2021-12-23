package home.MVCandThymeleaf.api.model.service.interfaces;

import java.util.List;

import home.MVCandThymeleaf.api.model.components.Cargo;

public interface CargoServiceInterface {
 
    void salvar(Cargo Cargo);

    void editar(Cargo Cargo);

    void excluir(Long id);

    Cargo buscarPorId(Long id);

    List<Cargo> buscarTodos();

    boolean cargoTemFuncionario(Long id);
}