package com.example.MiniProjetoFuncionarios.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "TBFUNCIONARIOS")
public class Funcionario {

    //criação de primary key autoincrement do banco de dados
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo obrigatório.")
    private String nome;

    //anotação para verificar o formato do email e evitar que seja nulo
    @Email(message = "E-mail inválido.")
    @NotBlank(message = "Campo obrigatório.")
    @Column(unique = true, nullable = false, length = 100) //para que o email seja único por registro de funcionário
    private String email;

    @NotBlank(message = "Campo obrigatório.")
    private String cargo;

    @NotNull(message = "Campo obrigatório.")
    @Positive(message = "Valor inválido.")  //validação para que o salário seja maior que zero
    private Double salario;

    public Funcionario(){}
}
