package com.example.MiniProjetoFuncionarios.service;

import com.example.MiniProjetoFuncionarios.model.Funcionario;
import com.example.MiniProjetoFuncionarios.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;
    //criação de objeto pronto para se comunicar com o banco
    public FuncionarioService(FuncionarioRepository repository){
        this.repository = repository;
    }
    //os métodos referentes ao banco tem o tipo da Entidade que vai ser modificada ou consultada

    public List<Funcionario> listar(){
        return repository.findAll();
    }

    public Funcionario buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Funcionário não encontrado."));
    }

    public List<Funcionario> buscarPorNome(String nome){
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public Funcionario salvar(Funcionario funcionario){
        return repository.save(funcionario);
    }

    public void remover(Long id){
        repository.deleteById(id);
    }
}