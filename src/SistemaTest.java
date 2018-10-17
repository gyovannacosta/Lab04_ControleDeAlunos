import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ferramentas.Saida;
import sistema.Aluno;
import sistema.Grupo;
import sistema.Sistema;

class SistemaTest {


		private Sistema sistema = new Sistema();
		private ArrayList<Aluno> aluno;
		private HashMap<String, Grupo> grupo;

	@Test
	void testCadastraAlunoValido() {
		assertEquals("CADASTRO REALIZADO!", sistema.cadastraAluno("0000", "Gyovanna", "CC"));
	}
	
	@Test
	void testCadastraAlunoExistente() {
		sistema.cadastraAluno("0000", "Marcia", "ADM");
		assertEquals("MATRÍCULA JÁ CADASTRADA!", sistema.cadastraAluno("0000", "Gyovanna", "CC"));
	}
	
	@Test
	void testCadastraAlunoInvalido() {
		
		//Cadastro de aluno com matrícula vazia
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			sistema.cadastraAluno("   ", "Gyovanna", "CC");
		});
		
		//Cadastro de aluno com nome vazio
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			sistema.cadastraAluno("00", "  ", "CC");
		});
		
		//Cadastro de aluno com curso vazio
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			sistema.cadastraAluno("00", "Gyovanna", "    ");
		});
		
		//Cadastro de aluno com matricula nula
		Assertions.assertThrows(NullPointerException.class, () -> {
			sistema.cadastraAluno(null, "Gyovanna", "CC");
		});
		
		//Cadastro de aluno com nome nulo
		Assertions.assertThrows(NullPointerException.class, () -> {
			sistema.cadastraAluno("00", null, "CC");
		});
		
		//Cadastro de aluno com curso nulo
		Assertions.assertThrows(NullPointerException.class, () -> {
			sistema.cadastraAluno("00", "Gyovanna", null);
		});
		
	}
	
	@Test
	void testGetAlunoExistente() {
		sistema.cadastraAluno("0000", "Gyovanna", "CC");
		assertEquals("Aluno: 0000 - Gyovanna - CC", sistema.getAluno("0000"));
	}
	
	@Test
	void testGetAlunoInexistente() {
		assertEquals("ALUNO NÃO CADASTRADO.", sistema.getAluno("0000"));
	}
	
	@Test
	void testGetAlunoEntradaInvalida() {
		//Matricula Nula
		Assertions.assertThrows(NullPointerException.class, () -> {
			sistema.getAluno(null);
		});	
		
		//Matricula Vazia
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			sistema.getAluno("                 ");
		});
	}

	@Test
	void testCadastraGrupoValido() {
		assertEquals("CADASTRO REALIZADO!", sistema.cadastraGrupo("Guardians"));
	}
	
	@Test
	void testCadastraGrupoExistente() {
		sistema.cadastraGrupo("Guardians");
		assertEquals("GRUPO JÁ CADASTRADO!", sistema.cadastraGrupo("guardians"));
	}
	
	@Test
	void testCadastraGrupoEntradaInvalida() {
		//Grupo Nulo
		Assertions.assertThrows(NullPointerException.class, () -> {
			sistema.getAluno(null);
		});	
		
		//Grupo Vazio
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			sistema.getAluno("                 ");
		});
	}

	@Test
	void testAlocarAluno() {
		sistema.cadastraAluno("0000", "Gyovanna", "CC");
		sistema.cadastraGrupo("Guardians");
		assertEquals("ALUNO ALOCADO!", sistema.alocarAluno("0000", "Guardians"));
	}
	
	@Test
	void testAlocarAlunoInexistente() {
		sistema.cadastraGrupo("Guardians");
		assertEquals("ALUNO NÃO CADASTRADO!", sistema.alocarAluno("0000", "Guardians"));
	}
	
	@Test
	void testAlocarAlunoGrupoInexistente() {
		sistema.cadastraAluno("0000", "Gyovanna", "CC");
		assertEquals("GRUPO NÃO CADASTRADO!", sistema.alocarAluno("0000", "Guardians"));
	}
	
	@Test
	void testAlocarAlunoEntradaInvalida() {
		
		//Matricula nula
		Assertions.assertThrows(NullPointerException.class, () -> {
			sistema.alocarAluno(null, "Guardians");
		});	
		
		//Matricula vazia
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			sistema.alocarAluno("", "Guardians");
		});	
		
		//Grupo nulo
		Assertions.assertThrows(NullPointerException.class, () -> {
			sistema.alocarAluno("000", null);
		});	
		
		//Grupo vazio
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			sistema.alocarAluno("000", "     ");
		});	
	}

	@Test
	void testListarAlunos() {
		sistema.cadastraGrupo("Guardians");
		sistema.cadastraAluno("0000", "Gyovanna", "CC");
		sistema.cadastraAluno("0001", "Marcia", "ADM");
		sistema.alocarAluno("0000", "Guardians");
		sistema.alocarAluno("0001", "Guardians");
		assertEquals("Alunos do grupo GUARDIANS:" + Saida.PL + "* 0001 - Marcia - ADM" + Saida.PL + "* 0000 - Gyovanna - CC", sistema.listarAlunos("Guardians"));
	}
	
	@Test
	void testListarAlunosEntradaInvalida() {
		//Grupo nulo
		Assertions.assertThrows(NullPointerException.class, () -> {
			sistema.alocarAluno("000", null);
		});	
				
		//Grupo vazio
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			sistema.alocarAluno("000", "     ");
		});
	}

	@Test
	void testRegistraResposta() {
		sistema.cadastraAluno("0000", "Gyovanna", "CC");
		assertEquals("ALUNO REGISTRADO!", sistema.registraResposta("0000"));
	}
	
	@Test
	void testRegistraRespostaAlunoInexistente() {
		assertEquals("ALUNO NÃO CADASTRADO!", sistema.registraResposta("0000"));
	}
	
	@Test
	void testRegistraRespostaEntradaInvalida() {
		//Matricula nula
		Assertions.assertThrows(NullPointerException.class, () -> {
			sistema.registraResposta(null);
		});	
				
		//Matricula vazia
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			sistema.registraResposta("          ");
		});
	}

	@Test
	void testListarRespostas() {
		sistema.cadastraAluno("0000", "Gyovanna", "CC");
		sistema.registraResposta("0000");
		sistema.registraResposta("0000");
		assertEquals("Alunos:" + Saida.PL + "0000 - Gyovanna - CC" + Saida.PL + "0000 - Gyovanna - CC", sistema.listarRespostas());
	}

}
