package br.com.sitedoph.uniph.infraestrutura.dao.impl;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Professor;
import br.com.sitedoph.uniph.infraestrutura.persistencia.JPAUtil;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;

public class ProfessorDAOTest extends BaseTest {

	// @Test
	public void deveFazerCRUDDeProfessor() {

		EntityManager em = JPAUtil.getEntityManager();

		ProfessorDAO dao = new ProfessorDAO(em);

		Professor teacher = Fixture.from(Professor.class).gimme(VALID);

		// Utilizando método buscarPorExemplo de GenericDAOHibernate
		Professor professorPorCPF = dao.buscarCPF(teacher.getCpf());

		em.getTransaction().begin();
		if (professorPorCPF != null) {
			// Utilizando método excluir
			dao.excluir(professorPorCPF);
		}
		em.getTransaction().commit();

		em.getTransaction().begin();

		// Utilizando método salvarOuAtualizar
		teacher = dao.salvarOuAtualizar(teacher);

		em.getTransaction().commit();

		for (Professor professor : dao.buscarTodos()) {
			System.out.println(professor);
		}

		em.close();
	}
}
