package br.com.alura.spring.data.service;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepositoryCrud;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {

    private final CargoRepositoryCrud repositoryCrud;

    private Boolean system = true;

    public CrudCargoService(CargoRepositoryCrud repositoryCrud) {
        this.repositoryCrud = repositoryCrud;
    }

    public void inicial(Scanner scanner){
        while (system){
            System.out.println("------------------------------------");
            System.out.println("Qual ação de cargo deseja executar?");
            System.out.println(" 0 - Sair ");
            System.out.println(" 1 - Salvar ");
            System.out.println(" 2 - Atualizar ");
            System.out.println(" 3 - Visualizar ");
            System.out.println(" 4 - Deletar ");
            System.out.println("------------------------------------");
            int action = scanner.nextInt();
            switch (action){
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                case 3:
                    visualizar();
                    break;
                case 4:
                    deletar(scanner);
                    break;
                case 0:
                default:
                    system = false;
                break;

            }
        }
        salvar(scanner);
    }



    private void salvar(Scanner scanner){
        System.out.println("Descricao do Cargo:");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);
        repositoryCrud.save(cargo);
        System.out.println("Salvo com Sucesso!");
    }
    private void atualizar(Scanner scanner){
        System.out.println("Informe Id:");
        int id = scanner.nextInt();
        System.out.println("Descrição dp Cargo");
        String descricao = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setDescricao(descricao);
        repositoryCrud.save(cargo);
        System.out.println("Atualizado com Sucesso!");
    }
    private void visualizar(){
        Iterable<Cargo> cargos = repositoryCrud.findAll();
        cargos.forEach(cargo -> System.out.println(cargo));
    }
    private void deletar(Scanner scanner){
        System.out.println("Informe Id:");
        int id = scanner.nextInt();
        repositoryCrud.deleteById(id);
        System.out.println("Deletado com Sucesso!");
    }
}
