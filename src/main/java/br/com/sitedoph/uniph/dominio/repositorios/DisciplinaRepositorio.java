package br.com.sitedoph.uniph.dominio.repositorios;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.infraestrutura.dao.impl.DisciplinaDAO;
import br.com.sitedoph.uniph.infraestrutura.persistencia.JPAUtil;

public class DisciplinaRepositorio {

	private EntityManager em;
	private DisciplinaDAO DAO;

	public void criarDAOEEm() {
		em = JPAUtil.getEntityManager();
		DAO = new DisciplinaDAO(em);
	}

	public Disciplina buscarPorId(Long id) {

		criarDAOEEm();

		Disciplina disciplina = DAO.buscarPorId(id);

		em.close();

		return disciplina;
	}

	public List<Disciplina> buscarTodos() {

		criarDAOEEm();

		List<Disciplina> lista = DAO.buscarTodos();

		em.close();

		return lista;
	}

	public Disciplina buscarPorDescricao(String descricao) {

		criarDAOEEm();

		Disciplina disciplina = DAO.buscarPorDescricao(descricao);

		em.close();

		return disciplina;
	}

	public void excluir(final Disciplina disciplina) {

		criarDAOEEm();

		em.getTransaction().begin();

		try {
			DAO.excluir(disciplina);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}

		em.close();
	}

	public Disciplina salvarOuAtualizar(Disciplina disciplina) {

		criarDAOEEm();

		em.getTransaction().begin();

		try {
			DAO.salvarOuAtualizar(disciplina);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}

		return disciplina;
	}
}
