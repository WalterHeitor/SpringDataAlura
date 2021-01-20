package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;
import br.com.alura.spring.data.repository.FuncionarioRepositoryCrud;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private Boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private FuncionarioRepositoryCrud funcionarioRepositoryCrud;



    public RelatoriosService(FuncionarioRepositoryCrud funcionarioRepositoryCrud) {
        this.funcionarioRepositoryCrud = funcionarioRepositoryCrud;
    }


    public void inicial(Scanner scanner){
        while (system){
            System.out.println("-------------------------------------------------------------");
            System.out.println("| Qual ação deseja executar?                                 |");
            System.out.println("| 0 - Sair                                                   |");
            System.out.println("| 1 - Busca funcionario por nome                             |");
            System.out.println("| 2 - Busca funcionario por Salario maior e data contratação |");
            System.out.println("| 3 - Busca funcionario por data Contratação                 |");
            System.out.println("-------------------------------------------------------------");
            int action = scanner.nextInt();
            switch (action){
                case 1:
                    buscaFuncionarioPorNnome(scanner);
                    break;
                case 2:
                    buscarFuncionarioNomeSalarioMaiorData(scanner);
                    break;
                case 3:
                    buscarFuncionarioDataContratacao(scanner);
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
        LocalDateTime localDateTime = LocalDateTime.parse(dataFuncionario, formatter);
        System.out.println("Qual salario deseja perquisar");
        Double salario = scanner.nextDouble();
        List<Funcionario>list = funcionarioRepositoryCrud.findNomeSalarioMaiorDataContratacao(nomeFuncionario, salario, localDateTime);
        list.forEach(System.out::println);
    }

    private void buscarFuncionarioDataContratacao(Scanner scanner){
        System.out.println("Qual data deseja pesquisar?");
        String dataFuncionario = scanner.nextLine();
        LocalDateTime localDateTime = LocalDateTime.parse(dataFuncionario, formatter);
        List<Funcionario>list = funcionarioRepositoryCrud.findDdataContracaoMaior(localDateTime);
        list.forEach(System.out::println);
    }

    private void pesquisarFuncionarioSalario(){
        List<FuncionarioProjecao> list = funcionarioRepositoryCrud.findFuncionarioSalario();
        list.forEach(f -> System.out.println("Funcionario id "+f.getId()
                +"| Funcionario nome "+f.getNome()
                +"| Funcionario salario "+f.getSalario()));
    }
}
