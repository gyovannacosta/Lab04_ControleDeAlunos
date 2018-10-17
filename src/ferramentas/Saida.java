package ferramentas;

public class Saida {
	
	public final static String PL = System.lineSeparator();

	public static String menu() {
		return "(C)adastrar Aluno" + PL + "(E)xibir Aluno" + PL + "(N)ovo Grupo" + PL
				+ "(A)locar Aluno no Grupo e Imprimir Grupos" + PL + "(R)egistrar Aluno que Respondeu" + PL
				+ "(I)mprimir Alunos que Responderam" + PL + "(O)ra, vamos fechar o programa!" + PL + PL + "Opção> ";
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
		return "ALUNO NÃO CADASTRADO!";
	}

	public static String grupoNCadastrado() {
		return "GRUPO NÃO CADASTRADO!";
	}
	
	public static String alocado() {
		return "ALUNO ALOCADO!";
	}
	
	public static String alunoRegistrado() {
		return "ALUNO REGISTRADO!";
	}
	
	public static String matriculaNula() {
		return "Impossível cadastrar Matricula Nula";
	}
	
	public static String matriculaVazia() {
		return "Matricula Vazia";
	}
	
	public static String nomeNulo() {
		return "Nome Nulo";
	}
	
	public static String nomeVazio() {
		return "Nome Vazio";
	}

	public static String cursoNulo() {
		return "Curso Nulo";
	}

	public static String cursoVazio() {
		return "Curso Vazio";
	}
	
	public static String grupoNulo() {
		return "Grupo Nulo";
	}
	
	public static String grupoVazio() {
		return "Grupo Vazio";
	}

}
