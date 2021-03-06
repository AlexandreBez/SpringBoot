package basico.springboot.db.container;

import java.util.List;

// import javax.persistence.EntityManager;
// import javax.persistence.TypedQuery;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
// import org.springframework.stereotype.Repository;
// import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import basico.springboot.db.components.Cliente;

// @Repository
public interface Clientes extends JpaRepository<Cliente, Integer>{

    @Query(value = "select * from Cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Cliente> findByNomeLike(@Param("nome") String nome);

    // List<Cliente> findByNomeLike(String nome);
    // List<Cliente> findByNomeOrId(String nome, Integer id);

    @Query("delete from Cliente c where c.nome =:nome")
    @Modifying
    void deleteByNome(String nome);

    @Query("select c from Cliente c left join fetch c.pedidos where c.id = :id")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);

    boolean existsByNome(String nome);

    // @Autowired
    // private EntityManager entityManager;

    // @Transactional
    // public Cliente Atualizar(Cliente cliente){
    //     entityManager.merge(cliente);
    //     return cliente;
    // } 

    // @Transactional
    // public void deletar(Cliente cliente){
    //     if(!entityManager.contains(cliente)){
    //         cliente = entityManager.merge(cliente);
    //     }
    //     entityManager.remove(cliente);
    // }

    // @Transactional
    // public void deletar(Integer id){
    //     Cliente cliente = entityManager.find(Cliente.class, id);
    //     deletar(cliente);
    // }

    // @Transactional(readOnly = true)
    // public List<Cliente> buscarPorNome(String nome) {
    //     String jpgl = "Select c from Cliente c where c.nome like :nome ";
    //     TypedQuery<Cliente> query = entityManager.createQuery(jpgl, Cliente.class);
    //     query.setParameter("nome", "%" + nome + "%");
    //     return query.getResultList();
    // }

    // @Transactional
    // public List<Cliente> obterTodos() {
    //     return entityManager
    //             .createQuery("from cliente", Cliente.class)
    //             .getResultList();
    // }

    // @Transactional
    // public Cliente salvar(Cliente cliente){
    //     entityManager.persist(cliente);
    //     return cliente;
    // }

}