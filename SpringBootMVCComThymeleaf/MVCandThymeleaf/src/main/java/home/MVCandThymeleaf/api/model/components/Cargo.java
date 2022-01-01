package home.MVCandThymeleaf.api.model.components;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import home.MVCandThymeleaf.api.model.container.AbstractEntity;

@Entity
@Table(name = "CARGO")
public class Cargo extends AbstractEntity<Long>{
    
    @NotBlank(message = "Informe um nome")
    @Size(min = 3, max = 60, message = "O nome deve ter entre {min} e {max} caracteres")
    @Column(name = "nome", nullable = false, unique = true, length = 60)
    private String nome;

    @OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionarios;
    
    @NotNull(message = "Selecione um Departamento")
    @ManyToOne
    @JoinColumn(name = "id_departamento_fk")
    private Departamento departamento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    
}