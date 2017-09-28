package br.com.sitedoph.uniph.dominio.services;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;

public class AlunoServiceTest extends BaseTest {

	// @Test
	public void deveFuncionarService() {

		AlunoService service = new AlunoService();

		Aluno estudante = Fixture.from(Aluno.class).gimme(VALID);

		Aluno buscarPorCpf = service.buscarPorCPF(estudante.getCpf());

		if (buscarPorCpf != null) {
			service.excluir(buscarPorCpf);
		}

		estudante = service.salvarOuAtualizar(estudante);

		service.buscarTodos().forEach(System.out::println);
	}
}
