package br.com.sitedoph.uniph.infraestrutura.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Usuario;
import br.com.sitedoph.uniph.infraestrutura.persistencia.JPAUtil;

public class UsuarioDAOTest {
	
	private static final String SENHA = "123456";
	private static final String MARQUINHOS = "Marquinhos";
	
	// @Test
	public void deveSalvar(){
		
		EntityManager em = JPAUtil.getEntityManager();
		
		UsuarioDAO dao = new UsuarioDAO(em);
		
							// Utilizando método buscarPorExemplo de GenericDAOHibernate
		Usuario loginESenha = dao.buscarPorLoginESenha(MARQUINHOS, SENHA);
		
		em.getTransaction().begin();
		
		if (loginESenha != null) {
			// Utilizando método excluir
			dao.excluir(loginESenha);
		}
		
		em.getTransaction().commit();
		
		Usuario exemplo = new Usuario();
		exemplo.setLogin("dansilva41");
		exemplo.setNomeCompleto("Danilo Silva");
		exemplo.setEmail("dan@gmail.com");
		exemplo.setSenha("123456");
		
		em.getTransaction().begin();
		
		// Utilizando método salvarOuAtualizar
		exemplo = dao.salvarOuAtualizar(exemplo);
		
		em.getTransaction().commit();
		
		// Usuario buscarPorId = dao.buscarPorId(exemplo.getId());
									
									// Utilizando método buscarTodos
		List<Usuario> buscarTodos = dao.buscarTodos();
		
		for (Usuario usuario : buscarTodos) {
			System.out.println(usuario);
		}
	}

}
