package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import ferramentas.Saida;
import ferramentas.Validar;

/**
 * Sistema é a classe responsável por controlar e determinar os métodos de
 * acordo com o que é pedido e parâmetros fornecido pelo main/usuário.
 * 
 * @author Deborah Gyovanna
 *
 */
public class Sistema {
	private ArrayList<Aluno> aluno;
	private HashMap<String, Aluno> mapaMatricula;
	private HashMap<String, Grupo> grupo;
	private ArrayList<String> respondeu;

	/**
	 * Construtor de sistema tem como objetivo construir o sistema e inicializar os
	 * objetos Aluno e Grupo, além de inicializar um mapa de alunos e uma lista de
	 * respostas.
	 */
	public Sistema() {
		this.aluno = new ArrayList<>();
		this.mapaMatricula = new HashMap<>();
		this.grupo = new HashMap<>();
		this.respondeu = new ArrayList<>();
	}

	/**
	 * O método cadastraAluno(), tem como objetivo receber matricula, nome e curso
	 * de um determinado usuario que deseja ser cadastrado como aluno.
	 * 
	 * @param matricula string da matricula do aluno
	 * @param nome      stringo do nome do aluno
	 * @param curso     string do curso do aluno
	 * @return Caso o aluno já não esteja cadastrado, ele cadastra o aluno e retorna
	 *         que o mesmo foi cadastrado, caso contrário ele retorna informando que
	 *         a matricula do aluno já existe no sistema.
	 */
	public String cadastraAluno(String matricula, String nome, String curso) {
		if (!existeAluno(matricula)) {
			Aluno novoAluno = new Aluno(matricula, nome, curso);
			this.aluno.add(novoAluno);
			this.mapaMatricula.put(matricula, novoAluno);
			return Saida.cadastrado();
		}
		return Saida.existeMatricula();
	}

	/**
	 * O método getAluno(), tem como objetivo receber a matricula de um aluno
	 * previamente cadastrado no sistema, e retornar o toString desse aluno, caso a
	 * matricula informada seja inválida(Nula ou vazia) é lançada uma exceção.
	 * 
	 * @param matricula string da matrícula do aluno.
	 * @return Retorna o toString do aluno caso ele já esteja matriculado no
	 *         sistema, caso contrário informa que a matrícula informada não se
	 *         encontra cadastrada no sistema.
	 */
	public String getAluno(String matricula) {
		Validar.validarMatricula(matricula);
		if (existeAluno(matricula)) {
			return "Aluno: " + this.mapaMatricula.get(matricula).toString();
		}
		return Saida.alunoIvld();
	}

	/**
	 * O método cadastraGrupo(), tem como objetivo receber uma string com o nome de
	 * um grupo e cadastrar o grupo no sistema.
	 * 
	 * @param grupo string do nome do grupo.
	 * @return Retorna que o grupo já foi cadastrado caso o grupo já tenha sido
	 *         cadastrado no sistema anteriormente, caso contrário retorna que o
	 *         grupo foi cadastrado com sucesso.
	 */
	public String cadastraGrupo(String grupo) {
		grupo = grupo.toUpperCase();
		if (!existeGrupo(grupo)) {
			Grupo novoGrupo = new Grupo(grupo);
			this.grupo.put(grupo, novoGrupo);
			return Saida.cadastrado();
		}
		return Saida.existeGrupo();
	}

	/**
	 * O método alocarAluno(), tem como objetivo vincular um aluno já cadastrado no
	 * sistema à um grupo. Ele recebe como parâmetro uma string de matrícula e outra
	 * string de nome do grupo e verifica se os mesmo são inválidos(Nulo ou vazio),
	 * caso algum dos parâmetros não seja válido é lançado uma exceção e a execução
	 * do programa é interropida imediatamente, caso seja válido o método verifica
	 * se o aluno e o grupo já estão cadastrados no sistema, se sim é feito o
	 * vinculamento.
	 * 
	 * @param matricula string de matrícula do aluno.
	 * @param novoGrupo string de nome do grupo.
	 * @return Retorna Aluno alocado caso aluno e grupo existam, ou retorna aluno
	 *         inexistente ou grupo inexistente dependendo de qual deles não estejam
	 *         cadastrados dentro do sistema.
	 */
	public String alocarAluno(String matricula, String novoGrupo) {
		Validar.validarMatricula(matricula);
		Validar.validarGrupo(novoGrupo);
		if (existeAluno(matricula)) {
			if (existeGrupo(novoGrupo)) {
				this.grupo.get(novoGrupo.toUpperCase()).adicionaAluno(this.mapaMatricula.get(matricula));
				return Saida.alocado();
			}
			return Saida.grupoNCadastrado();
		}
		return Saida.alunoNCadastrado();
	}

	/**
	 * O método listarAlunos(), tem como objetivo receber a string do nome de um
	 * grupo e listar os alunos vinculados à ele. Além de verificar se o parâmetro
	 * informado é inválido(Nulo ou vazio), caso não seja válido é lançado uma
	 * exceção e a execução do programa é interropida imediatamente.
	 * 
	 * @param novoGrupo string de nome do grupo.
	 * @return retorna a lista dos alunos cadastrados em grupo se o grupo foi
	 *         previamente cadastrado, caso contrário retorna informando que o grupo
	 *         não existe no sistema.
	 */
	public String listarAlunos(String novoGrupo) {
		Validar.validarGrupo(novoGrupo);
		if (existeGrupo(novoGrupo)) {
			return this.grupo.get(novoGrupo.toUpperCase()).toString();
		}
		return Saida.grupoNCadastrado();
	}

	/**
	 * O método registraResposta(), tem como objetivo receber como parâmetro uma
	 * string de matrícula de um aluno já cadastrado no sistema e alocar esse aluno
	 * em uma lista de alunos que responderam.
	 * 
	 * @param matricula string de matrícula de aluno.
	 * @return retorna que a resposta foi registrada caso aluno exista no sistema,
	 *         caso contrário informa que aluno não foi cadastrado.
	 */
	public String registraResposta(String matricula) {
		Validar.validarMatricula(matricula);
		if (existeAluno(matricula)) {
			this.respondeu.add(matricula);
			return Saida.alunoRegistrado();
		}
		return Saida.alunoNCadastrado();
	}

	/**
	 * O método listarRespostas(), tem como objetivo listar todos os alunos que
	 * estão adicionados na lista de respostas.
	 * 
	 * @return lista de alunos que responderam.
	 */
	public String listarRespostas() {
		String listar = "Alunos:" + Saida.PL;
		for (String resposta : respondeu) {
			listar += this.mapaMatricula.get(resposta).toString() + Saida.PL;
		}
		return listar.trim();
	}

	/**
	 * O método privado existeAluno(), tem como objetivo verificar se a matrícula do
	 * aluno já existe/foi cadastrada no sistema.
	 * 
	 * @param matricula string de matricula do aluno
	 * @return retorna True caso aluno exista no sistema, e False caso contrário.
	 */
	private boolean existeAluno(String matricula) {
		return this.mapaMatricula.containsKey(matricula);
	}

	/**
	 * O método privado existeGrupo(), tem como objetivo verificar se o grupo já
	 * existe/foi cadastrado no sistema.
	 * 
	 * @param matricula string de nome do grupo.
	 * @return retorna True caso o grupo exista no sistema, e False caso contrário.
	 */
	private boolean existeGrupo(String novoGrupo) {
		return this.grupo.containsKey(novoGrupo.toUpperCase());
	}

}
