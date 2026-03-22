package com.example.MiniProjetoFuncionarios.controller;

import com.example.MiniProjetoFuncionarios.model.Funcionario;
import com.example.MiniProjetoFuncionarios.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;
    //criação de objeto para se comunicar com o Service
    public FuncionarioController(FuncionarioService service){
        this.service = service;
    }

    //puxa dados do banco e mostra na internet
    @GetMapping
    public List<Funcionario> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Funcionario buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @GetMapping("/buscar")
    public List<Funcionario> buscarPorNome(@RequestParam String nome){
        return service.buscarPorNome(nome);
    }

    //faz um novo registro no banco através da internet
    @PostMapping
    public Funcionario cadastrar(@RequestBody @Valid Funcionario funcionario){
        return service.salvar(funcionario);
    }

    //modifica um registro por meio do id
    @PutMapping("/{id}")
    public Funcionario atualizar(@PathVariable Long id, @RequestBody @Valid Funcionario funcionario){
        funcionario.setId(id);
        return service.salvar(funcionario);
    }

    //deleta o registro
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        service.remover(id);
    }
}