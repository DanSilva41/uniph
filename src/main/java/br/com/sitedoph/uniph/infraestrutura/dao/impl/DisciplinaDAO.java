package br.com.sitedoph.uniph.infraestrutura.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.dominio.repositorios.DisciplinaRepositorio;

public class DisciplinaDAO extends GenericDAOHibernate<Disciplina> implements DisciplinaRepositorio {

	private static final long serialVersionUID = 1L;

	private final EntityManager entityManager;

	@Inject
	public DisciplinaDAO(EntityManager entityManager) {
		super(Disciplina.class, entityManager);
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Disciplina> filtrarPorPalavraChave(String filtro) {

		Query query = entityManager
				.createQuery("SELECT a FROM Disciplina a " + "WHERE " + "lower(a.cargaHoraria) LIKE :filtro OR "
						+ "lower(a.descricao) LIKE :filtro OR " + "lower(a.professor) LIKE :filtro");
		query.setParameter("filtro", "%" + filtro.toLowerCase() + "%");

		return query.getResultList();
	}

}
