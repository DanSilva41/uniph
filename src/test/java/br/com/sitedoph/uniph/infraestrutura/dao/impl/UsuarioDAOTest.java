package br.com.sitedoph.uniph.infraestrutura.dao.impl;

import javax.persistence.EntityManager;

import br.com.sitedoph.uniph.dominio.entidade.Usuario;
import br.com.sitedoph.uniph.infraestrutura.persistencia.JPAUtil;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;

public class UsuarioDAOTest extends BaseTest {

	// @Test
	public void deveSalvar() {

		EntityManager em = JPAUtil.getEntityManager();

		UsuarioDAO dao = new UsuarioDAO(em);

		Usuario user = Fixture.from(Usuario.class).gimme(VALID);
		// Utilizando método buscarPorExemplo de GenericDAOHibernate
		Usuario loginESenha = dao.buscarPorLoginESenha(user.getLogin(), user.getSenha());

		em.getTransaction().begin();
		if (loginESenha != null) {
			// Utilizando método excluir
			dao.excluir(loginESenha);
		}
		em.getTransaction().commit();

		em.getTransaction().begin();

		// Utilizando método salvarOuAtualizar
		user = dao.salvarOuAtualizar(user);

		em.getTransaction().commit();

		for (Usuario usuario : dao.buscarTodos()) {
			System.out.println(usuario);
		}

		em.close();
	}

}
