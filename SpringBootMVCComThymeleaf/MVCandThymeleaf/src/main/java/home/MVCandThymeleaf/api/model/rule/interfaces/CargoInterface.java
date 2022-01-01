package home.MVCandThymeleaf.api.model.rule.interfaces;

import java.util.List;

import home.MVCandThymeleaf.api.model.components.Cargo;
import home.MVCandThymeleaf.api.pagination.PaginacaoUtil;

public interface CargoInterface {
    
    void save(Cargo Cargo);

    void update(Cargo Cargo);

    void delete(Long id);

    Cargo findById(Long id);

    List<Cargo> findAll();

    PaginacaoUtil<Cargo> buscaPagina(int pagina, String direcao);
}