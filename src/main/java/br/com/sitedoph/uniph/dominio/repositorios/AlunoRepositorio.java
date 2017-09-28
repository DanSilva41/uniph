package br.com.sitedoph.uniph.dominio.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.infraestrutura.dao.impl.AlunoDAO;
import br.com.sitedoph.uniph.infraestrutura.persistencia.JPAUtil;

public class AlunoRepositorio {
	private EntityManager em;
	private AlunoDAO DAO;

	public void criarDAOEEm() {
		em = JPAUtil.getEntityManager();
		DAO = new AlunoDAO(em);
	}

	public Aluno buscarPorId(Long id) {

		criarDAOEEm();

		Aluno aluno = DAO.buscarPorId(id);

		em.close();

		return aluno;
	}

	public List<Aluno> buscarTodos() {

		criarDAOEEm();

		List<Aluno> lista = DAO.buscarTodos();

		em.close();

		return lista;
	}

	public Aluno buscarPorCPF(String cpf) {

		criarDAOEEm();

		Aluno aluno = DAO.buscarCPF(cpf);

		em.close();

		return aluno;
	}

	public void excluir(final Aluno aluno) {

		criarDAOEEm();

		em.getTransaction().begin();

		try {
			DAO.excluir(aluno);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}

		em.close();
	}

	public Aluno salvarOuAtualizar(Aluno aluno) {

		criarDAOEEm();

		em.getTransaction().begin();

		try {
			DAO.salvarOuAtualizar(aluno);
			em.getTransaction().commit();
		} catch (ConstraintViolationException | PersistenceException e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}

		return aluno;
	}
}
