import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ferramentas.Saida;
import sistema.Aluno;
import sistema.Grupo;

class GrupoTest {
	
	private Grupo grupo;
	private Aluno aluno;

	@Test
	void testGrupoNull() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			grupo = new Grupo(null);
		});
	}
	
	@Test
	void testGrupoVazio() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			grupo = new Grupo("");
		});
	}

	@Test
	void testToString() {
		grupo = new Grupo("Guardians");
		aluno = new Aluno("0000", "Gyovanna", "CC");
		grupo.adicionaAluno(aluno);
		aluno = new Aluno("0001", "Marcia", "ADM");
		grupo.adicionaAluno(aluno);
		assertEquals("Alunos do grupo Guardians:" + Saida.PL + "* 0001 - Marcia - ADM" + Saida.PL + "* 0000 - Gyovanna - CC", grupo.toString());
		
	}

}
