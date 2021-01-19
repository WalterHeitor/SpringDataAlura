package br.com.alura.spring.data;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.repository.CargoRepositoryCrud;
import br.com.alura.spring.data.service.CrudCargoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	private Boolean system = true;

	private final CrudCargoService crudCargoService;

	public SpringDataApplication(CrudCargoService crudCargoService) {
		this.crudCargoService = crudCargoService;
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		while (system){
			System.out.println("--------------------------------");
			System.out.println("| Qual açao você quer executar  |");
			System.out.println("| 		0 - Sair 				|");
			System.out.println("| 		1 - Cargo: 				|");
			System.out.println("--------------------------------");
			int action = scanner.nextInt();
			if(action == 1) {
				crudCargoService.inicial(scanner);
			}else {
				system = false;
			}
		}



	}
}
