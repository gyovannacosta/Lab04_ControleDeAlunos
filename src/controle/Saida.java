package controle;

public class Saida {

	public static String menu() {
		return "(C)adastrar Aluno" + System.lineSeparator() + "(E)xibir Aluno" + System.lineSeparator() + "(N)ovo Grupo"
				+ System.lineSeparator() + "(A)locar Aluno no Grupo e Imprimir Grupos" + System.lineSeparator()
				+ "(R)egistrar Aluno que Respondeu" + System.lineSeparator() + "(I)mprimir Alunos que Responderam"
				+ System.lineSeparator() + "(O)ra, vamos fechar o programa!" + System.lineSeparator()
				+ System.lineSeparator() + "Opção> ";
	}

	public static String invalido() {
		return "Opção inválida!";
	}

	public static String matricula() {
		return "Matŕicula: ";
	}

	public static String nome() {
		return "Nome: ";
	}

	public static String curso() {
		return "Curso: ";
	}

	public static String grupo() {
		return "Grupo: ";
	}

	public static String cadastrado() {
		return "CADASTRO REALIZADO!";
	}

	public static String existeMatricula() {
		return "MATRÍCULA JÁ CADASTRADA!";
	}

	public static String alunoIvld() {
		return "ALUNO NÃO CADASTRADO.";
	}

	public static String existeGrupo() {
		return "GRUPO JÁ CADASTRADO!";
	}

	public static String opcaoGrupo() {
		return "(A)locar Aluno ou (I)mprimir Grupo? ";
	}
	
	public static String alunoNCadastrado() {
		return "Aluno não cadastrado.";
	}
	
	public static String grupoNCadastrado() {
		return "Grupo não cadastrado.";
	}

}
