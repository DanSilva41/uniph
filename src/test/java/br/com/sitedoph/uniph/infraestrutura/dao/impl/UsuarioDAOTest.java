package br.com.sitedoph.uniph.infraestrutura.dao.impl;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Usuario;
import br.com.sitedoph.uniph.infraestrutura.persistencia.JPAUtil;

public class UsuarioDAOTest {
	
	@Test
	public void deveSalvar(){
		
		EntityManager em = JPAUtil.getEntityManager();
		
		UsuarioDAO dao = new UsuarioDAO(em);
		
		Usuario exemplo = new Usuario();
		exemplo.setLogin("dansilva41");
		exemplo.setNomeCompleto("Danilo Silva");
		exemplo.setEmail("dan@gmail.com");
		exemplo.setSenha("123456");
		
		em.getTransaction().begin();
		
		exemplo = dao.salvarOuAtualizar(exemplo);
		
		em.getTransaction().commit();
		
		Usuario buscarPorId = dao.buscarPorId(exemplo.getId());
		
		System.out.println(buscarPorId.toString());
	}

}
