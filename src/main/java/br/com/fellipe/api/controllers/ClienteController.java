package br.com.fellipe.api.controllers;

import br.com.fellipe.api.cliente.AdicionarDadosCliente;
import br.com.fellipe.api.cliente.Cliente;
import br.com.fellipe.api.cliente.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    ClienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@Valid @RequestBody AdicionarDadosCliente dados){
    repository.save(new Cliente(dados));
    }

    @GetMapping
    public List<Cliente> listar(){
        return repository.findAll().stream().toList();
    }

}
