package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidade.Professor;
import br.com.sitedoph.uniph.dominio.repositorio.ProfessorRepositorio;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;

public class ProfessorRepositorioTest extends BaseTest {

	// @Test
	public void deveFuncionarRepositorio() {

		ProfessorRepositorio repo = new ProfessorRepositorio();

		Professor teacher = Fixture.from(Professor.class).gimme(VALID);
		Professor buscarPorCpf = repo.buscarPorCPF(teacher.getCpf());

		if (buscarPorCpf != null) {
			repo.excluir(buscarPorCpf);
		}

		teacher = repo.salvarOuAtualizar(teacher);

		for (Professor professor : repo.buscarTodos()) {
			System.out.println(professor);
		}
	}
}
