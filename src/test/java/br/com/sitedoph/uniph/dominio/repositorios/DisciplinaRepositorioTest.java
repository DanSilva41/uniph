package br.com.sitedoph.uniph.dominio.repositorios;

import java.util.List;

import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.dominio.entidades.Professor;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;

public class DisciplinaRepositorioTest extends BaseTest {

	//@Test
	public void deveFuncionarRepositorio() {

		DisciplinaRepositorio repo = new DisciplinaRepositorio();
		ProfessorRepositorio repoProfessor = new ProfessorRepositorio();

		Disciplina materia = Fixture.from(Disciplina.class).gimme(VALID);

		Disciplina buscarPorDescricao = repo.buscarPorDescricao(materia.getDescricao());

		if (buscarPorDescricao != null) {
			repo.excluir(materia);
		}

		List<Professor> list = repoProfessor.buscarTodos();

		if (list.isEmpty()) {
			materia.setProfessor(null);
		} else {
			materia.setProfessor(list.get(0));
		}

		materia = repo.salvarOuAtualizar(materia);

		for (Disciplina disciplinaExibir : repo.buscarTodos()) {
			System.out.println(disciplinaExibir);
		}
	}
}
