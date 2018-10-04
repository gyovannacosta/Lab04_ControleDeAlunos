package controle;

public class Saida {

	public Saida() {

	}

	public String menu() {
		return "(C)adastrar Aluno" + System.lineSeparator() + "(E)xibir Aluno" + System.lineSeparator() + "(N)ovo Grupo"
				+ System.lineSeparator() + "(A)locar Aluno no Grupo e Imprimir Grupos"
				+ "(R)egistrar Aluno que Respondeu" + System.lineSeparator() + "(I)mprimir Alunos que Responderam"
				+ "(O)ra, vamos fechar o programa!" + System.lineSeparator() + System.lineSeparator() + "Opção> ";
	}

	public String invalido() {
		return "Opção inválida!" + System.lineSeparator();
	}
	
	public String matricula() {
		return "Matŕicula: ";
	}

	public String nome() {
		return "Nome: ";
	}

	public String curso() {
		return "Curso: ";
	}

}
