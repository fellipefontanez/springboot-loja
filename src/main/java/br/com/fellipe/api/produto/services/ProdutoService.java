package br.com.fellipe.api.produto.services;

import br.com.fellipe.api.produto.AdicionarDadosProduto;
import br.com.fellipe.api.produto.Categoria;
import br.com.fellipe.api.produto.Produto;
import br.com.fellipe.api.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    public ResponseEntity<String> cadastrar(AdicionarDadosProduto dados){
        repository.save(new Produto(dados));
        return ResponseEntity.ok("Produto adicionado com sucesso");
    }

    public List<Produto> listarTodos(){
        return repository.findAll().stream().toList();
    }

    public ResponseEntity<Optional<Produto>> listarPorId(Long id) {
        Optional<Produto> produto = repository.findById(id);
        if(produto.isPresent()){
            return ResponseEntity.ok(produto);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    public List<Produto> listarPorCategoria(Categoria categoria) {
        return repository.findAllByCategoria(categoria);
    }
}
