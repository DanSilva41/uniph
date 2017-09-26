package br.com.sitedoph.uniph.infraestrutura.dao.impl;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import br.com.sitedoph.uniph.dominio.entidade.Turma;
import br.com.sitedoph.uniph.infraestrutura.persistencia.JPAUtil;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.processor.HibernateProcessor;

public class TurmaDAOTest extends BaseTest {

	// @Test
	public void deveFazerCRUD() {

		EntityManager em = JPAUtil.getEntityManager();
		TurmaDAO dao = new TurmaDAO(em);

		// Para testes
		AlunoDAO daoAluno = new AlunoDAO(em);
		DisciplinaDAO daoDisciplina = new DisciplinaDAO(em);

		// Gera e atribui os valores aos campos do objeto e 
		// invoca o processo para persistir os objetos relacionados
		// É usado quando o objeto possui relacionamentos. == Evita objetos Transients ==
		Turma sala = Fixture.from(Turma.class).uses(new HibernateProcessor((Session) em.getDelegate())).gimme(VALID);

		Turma turmaPorDescricao = dao.buscarPorDescricao(sala.getDescricao());

		em.getTransaction().begin();
		if (turmaPorDescricao != null) {
			dao.excluir(turmaPorDescricao);
		}
		em.getTransaction().commit();

		sala.setAlunos(daoAluno.buscarTodos());
		sala.setDisciplinas(daoDisciplina.buscarTodos());

		em.getTransaction().begin();
		sala = dao.salvarOuAtualizar(sala);
		em.getTransaction().commit();

		// Forma simplificada
		for (Turma turma : dao.buscarTodos()) {
			System.out.println(turma);
		}

		em.close();
	}
}
