package br.com.alura.spring.data;

import br.com.alura.spring.data.service.*;
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
	private final RelatoriosService relatoriosService;
	private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;

	public SpringDataApplication(CrudCargoService crudCargoService, CrudFuncionarioService funcionarioService, CrudUnidadeTrabalhoService unidadeTrabalhoService, RelatoriosService relatoriosService, RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
		this.crudCargoService = crudCargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatoriosService = relatoriosService;
		this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		while (system){
			System.out.println("---------------------------------");
			System.out.println("| Qual açao você quer executar   |");
			System.out.println("| 		0 - Sair 				 |");
			System.out.println("| 		1 - Funcionário: 		 |");
			System.out.println("| 		2 - Cargo: 			  	 |");
			System.out.println("| 		3 - Unidade: 			 |");
			System.out.println("| 		4 - Relatorios:			 |");
			System.out.println("| 		5 - Relatorios dinamico: |");
			System.out.println("---------------------------------");
			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					funcionarioService.inicial(scanner);
					break;
				case 2:
					crudCargoService.inicial(scanner);

					break;
				case 3:
					unidadeTrabalhoService.inicial(scanner);
					break;
				case 4:
					relatoriosService.inicial(scanner);
					break;
				case 5:
					relatorioFuncionarioDinamico.inicial(scanner);
				default:
					System.out.println("Finalizando");
					system = false;
					break;
			}
		}
	}
}
