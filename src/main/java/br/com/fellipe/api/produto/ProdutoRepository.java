package br.com.fellipe.api.produto;

import br.com.fellipe.api.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAllByCategoria(Categoria categoria);

    List<Produto> findAllByIdIn(List<Long> produtosId);
}
