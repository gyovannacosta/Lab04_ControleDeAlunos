package ferramentas;

/**
 * A classe Validar tem como objetivo verificar se alguma entrada informada pelo
 * usuário foi inválida(Nula ou vazia) e lançar uma exceção caso isso aconteça.
 * 
 * @author Deborah Gyovanna
 *
 */
public class Validar {

	/**
	 * O método validarEntrada(), tem como objetivo verificar se uma string
	 * informada é válida e lançar uma exceção caso não seja.
	 * 
	 * @param entrada string de entrada.
	 */
	public static void validarEntrada(String entrada) {
		if (entrada == null) {
			throw new NullPointerException(Saida.invalido());
		}

		if (entrada.trim().equals("")) {
			throw new IllegalArgumentException(Saida.invalido());
		}
	}

	/**
	 * O método validarMatricula(), tem como objetivo verificar se uma matrícula
	 * informada é válida e lançar uma exceção caso não seja.
	 * 
	 * @param matricula string de matrícula.
	 */
	public static void validarMatricula(String matricula) {
		if (matricula == null) {
			throw new NullPointerException(Saida.matriculaNula());
		}

		if (matricula.trim().equals("")) {
			throw new IllegalArgumentException(Saida.matriculaVazia());
		}
	}

	/**
	 * O método validarNome(), tem como objetivo verificar se um nome informado é
	 * válido e lançar uma exceção caso não seja.
	 * 
	 * @param nome string de nome.
	 */
	public static void ValidarNome(String nome) {
		if (nome == null) {
			throw new NullPointerException(Saida.nomeNulo());
		}

		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(Saida.nomeVazio());
		}
	}

	/**
	 * O método validarCurso(), tem como objetivo verificar se um curso informado é
	 * válido e lançar uma exceção caso não seja.
	 * 
	 * @param curso string de nome de curso.
	 */
	public static void ValidarCurso(String curso) {
		if (curso == null) {
			throw new NullPointerException(Saida.cursoNulo());
		}

		if (curso.trim().equals("")) {
			throw new IllegalArgumentException(Saida.cursoVazio());
		}
	}

	/**
	 * O método validarGrupo(), tem como objetivo verificar se um grupo informado é
	 * válido e lançar uma exceção caso não seja.
	 * 
	 * @param grupo string de nome de grupo.
	 */
	public static void validarGrupo(String nome) {
		if (nome == null) {
			throw new NullPointerException(Saida.grupoNulo());
		}

		if (nome.trim().equals("")) {
			throw new IllegalArgumentException(Saida.grupoVazio());
		}

	}

}
