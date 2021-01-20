package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepositoryCrud;
import br.com.alura.spring.data.specification.SpecificationFuncionario;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Scanner;

public class RelatorioFuncionarioDinamico {
    private final FuncionarioRepositoryCrud funcionarioRepositoryCrud;

    public RelatorioFuncionarioDinamico(FuncionarioRepositoryCrud funcionarioRepositoryCrud) {
        this.funcionarioRepositoryCrud = funcionarioRepositoryCrud;
    }

    public void inicial(Scanner scanner){
        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();

        List<Funcionario> funcionarios = funcionarioRepositoryCrud
                .findAll(Specification.where(SpecificationFuncionario.nome(nome)));

    }
}
