package sistema;

import java.util.Scanner;

import ferramentas.Saida;
import ferramentas.Validar;
import sistema.Sistema;

public class Main {

	public static Scanner scanner = new Scanner(System.in);
	public static Sistema controller = new Sistema();
	
	public static void main(String[] args) {
		String entrada = null;
		
		do {
			try {
				System.out.print(Saida.menu());
				entrada = scanner.nextLine();
				
				Validar.validarEntrada(entrada);
				
				switch(entrada) {
				case "c":
					validarCadastro();
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
					validarAlocar();
					break;
				case "r":
					System.out.print(Saida.matricula());
					String matricula = scanner.nextLine();
					System.out.println(controller.registraResposta(matricula));
					break;
				case "i":
					System.out.println(controller.listarRespostas());
					break;
				case "o":
					break;
				default:
					System.out.println(Saida.invalido());
				}
				
			}catch(Exception e) {
				System.out.println(e.getMessage() + Saida.PL);
			}
			
			
		}while(!entrada.trim().equals("o"));
		
	}

	private static void validarAlocar() {
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
				System.out.print(Saida.grupo());
				String novoGrupo = scanner.nextLine();
				System.out.println(controller.listarAlunos(novoGrupo));
				
				break;
			default:
				System.out.println(Saida.invalido());
		}
		
	}

	private static void validarCadastro() {
		System.out.print(Saida.matricula());
		String matricula = scanner.nextLine();
		System.out.print(Saida.nome());
		String nome = scanner.nextLine();
		System.out.print(Saida.curso());
		String curso = scanner.nextLine();
		
		System.out.println(controller.cadastraAluno(matricula, nome, curso) + Saida.PL);
	}	

}
