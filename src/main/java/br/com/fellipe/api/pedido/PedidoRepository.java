package br.com.fellipe.api.pedido;

import br.com.fellipe.api.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findAllByCliente(Optional<Cliente> cliente);
}
