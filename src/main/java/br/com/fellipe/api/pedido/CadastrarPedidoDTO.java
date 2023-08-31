package br.com.fellipe.api.pedido;

import br.com.fellipe.api.cliente.Cliente;
import br.com.fellipe.api.produto.Produto;

import java.util.List;

public record CadastrarPedidoDTO(Long clienteId, List<Long> produtosId) {
}
