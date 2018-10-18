package ferramentas;

/**
 * A classe Saida tem como objetivo auxiliar as classes restantes do sistema
 * fornecendo as saídas de impressão para o usuário.
 * 
 * @author Deborah Gyovanna.
 *
 */
public class Saida {

	public final static String PL = System.lineSeparator();

	public static String menu() {
		return "(C)adastrar Aluno" + PL + "(E)xibir Aluno" + PL + "(N)ovo Grupo" + PL
				+ "(A)locar Aluno no Grupo e Imprimir Grupos" + PL + "(R)egistrar Aluno que Respondeu" + PL
				+ "(I)mprimir Alunos que Responderam" + PL + "(O)ra, vamos fechar o programa!" + PL + PL + "Opção> ";
	}

	public static String invalido() {
		return "OPÇÃO INVÁLIDA!";
	}

	public static String matricula() {
		return "Matrícula: ";
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
		return "MATRÍCULA NULA!";
	}

	public static String matriculaVazia() {
		return "mATRÍCULA VAZIA!";
	}

	public static String nomeNulo() {
		return "NOME NULO!";
	}

	public static String nomeVazio() {
		return "NOME VAZIO!";
	}

	public static String cursoNulo() {
		return "CURSO NULO!";
	}

	public static String cursoVazio() {
		return "CURSO VAZIO!";
	}

	public static String grupoNulo() {
		return "GRUPO NULO!";
	}

	public static String grupoVazio() {
		return "GEUPO VAZIO";
	}

}
