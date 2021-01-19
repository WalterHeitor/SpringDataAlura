package br.com.alura.spring.data;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepositoryCrud;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	private final CargoRepositoryCrud repositoryCrud;

	public SpringDataApplication(CargoRepositoryCrud repositoryCrud) {
		this.repositoryCrud = repositoryCrud;
	}

	@Override
	public void run(String... args) throws Exception {

		Cargo cargo = new Cargo();
		cargo.setDescricao("DESENVOLVEDOR DE SOFTWARE");
		repositoryCrud.save(cargo);

	}
}
