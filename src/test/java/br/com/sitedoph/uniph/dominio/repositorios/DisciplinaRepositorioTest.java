package br.com.sitedoph.uniph.dominio.repositorios;

import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;

public class DisciplinaRepositorioTest extends BaseTest {

	@Test
	public void deveFuncionarRepositorio() {

		DisciplinaRepositorio repo = new DisciplinaRepositorio();

		Disciplina materia = Fixture.from(Disciplina.class).gimme(VALID);
		materia.setProfessor(null);

		Disciplina buscarPorDescricao = repo.buscarPorDescricao(materia.getDescricao());

		if (buscarPorDescricao != null) {
			repo.excluir(materia);
		}

		materia = repo.salvarOuAtualizar(materia);

		for (Disciplina disciplinaExibir : repo.buscarTodos()) {
			System.out.println(disciplinaExibir);
		}
	}
}
