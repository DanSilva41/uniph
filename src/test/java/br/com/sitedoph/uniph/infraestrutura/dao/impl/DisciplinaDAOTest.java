package br.com.sitedoph.uniph.infraestrutura.dao.impl;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Disciplina;
import br.com.sitedoph.uniph.infraestrutura.persistencia.JPAUtil;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.processor.HibernateProcessor;

public class DisciplinaDAOTest extends BaseTest {

	// @Test
	public void deveFazerCRUDDeDisciplina() {

		EntityManager em = JPAUtil.getEntityManager();
		DisciplinaDAO dao = new DisciplinaDAO(em);

		Disciplina disciplina1 = Fixture.from(Disciplina.class).uses(new HibernateProcessor((Session) em.getDelegate()))
				.gimme("valid");

		Disciplina disciplinaPorDescricao = dao.buscarPorDescricao(disciplina1.getDescricao());
		em.getTransaction().begin();
		if (disciplinaPorDescricao != null) {
			dao.excluir(disciplinaPorDescricao);
		}
		em.getTransaction().commit();

		em.getTransaction().begin();
		disciplina1 = dao.salvarOuAtualizar(disciplina1);
		em.getTransaction().commit();

		for (Disciplina disciplina : dao.buscarTodos()) {
			System.out.println(disciplina);
		}

		em.close();

	}
}