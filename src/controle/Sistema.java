package controle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Sistema {
	private ArrayList<Aluno> aluno;
	private HashMap<String, Aluno> mapaMatricula;
	private HashMap<String, Grupo> grupo;
	

	public Sistema() {
		this.aluno = new ArrayList<>();
		this.mapaMatricula = new HashMap<>();
		this.grupo = new HashMap<>();
	}

	public String cadastraAluno(String matricula, String nome, String curso) {
		if (!existeAluno(matricula)) {
			Aluno novoAluno = new Aluno(matricula, nome, curso);
			this.aluno.add(novoAluno);
			this.mapaMatricula.put(matricula, novoAluno);
			return Saida.cadastrado();
		}
		return Saida.existeMatricula();
	}

	private boolean existeAluno(String matricula) {
		return this.mapaMatricula.containsKey(matricula);
	}

	public String getAluno(String matricula) {
		if(existeAluno(matricula)) {
			return this.mapaMatricula.get(matricula).toString();
		}
		return Saida.alunoIvld();
	}

	public String cadastraGrupo(String grupo) {
		if(!existeGrupo(grupo)) {
			Grupo novoGrupo = new Grupo(grupo);
			this.grupo.put(grupo, novoGrupo);
			return Saida.cadastrado();
		}
		return Saida.existeGrupo();
	}

	private boolean existeGrupo(String novoGrupo) {
		return this.grupo.containsKey(novoGrupo);
	}

	public String alocarAluno(String matricula, String novoGrupo) {
		if(existeAluno(matricula)) {
			if(existeGrupo(novoGrupo)) {
				
			}
			return Saida.grupoNCadastrado();
		}
		return Saida.alunoNCadastrado();
	}

}
