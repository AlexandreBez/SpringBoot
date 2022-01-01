package home.MVCandThymeleaf.api.model.rule;

import java.util.List;

import org.springframework.stereotype.Repository;

import home.MVCandThymeleaf.api.model.components.Cargo;
import home.MVCandThymeleaf.api.model.container.AbstractDAO;
import home.MVCandThymeleaf.api.model.rule.interfaces.CargoInterface;
import home.MVCandThymeleaf.api.pagination.PaginacaoUtil;

@Repository
public class CargoDAOImpl extends AbstractDAO<Cargo, Long> implements CargoInterface{
    
    public PaginacaoUtil<Cargo> buscaPagina(int pagina, String direcao){

        int tamanho = 5;
        int inicio = (pagina - 1) * tamanho;
        List<Cargo> cargos = getEntityManager()
            .createQuery("select c from Cargo c order by c.nome " + direcao, Cargo.class)
            .setFirstResult(inicio)
            .setMaxResults(tamanho)
            .getResultList()
        ;

        long totalRegistros = count();
        long totalDePaginas = (totalRegistros + (tamanho - 1)) / tamanho;

        return new PaginacaoUtil<>(tamanho, pagina, totalDePaginas, direcao, cargos);
    }

    public long count() {
        return getEntityManager()
            .createQuery("select count(*) from Cargo", Long.class)
            .getSingleResult();
    }

}