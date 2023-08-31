package br.com.fellipe.api.controllers;

import br.com.fellipe.api.produto.AdicionarDadosProduto;
import br.com.fellipe.api.produto.Categoria;
import br.com.fellipe.api.produto.Produto;
import br.com.fellipe.api.produto.services.ProdutoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@Valid @RequestBody AdicionarDadosProduto dados){
        return produtoService.cadastrar(dados);
    }

    @GetMapping
    public List<Produto> listar(){
       return produtoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> listarPorId(@PathVariable Long id){
        return produtoService.listarPorId(id);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Produto> listarPorCategoria(@PathVariable Categoria categoria){
        return produtoService.listarPorCategoria(categoria);
    }

}
