package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepositoryCrud;
import br.com.alura.spring.data.specification.SpecificationFuncionario;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
@Service
public class RelatorioFuncionarioDinamico {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final FuncionarioRepositoryCrud funcionarioRepositoryCrud;

    public RelatorioFuncionarioDinamico(FuncionarioRepositoryCrud funcionarioRepositoryCrud) {
        this.funcionarioRepositoryCrud = funcionarioRepositoryCrud;
    }

    public void inicial(Scanner scanner){
        System.out.println("Digite o nome:");
        String nome = scanner.nextLine();
        if (nome.equalsIgnoreCase("NULL")){
            nome = null;
        }
        System.out.println("Digite o cpf:");
        String cpf = scanner.nextLine();
        if (cpf.equalsIgnoreCase("NULL")){
            nome = null;
        }
        System.out.println("Digite o salario:");
        Double salario = scanner.nextDouble();
        if (cpf.equalsIgnoreCase("NULL")){
            salario = null;
        }
        System.out.println("Digite o dataContratacao:");
        String data = scanner.nextLine();
        LocalDateTime dateContratacao;
        if (data.equalsIgnoreCase("NULL")){
            dateContratacao = null;
        }else{
            dateContratacao = LocalDateTime.parse(data, formatter);
        }

        List<Funcionario> funcionarios = funcionarioRepositoryCrud
                .findAll(Specification.where(
                        SpecificationFuncionario.nome(nome))
                        .or(SpecificationFuncionario.cpf(cpf))
                        .or(SpecificationFuncionario.salario(salario))
                        .or(SpecificationFuncionario.dataContratacao(dateContratacao))
                        );
        funcionarios.forEach(System.out::println);
    }
}
