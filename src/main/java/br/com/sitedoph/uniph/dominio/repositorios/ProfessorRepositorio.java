package br.com.sitedoph.uniph.dominio.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

import br.com.sitedoph.uniph.dominio.entidades.Professor;
import br.com.sitedoph.uniph.infraestrutura.dao.impl.ProfessorDAO;
import br.com.sitedoph.uniph.infraestrutura.persistencia.JPAUtil;

public class ProfessorRepositorio {

	private EntityManager em;
	private ProfessorDAO DAO;

	public void criarDAOEEM() {
		em = JPAUtil.getEntityManager();
		DAO = new ProfessorDAO(em);
	}

	public Professor buscarPorId(Long id) {

		criarDAOEEM();

		Professor professor = DAO.buscarPorId(id);

		em.close();

		return professor;
	}

	public List<Professor> buscarTodos() {

		criarDAOEEM();

		List<Professor> lista = DAO.buscarTodos();

		em.close();

		return lista;
	}

	public Professor buscarPorCPF(String cpf) {

		criarDAOEEM();

		Professor professor = DAO.buscarCPF(cpf);

		em.close();

		return professor;
	}

	public void excluir(Professor professor) {

		criarDAOEEM();

		em.getTransaction().begin();

		try {
			DAO.excluir(professor);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

		em.close();
	}

	public Professor salvarOuAtualizar(Professor professor) {

		criarDAOEEM();

		em.getTransaction().begin();

		try {
			DAO.salvarOuAtualizar(professor);
			em.getTransaction().commit();
		} catch (ConstraintViolationException | PersistenceException e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}

		return professor;
	}
}