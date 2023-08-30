package br.com.fellipe.api.cliente;

import br.com.fellipe.api.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    private String telefone;
    private Boolean aceitaPromocoes;
    @Embedded
    private Endereco endereco;

    public Cliente(AdicionarDadosCliente dados){
        this.aceitaPromocoes = dados.aceitaPromocoes();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.endereco = dados.endereco();
        this.nome = dados.nome();
    }

}
