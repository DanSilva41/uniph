package br.com.sitedoph.uniph.dominio.services;

import java.util.List;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.dominio.entidades.Turma;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;

public class TurmaServiceTest extends BaseTest {

	// @Test
	public void deveFuncionarService() {

		TurmaService service = new TurmaService();
		AlunoService serviceAluno = new AlunoService();
		DisciplinaService serviceDisciplina = new DisciplinaService();

		Turma turma = Fixture.from(Turma.class).gimme(VALID);

		Turma buscarPorDescricao = service.buscarPorDescricao(turma.getDescricao());

		if (buscarPorDescricao != null) {
			service.excluir(turma);
		}

		List<Aluno> list_alunos = serviceAluno.buscarTodos();
		List<Disciplina> list_disciplinas = serviceDisciplina.buscarTodos();

		if (!list_alunos.isEmpty() && !list_disciplinas.isEmpty()) {
			turma.setAlunos(list_alunos);
			turma.setDisciplinas(list_disciplinas);
		} else {
			turma.setAlunos(null);
			turma.setDisciplinas(null);
		}

		turma = service.salvarOuAtualizar(turma);

		service.buscarTodos().forEach(System.out::println);
	}
}
