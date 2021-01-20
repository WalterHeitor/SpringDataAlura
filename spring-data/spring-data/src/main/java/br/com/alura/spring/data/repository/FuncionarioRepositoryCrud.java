package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FuncionarioRepositoryCrud extends PagingAndSortingRepository<Funcionario, Integer> {

    List<Funcionario> findByNome(String nome);

    List<Funcionario> findByNomeAndSalarioGreaterThanAndDataContratacao(String nome, Double salario, LocalDateTime data);

    @Query(" SELECT f FROM Funcionario f WHERE f.nome = :nome AND " +
            "f.salario >= :salario AND f.dataContratacao = :date ")
    List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDateTime date);

    @Query(value = " SELECT *FROM funcionario f WHERE f.data_contratacao >= :data ",
        nativeQuery = true)
    List<Funcionario> findDdataContracaoMaior(LocalDateTime data);

    @Query(value = " SELECT f.id, f.nome, f.salario FROM funcionario f ",
            nativeQuery = true)
    List<FuncionarioProjecao> findFuncionarioSalario();

}
