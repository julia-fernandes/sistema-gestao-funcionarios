package com.example.MiniProjetoFuncionarios.repository;

import com.example.MiniProjetoFuncionarios.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//interface para para manipular e consultar o banco utilizando métodos padrão do JpaRepository
public interface FuncionarioRepository extends JpaRepository<Funcionario , Long> {

    List<Funcionario> findByNomeContainingIgnoreCase(String nome);
    //metodo para fazer uma busca no banco especificamente pelo nome
}
