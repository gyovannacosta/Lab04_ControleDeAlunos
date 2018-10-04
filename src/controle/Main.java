package controle;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Saida saida = new Saida();
		Sistema controller = new Sistema();
		String entrada;

		do {
			System.out.print(saida.menu());
			entrada = scanner.nextLine().toLowerCase();

			switch (entrada) 
			{
				case "c":
					validarCadastro(scanner, saida, controller);
					break;
				case "e":
					break;
				case "n":
					break;
				case "a":
					break;
				case "r":
					break;
				case "i":
					break;
				case "o":
					break;
				default:
					System.out.println(saida.invalido());
			}

		} while (!entrada.equals("o"));

	}

	private static void validarCadastro(Scanner scanner, Saida saida, Sistema controller) {
		try {
			System.out.print(saida.matricula());
			String matricula = scanner.nextLine();
			System.out.print(saida.nome());
			String nome = scanner.nextLine();
			System.out.print(saida.curso());
			String curso = scanner.nextLine();
			
			System.out.println(controller.cadastraAluno(matricula, nome, curso));
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}