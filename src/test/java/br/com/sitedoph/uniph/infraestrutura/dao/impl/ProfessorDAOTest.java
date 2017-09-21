package br.com.sitedoph.uniph.infraestrutura.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.sitedoph.uniph.dominio.entidade.Professor;
import br.com.sitedoph.uniph.infraestrutura.persistencia.JPAUtil;

public class ProfessorDAOTest {

	private static final String CPF = "999.999.999-99";

	//@Test
	public void deveFazerCRUDDeProfessor() {

		EntityManager em = JPAUtil.getEntityManager();

		ProfessorDAO dao = new ProfessorDAO(em);
		// Utilizando método buscarPorExemplo de GenericDAOHibernate
		Professor professorPorCPF = dao.buscarCPF(CPF);

		em.getTransaction().begin();
		if (professorPorCPF != null) {
			// Utilizando método excluir
			dao.excluir(professorPorCPF);
		}
		em.getTransaction().commit();

		Professor ph = new Professor();

		ph.setEmail("ph@gmail.com");
		ph.setCpf(CPF);
		ph.setNomeCompleto("Palerique");
		ph.setTelefone("999999999");
		ph.setDataCadastro(Calendar.getInstance());
		ph.setCurriculo("Java Full Stack");
		
		em.getTransaction().begin();

		// Utilizando método salvarOuAtualizar
		ph = dao.salvarOuAtualizar(ph);

		em.getTransaction().commit();

		// Professor buscarPorId = dao.buscarPorId(ph.getId());

		// Utilizando método buscarTodos
		List<Professor> buscarTodos = dao.buscarTodos();

		for (Professor professor : buscarTodos) {
			System.out.println(professor);
		}
	}
}
