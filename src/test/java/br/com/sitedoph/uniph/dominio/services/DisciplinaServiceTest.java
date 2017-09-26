package br.com.sitedoph.uniph.dominio.services;

import java.util.List;

import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.dominio.entidades.Professor;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;

public class DisciplinaServiceTest extends BaseTest {

	@Test
	public void deveFuncionarService() {

		DisciplinaService service = new DisciplinaService();
		ProfessorService serviceProfessor = new ProfessorService();

		Disciplina materia = Fixture.from(Disciplina.class).gimme(VALID);

		List<Professor> list = serviceProfessor.buscarTodos();

		if (list.isEmpty()) {
			materia.setProfessor(null);
		} else {
			materia.setProfessor(list.get(0));
		}

		Disciplina buscarPorDescricao = service.buscarPorDescricao(materia.getDescricao());

		if (buscarPorDescricao != null) {
			service.excluir(materia);
		}

		materia = service.salvarOuAtualizar(materia);

		for (Disciplina disciplinaExibir : service.buscarTodos()) {
			System.out.println(disciplinaExibir);
		}
	}
}
