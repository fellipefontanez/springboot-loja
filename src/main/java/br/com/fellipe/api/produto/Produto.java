package br.com.fellipe.api.produto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    private BigDecimal valor;
    @Enumerated(EnumType.STRING)
    @NotNull
    private Categoria categoria;

    public Produto(AdicionarDadosProduto dados) {
        this.categoria = dados.categoria();
        this.nome = dados.nome();
        this.valor = dados.valor();
    }
}
