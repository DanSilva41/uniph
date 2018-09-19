package br.com.sitedoph.uniph.infraestrutura.dao.impl;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sitedoph.uniph.dominio.entidades.Professor;
import br.com.sitedoph.uniph.dominio.repositorios.ProfessorRepositorio;

public class ProfessorDAO extends GenericDAOHibernate<Professor> implements ProfessorRepositorio {

	private static final long serialVersionUID = 1L;

	private final EntityManager entityManager;

	@Inject
	public ProfessorDAO(EntityManager entityManager) {
		super(Professor.class, entityManager);
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> filtrarPorPalavraChave(String filtro) {

		Query query = entityManager.createQuery("SELECT a FROM Professor a " + "WHERE "
				+ "lower(a.nomeCompleto) LIKE :filtro OR " + "lower(a.cpf) LIKE :filtro OR "
				+ "lower(a.curriculo) LIKE :filtro OR " + "lower(a.email) LIKE :filtro OR "
				+ "lower(a.telefone) LIKE :filtro OR " + "lower(a.dataCadastro) LIKE :filtro");
		query.setParameter("filtro", "%" + filtro.toLowerCase() + "%");

		return query.getResultList();
	}

}
