package controle;

import java.util.ArrayList;
import java.util.HashMap;

public class Sistema {
	private ArrayList<Aluno> aluno;
	private HashMap<String, Aluno> mapaMatricula;

	public Sistema() {
		this.aluno = new ArrayList<>();
		this.mapaMatricula = new HashMap<>();
	}

	public String cadastraAluno(String matricula, String nome, String curso) {
		if (!existeAluno(matricula)) {
			Aluno novoAluno = new Aluno(matricula, nome, curso);
			this.aluno.add(novoAluno);
			this.mapaMatricula.put(matricula, novoAluno);
			return "CADASTRO REALIZADO!";
		}
		return "MATRÍCULA JÁ CADASTRADA!";
	}

	private boolean existeAluno(String matricula) {
		return this.mapaMatricula.containsKey(matricula);
	}

}
