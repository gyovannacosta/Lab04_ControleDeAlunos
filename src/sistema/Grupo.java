package sistema;

import java.util.HashSet;

import ferramentas.Saida;
import ferramentas.Validar;

public class Grupo {
	private String nome;
	private HashSet<Aluno> alunos;

	public Grupo(String nome) {
		Validar.validarGrupo(nome);
		this.nome = nome;
		this.alunos = new HashSet<>();
	}
	
	public void adicionaAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	public String getNome() {
		return this.nome;
	}

	@Override
	public String toString() {
		String listar = "Alunos do grupo " + this.nome + ":" + Saida.PL;
		for (Aluno aluno : alunos) {
			listar += "* " + aluno.toString() + Saida.PL;
		}
		return listar.trim();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

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
