import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import sistema.Aluno;

class AlunoTest {
	private Aluno aluno;

	@Test
	void testAlunoMatriculaNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			aluno = new Aluno(null, "Pessoa", "Curso");
		});
	}
	
	@Test
	void testAlunoMatriculaVazia() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aluno = new Aluno("                  ", "Pessoa", "Curso");
		});
	}
	
	@Test
	void testAlunoNomeNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			aluno = new Aluno("Matricula", null , "Curso");
		});
	}
	
	@Test
	void testAlunoNomeVazio() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aluno = new Aluno("Matricula", "", "Curso");
		});
	}
	
	@Test
	void testAlunoCursoNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			aluno = new Aluno("Matricula", "Pessoa", null);
		});
	}
	
	@Test
	void testAlunoCursoVazio() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			aluno = new Aluno("Matricula", "Pessoa", "   ");
		});
	}
}
