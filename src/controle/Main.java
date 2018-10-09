package controle;

import java.util.Scanner;

public class Main {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		Sistema controller = new Sistema();
		String entrada;

		do {
			System.out.print(Saida.menu());
			entrada = scanner.nextLine().toLowerCase().trim();

			switch (entrada) 
			{
				case "c":
					validarCadastro(scanner, controller);
					break;
				case "e":
					System.out.print(Saida.matricula());
					entrada = scanner.nextLine();
					System.out.println(controller.getAluno(entrada) + System.lineSeparator());
					break;
				case "n":
					System.out.print(Saida.grupo());
					entrada = scanner.nextLine().toUpperCase();
					System.out.println(controller.cadastraGrupo(entrada) + System.lineSeparator());
					break;
				case "a":
					validarAlocar(scanner, controller);
					break;
				case "r":
					break;
				case "i":
					break;
				case "o":
					break;
				default:
					System.out.println(Saida.invalido());
			}

		} while (!entrada.equals("o"));

	}

	private static void validarAlocar(Scanner scanner, Sistema controller) {
		System.out.print(Saida.opcaoGrupo());
		String entrada = scanner.nextLine().trim().toLowerCase();
		switch(entrada)
		{
			case "a":
				System.out.print(Saida.matricula());
				String matricula = scanner.nextLine();
				System.out.print(Saida.grupo());
				String grupo = scanner.nextLine();
				System.out.println(controller.alocarAluno(matricula, grupo));
				break;
			case "i":
				break;
			default:
				System.out.println(Saida.invalido());
		}
		
	}

	private static void validarCadastro(Scanner scanner, Sistema controller) {
		try {
			System.out.print(Saida.matricula());
			String matricula = scanner.nextLine();
			System.out.print(Saida.nome());
			String nome = scanner.nextLine();
			System.out.print(Saida.curso());
			String curso = scanner.nextLine();
			
			System.out.println(controller.cadastraAluno(matricula, nome, curso) + System.lineSeparator());
			
		}catch(Exception e) {
			System.out.println(e.getMessage() + System.lineSeparator());
		}
	}

}
