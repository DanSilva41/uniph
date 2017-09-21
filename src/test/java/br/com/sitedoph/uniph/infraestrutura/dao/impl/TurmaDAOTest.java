package br.com.sitedoph.uniph.infraestrutura.dao.impl;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Turma;
import br.com.sitedoph.uniph.infraestrutura.persistencia.JPAUtil;

public class TurmaDAOTest {

	private final String DESCRICAO = "No máximo 20 alunos";

	//d@Test
	public void deveFazerCRUD() {

		EntityManager em = JPAUtil.getEntityManager();
		TurmaDAO dao = new TurmaDAO(em);

		Turma turmaPorDescricao = dao.buscarPorDescricao(DESCRICAO);

		em.getTransaction().begin();
		if (turmaPorDescricao != null) {
			dao.excluir(turmaPorDescricao);
		}
		em.getTransaction().commit();

		em.getTransaction().begin();
		turmaPorDescricao = dao.salvarOuAtualizar(turmaPorDescricao);
		em.getTransaction().commit();

		// Forma simplificada
		for (Turma turma : dao.buscarTodos()) {
			System.out.println(turma);
		}

		em.close();
	}
}
