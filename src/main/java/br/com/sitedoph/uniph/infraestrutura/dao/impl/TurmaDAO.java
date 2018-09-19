package br.com.sitedoph.uniph.infraestrutura.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sitedoph.uniph.dominio.entidades.Turma;
import br.com.sitedoph.uniph.dominio.repositorios.TurmaRepositorio;

public class TurmaDAO extends GenericDAOHibernate<Turma> implements TurmaRepositorio, Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager entityManager;

	@Inject
	public TurmaDAO(EntityManager entityManager) {
		super(Turma.class, entityManager);
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Turma> filtrarPorPalavraChave(String filtro) {

		Query query = entityManager.createQuery("SELECT t FROM Turma t " + "INNER JOIN t.disciplinas d " + "WHERE "
				+ "lower(t.horario) LIKE :filtro OR " + "lower(t.descricao) LIKE :filtro OR "
				+ "lower(d.descricao) LIKE :filtro ");

		query.setParameter("filtro", "%" + filtro.toLowerCase() + "%");

		return query.getResultList();
	}
}
