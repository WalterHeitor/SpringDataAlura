package br.com.alura.spring.data.repository;

import br.com.alura.spring.data.orm.Funcionario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepositoryCrud extends CrudRepository<Funcionario, Integer> {
}
