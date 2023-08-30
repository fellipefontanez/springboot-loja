package br.com.fellipe.api.cliente;

import br.com.fellipe.api.endereco.Endereco;
import jakarta.validation.constraints.NotBlank;

public record AdicionarDadosCliente(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        String telefone,
        Boolean aceitaPromocoes,
        Endereco endereco
) {
}
