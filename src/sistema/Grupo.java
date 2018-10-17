package sistema;

import java.util.HashSet;

import ferramentas.Saida;
import ferramentas.Validar;

/**
 * Grupo é a classe responsável por armazenar nome do grupo e alunos
 * pertencentes a esse grupo.
 * 
 * @author Deborah Gyovanna
 *
 */
public class Grupo {
	private String nome;
	private HashSet<Aluno> alunos;

	/**
	 * Cosntrutor de Grupo tem como objetivo construir o objeto grupo durante a
	 * execução do código, recebendo como parâmetro o nome do grupo e inicializando
	 * sua variável caso o parâmetro fornecido seja válido(Não seja nulo ou vazio),
	 * caso contrário o construtor lança uma exceção impedindo a continuação da
	 * execução do programa.
	 * 
	 * @param nome string com o nome do grupo
	 */
	public Grupo(String nome) {
		Validar.validarGrupo(nome);
		this.nome = nome;
		this.alunos = new HashSet<>();
	}

	/**
	 * O método adicionaAluno(), tem como objetivo adicionar alunos previamente
	 * cadastrados no sistema ao grupo.
	 * 
	 * @param Objeto aluno
	 */
	public void adicionaAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}

	/**
	 * O método getNome(), tem como objetivo retornar a string do nome do grupo.
	 * 
	 * @return nome do grupo
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * O método toString(), tem como objetivo retornar a representação textual de
	 * grupo, contendo todos os alunos adicionados ao grupo.
	 */
	@Override
	public String toString() {
		String listar = "Alunos do grupo " + this.nome + ":" + Saida.PL;
		for (Aluno aluno : alunos) {
			listar += "* " + aluno.toString() + Saida.PL;
		}
		return listar.trim();
	}

	/**
	 * O método hashCode(), tem como objetivo retornar um código hash do objeto.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Grupo other = (Grupo) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
