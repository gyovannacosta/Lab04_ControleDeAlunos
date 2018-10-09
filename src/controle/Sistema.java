package controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Sistema {
	private ArrayList<Aluno> aluno;
	private HashMap<String, Aluno> mapaMatricula;
	private HashSet<Grupo> grupo;

	public Sistema() {
		this.aluno = new ArrayList<>();
		this.mapaMatricula = new HashMap<>();
		this.grupo = new HashSet<>();
	}

	public String cadastraAluno(String matricula, String nome, String curso) {
		if (!existeAluno(matricula)) {
			Aluno novoAluno = new Aluno(matricula, nome, curso);
			this.aluno.add(novoAluno);
			this.mapaMatricula.put(matricula, novoAluno);
		}
		return "MATRÍCULA JÁ CADASTRADA!";
	}

	private boolean existeAluno(String matricula) {
		return this.mapaMatricula.containsKey(matricula);
	}

	public String getAluno(String matricula) {
		if(existeAluno(matricula)) {
			return this.mapaMatricula.get(matricula).toString();
		}
		return "ALUNO NÃO CADASTRADO.";
	}

	public String cadastraGrupo(String grupo) {
		if(!existeGrupo(grupo)) {
			Grupo novoGrupo = new Grupo(grupo);
			this.grupo.add(novoGrupo);
			return "CADASTRO REALIZADO!";
		}
		return "GRUPO JÁ CADASTRADO!";
	}

	private boolean existeGrupo(String novoGrupo) {
		return this.grupo.contains(novoGrupo);
	}

}
