package ferramentas;

public class Validar {
	
	public static void validarEntrada(String entrada) {
		if(entrada == null) {
			throw new NullPointerException(Saida.invalido());
		}
		
		if(entrada.trim().equals("")) {
			throw new IllegalArgumentException(Saida.invalido());
		}
	}

	public static void validarMatricula(String matricula) {
		if(matricula == null) {
			throw new NullPointerException(Saida.matriculaNula());
		}
		
		if(matricula.trim().equals("")) {
			throw new IllegalArgumentException(Saida.matriculaVazia());
		}	
	}
	
	public static void ValidarNome(String nome) {
		if(nome == null) {
			throw new NullPointerException(Saida.nomeNulo());
		}
		
		if(nome.trim().equals("")) {
			throw new IllegalArgumentException(Saida.nomeVazio());
		}
	}
	
	public static void ValidarCurso(String curso) {
		if(curso == null) {
			throw new NullPointerException(Saida.cursoNulo());
		}
		
		if(curso.trim().equals("")) {
			throw new IllegalArgumentException(Saida.cursoVazio());
		}
	}
	
}
