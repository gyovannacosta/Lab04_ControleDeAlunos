package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import ferramentas.Saida;
import ferramentas.Validar;

public class Sistema {
	private ArrayList<Aluno> aluno;
	private HashMap<String, Aluno> mapaMatricula;
	private HashMap<String, Grupo> grupo;
	private ArrayList<String> respondeu;
	

	public Sistema() {
		this.aluno = new ArrayList<>();
		this.mapaMatricula = new HashMap<>();
		this.grupo = new HashMap<>();
		this.respondeu = new ArrayList<>();
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

	public String getAluno(String matricula) {
		if(existeAluno(matricula)) {
			return "Aluno: " + this.mapaMatricula.get(matricula).toString();
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

	public String alocarAluno(String matricula, String novoGrupo) {
		Validar.validarEntrada(matricula);
		Validar.validarEntrada(novoGrupo);
		if(existeAluno(matricula)) {
			if(existeGrupo(novoGrupo)) {
				this.grupo.get(novoGrupo.toUpperCase()).adicionaAluno(this.mapaMatricula.get(matricula));
				return Saida.alocado();
			}
			return Saida.grupoNCadastrado();
		}
		return Saida.alunoNCadastrado();
	}

	public String listarAlunos(String novoGrupo) {
		if(existeGrupo(novoGrupo)) {
			return this.grupo.get(novoGrupo.toUpperCase()).toString();
		}
		return Saida.grupoNCadastrado();
	}
	
	public String registraResposta(String matricula) {
		Validar.validarMatricula(matricula);
		if(existeAluno(matricula)) {
			this.respondeu.add(matricula);
			return Saida.alunoRegistrado();
		}
		return Saida.alunoNCadastrado();
	}

	public String listarRespostas() {
		String listar = "Alunos:" + Saida.PL;
		for (String resposta : respondeu) {
			listar += this.mapaMatricula.get(resposta).toString() + Saida.PL;
		}
		return listar.trim();
	}
	
	private boolean existeAluno(String matricula) {
		return this.mapaMatricula.containsKey(matricula);
	}
	
	private boolean existeGrupo(String novoGrupo) {
		return this.grupo.containsKey(novoGrupo.toUpperCase());
	}

}
