package br.com.fellipe.api.produto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record AdicionarDadosProduto(
        @NotBlank
        String nome,
        BigDecimal valor,
        Categoria categoria
) {
}
