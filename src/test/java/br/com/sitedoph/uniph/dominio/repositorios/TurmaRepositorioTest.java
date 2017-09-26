package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidade.Turma;
import br.com.sitedoph.uniph.dominio.repositorio.TurmaRepositorio;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;

public class TurmaRepositorioTest extends BaseTest {

	// @Test
	public void deveFuncionarRepositorio() {

		TurmaRepositorio repo = new TurmaRepositorio();

		Turma turma = Fixture.from(Turma.class).gimme(VALID);

		Turma buscarPorDescricao = repo.buscarPorDescricao(turma.getDescricao());

		if (buscarPorDescricao != null) {
			repo.exluir(turma);
		}
		
		turma.setAlunos(null);
		turma.setDisciplinas(null);

		turma = repo.salvarOuAtualizar(turma);

		for (Turma turmaExibir : repo.buscarTodos()) {
			System.out.println(turmaExibir);
		}
	}
}
