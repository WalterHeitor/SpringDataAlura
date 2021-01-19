package br.com.alura.spring.data;

import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeTrabalhoService;
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
	private final CrudFuncionarioService funcionarioService;
	private final CrudUnidadeTrabalhoService unidadeTrabalhoService;

	public SpringDataApplication(CrudCargoService crudCargoService, CrudFuncionarioService funcionarioService, CrudUnidadeTrabalhoService unidadeTrabalhoService) {
		this.crudCargoService = crudCargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		while (system){
			System.out.println("--------------------------------");
			System.out.println("| Qual açao você quer executar  |");
			System.out.println("| 		0 - Sair 				|");
			System.out.println("| 		1 - Funcionário: 		|");
			System.out.println("| 		1 - Cargo: 				|");
			System.out.println("| 		1 - Unidade: 			|");
			System.out.println("--------------------------------");
			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					crudCargoService.inicial(scanner);
					break;
				case 2:
					funcionarioService.inicial(scanner);
					break;
				case 3:
					unidadeTrabalhoService.inicial(scanner);
					break;
				default:
					System.out.println("Finalizando");
					system = false;
					break;
			}
		}



	}
}
