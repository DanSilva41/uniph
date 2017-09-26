package br.com.sitedoph.uniph.infraestrutura.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.sitedoph.uniph.dominio.entidade.Disciplina;
import br.com.sitedoph.uniph.dominio.entidade.Professor;
import br.com.sitedoph.uniph.infraestrutura.persistencia.JPAUtil;

public class DisciplinaDAOTest {

	private final String DESCRICAO = "Estrutura de Dados";
	
	//@Test
	public void deveFazerCRUDDeDisciplina() {

		EntityManager em = JPAUtil.getEntityManager();

		DisciplinaDAO dao = new DisciplinaDAO(em);
		
		ProfessorDAO daoP = new ProfessorDAO(em); // Para testes
		
		// Utilizando método buscarPorExemplo de GenericDAOHibernate
		Disciplina disciplinaPorDescricao = dao.buscarPorDescricao(DESCRICAO);

		em.getTransaction().begin();
		if (disciplinaPorDescricao != null) {
			// Utilizando método excluir
			dao.excluir(disciplinaPorDescricao);
		}
		em.getTransaction().commit();
		
		em.getTransaction().begin();

		// Para testes
		Professor ph = new Professor();
		ph.setNomeCompleto("Paulo Henrique Lerbach");
		
		ph = daoP.salvarOuAtualizar(ph);
		em.getTransaction().commit();
		
		em.getTransaction().begin();
		Disciplina java = new Disciplina();
		
		java.setDescricao(DESCRICAO);
		java.setCargaHoraria("80H");
		java.setProfessor(ph);

		// Utilizando método salvarOuAtualizar
		java = dao.salvarOuAtualizar(java);

		em.getTransaction().commit();

		// Disciplina buscarPorId = dao.buscarPorId(ph.getId());

		// Utilizando método buscarTodos
		List<Disciplina> buscarTodos = dao.buscarTodos();

		for (Disciplina disciplina : buscarTodos) {
			System.out.println(disciplina);
		}
		
		em.close();
	}
}
