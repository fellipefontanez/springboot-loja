package br.com.fellipe.api.controllers;

import br.com.fellipe.api.cliente.Cliente;
import br.com.fellipe.api.cliente.ClienteRepository;
import br.com.fellipe.api.pedido.CadastrarPedidoDTO;
import br.com.fellipe.api.pedido.Pedido;
import br.com.fellipe.api.pedido.PedidoRepository;
import br.com.fellipe.api.produto.Produto;
import br.com.fellipe.api.produto.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    PedidoRepository repository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping
    public List<Pedido> listarTodos(){
        return repository.findAll();
    }

    @PostMapping
    @Transactional
    public void adicionarPedido(@RequestBody CadastrarPedidoDTO dados){
        Cliente cliente = clienteRepository.getReferenceById(dados.clienteId());
        List<Produto> produtos = produtoRepository.findAllByIdIn(dados.produtosId());
        repository.save(new Pedido(null, produtos, cliente));
    }

    @GetMapping("/listar-por-cliente/{id}")
    public ResponseEntity<List<Pedido>> listarPorCliente(@PathVariable Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            return ResponseEntity.ok(repository.findAllByCliente(cliente));
        }
        return ResponseEntity.notFound().build();
    }

}
