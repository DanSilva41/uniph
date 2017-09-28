package br.com.sitedoph.uniph.infraestrutura.dao.impl;

import javax.persistence.EntityManager;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.infraestrutura.persistencia.JPAUtil;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;

public class AlunoDAOTest extends BaseTest {

	// @Test
	public void deveFazerCRUDDeAluno() {

		EntityManager em = JPAUtil.getEntityManager();
		AlunoDAO dao = new AlunoDAO(em);

		Aluno estudante = Fixture.from(Aluno.class).gimme(VALID);

		Aluno alunoPorCPF = dao.buscarCPF(estudante.getCpf());

		if (alunoPorCPF != null) {
			estudante = alunoPorCPF;
			// dao.excluir(alunoPorCPF);
		}

		em.getTransaction().begin();

		// Utilizando método salvarOuAtualizar
		estudante = dao.salvarOuAtualizar(estudante);

		em.getTransaction().commit();

		dao.buscarTodos().forEach(System.out::println);

		em.close();
	}
}
