package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepositoryCrud;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private Boolean system = true;

    private FuncionarioRepositoryCrud funcionarioRepositoryCrud;

    

    public RelatoriosService(FuncionarioRepositoryCrud funcionarioRepositoryCrud) {
        this.funcionarioRepositoryCrud = funcionarioRepositoryCrud;
    }


    public void inicial(Scanner scanner){
        while (system){
            System.out.println("--------------------------------------");
            System.out.println("| Qual ação deseja executar?          |");
            System.out.println("|   0 - Sair                          |");
            System.out.println("|   1 - Busca funcionario por nome    |");
            System.out.println("--------------------------------------");
            int action = scanner.nextInt();
            switch (action){
                case 1:
                    buscaFuncionarioPorNnome(scanner);
                    break;

                case 0:
                default:
                    system = false;
                    break;

            }
        }
    }
    private void buscaFuncionarioPorNnome(Scanner scanner){
        System.out.println("Qual nome de funcionario deseja pesquisar?");
        String nomeFuncionario = scanner.nextLine();
        List<Funcionario> list = funcionarioRepositoryCrud.findByNome(nomeFuncionario);
        list.forEach(System.out::println);
    }

    private void buscarFuncionarioNomeSalarioMaiorData(Scanner scanner){
        System.out.println("Qual nome que deseja pesquisar?");
        String nomeFuncionario = scanner.nextLine();
        System.out.println("Qual data deseja pesquisar?");
        String dataFuncionario = scanner.nextLine();
        System.out.println("Qual salario deseja perquisar");
        Double salario = scanner.nextDouble();
        funcionarioRepositoryCrud.findNomeSalarioMaiorDataContratacao(nomeFuncionario, salario, dataFuncionario);
    }
}
