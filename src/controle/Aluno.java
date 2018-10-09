package controle;

public class Aluno {
	private String matricula;
	private String nome;
	private String curso;
	

	public Aluno(String matricula, String nome, String curso) {
		if(matricula == null) {
			throw new NullPointerException("IMPOSSÍVEL CADASTRAR MATRÍCULA NULA!");
		}
		if(matricula.trim().equals("")) {
			throw new IllegalArgumentException("IMPOSSÍVEL CADASTRAR MATRÍCULA VAZIA!");
		}
		if(nome == null) {
			throw new NullPointerException("IMPOSSÍVEL CADASTRAR NOME NULO!");
		}
		if(nome.trim().equals("")) {
			throw new IllegalArgumentException("IMPOSSÍVEL CADASTRAR NOME VAZIO!");
		}
		if(curso == null) {
			throw new NullPointerException("IMPOSSÍVEL CADASTRAR CURSO NULO!");
		}
		if(curso.trim().equals("")) {
			throw new IllegalArgumentException("IMPOSSÍVEL CADASTRAR CURSO VAZIO!");
		}
		
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	
	@Override
	public String toString() {
		return "Aluno " + this.matricula + " - " + this.nome + " - " + this.curso;
	}

}
