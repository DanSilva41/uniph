package br.com.sitedoph.uniph.dominio.services;

import br.com.sitedoph.uniph.dominio.entidades.Professor;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;

public class ProfessorServiceTest extends BaseTest {

	// @Test
	public void deveFuncionarService() {

		ProfessorService service = new ProfessorService();

		Professor teacher = Fixture.from(Professor.class).gimme(VALID);

		Professor buscarPorCpf = service.buscarPorCPF(teacher.getCpf());

		if (buscarPorCpf != null) {
			service.excluir(buscarPorCpf);
		}

		teacher = service.salvarOuAtualizar(teacher);

		for (Professor professores : service.buscarTodos()) {
			System.out.println(professores);
		}
	}
}
