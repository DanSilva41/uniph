package br.com.sitedoph.uniph.dominio.repositorio;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.sitedoph.uniph.dominio.entidade.Turma;
import br.com.sitedoph.uniph.infraestrutura.dao.impl.TurmaDAO;
import br.com.sitedoph.uniph.infraestrutura.persistencia.JPAUtil;

public class TurmaRepositorio {

	private EntityManager em;
	private TurmaDAO DAO;

	public void criarDAOEEm() {
		em = JPAUtil.getEntityManager();
		DAO = new TurmaDAO(em);
	}

	public Turma buscarPorId(Long id) {

		criarDAOEEm();

		Turma turma = DAO.buscarPorId(id);

		em.close();

		return turma;
	}

	public List<Turma> buscarTodos() {

		criarDAOEEm();

		List<Turma> lista = DAO.buscarTodos();

		em.close();

		return lista;
	}

	public Turma buscarPorDescricao(String descricao) {

		criarDAOEEm();

		Turma turma = DAO.buscarPorDescricao(descricao);

		em.close();

		return turma;
	}

	public void exluir(final Turma turma) {

		criarDAOEEm();

		em.getTransaction().begin();

		try {
			DAO.excluir(turma);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}

		em.close();
	}

	public Turma salvarOuAtualizar(Turma turma) {

		criarDAOEEm();

		em.getTransaction().begin();

		try {
			DAO.salvarOuAtualizar(turma);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}

		return turma;
	}
}