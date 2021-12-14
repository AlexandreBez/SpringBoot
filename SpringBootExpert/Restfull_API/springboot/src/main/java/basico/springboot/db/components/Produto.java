package basico.springboot.db.components;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
// import lombok.EqualsAndHashCode;
// import lombok.Getter;
import lombok.NoArgsConstructor;
// import lombok.Setter;
// import lombok.ToString;

@Entity
@Table(name = "produto")
// @Getter
// @Setter
// @ToString
// @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "descricao")
    @NotEmpty(message = "Descrição é obrigatorio")
    private String descricao;

    @Column(name = "preco_unitario")
    @NotNull(message = "Preço e obrigatorio")
    private BigDecimal preco;

}