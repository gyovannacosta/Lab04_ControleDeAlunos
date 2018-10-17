package sistema;

import ferramentas.Validar;

/**
 * Aluno é uma classe responsável por armazenar nome, matrícula e curso de um
 * determinado aluno.
 * 
 * @author Deborah Gyovanna.
 *
 */
public class Aluno {
	private String matricula;
	private String nome;
	private String curso;

	/**
	 * Construtor de Aluno tem como objetivo construir o objeto aluno durante a
	 * execução do código, recebendo como parâmetro matricula, nome e curso de um
	 * determinado usuário e inicializando suas respectivas variáveis caso os
	 * parâmetros fornecidos sejam válidos(Não sejam nulos ou vazios), caso
	 * contrário o construtor lança uma exceção impedindo a continuação da execução
	 * do programa.
	 * 
	 * @param matricula string com a matricula do aluno
	 * @param nome      string com o nome do aluno
	 * @param curso     string com o curso do aluno
	 */
	public Aluno(String matricula, String nome, String curso) {

		Validar.validarMatricula(matricula);
		Validar.ValidarNome(nome);
		Validar.ValidarCurso(curso);

		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	/**
	 * O método getMatricula(), tem como objetivo retornar a string de matrícula do
	 * aluno.
	 * 
	 * @return matricula do aluno.
	 */
	public String getMatricula() {
		return this.matricula;
	}

	/**
	 * O método getNome(), tem como objetivo retornar a string do nome do aluno.
	 * 
	 * @return nome do aluno.
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * O método getCurso(), tem como objetivo retornar a string do curso do aluno.
	 * 
	 * @return curso do aluno.
	 */
	public String getCurso() {
		return this.curso;
	}

	/**
	 * O método toString(), tem como objetivo retornar a representação textual de
	 * aluno.
	 */
	@Override
	public String toString() {
		return getMatricula() + " - " + getNome() + " - " + getCurso();
	}

	/**
	 * O método hashCode(), tem como objetivo retornar um código hash do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * O método equals(), tem como objetivo comparar se um objeto é igual a outro.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

}
