package br.com.sitedoph.uniph.infraestrutura.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

public class GenericDAOHibernate<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Class<T> CLASSE;

	private final EntityManager entityManager;

	public GenericDAOHibernate(Class<T> classe, EntityManager entityManager) {
		CLASSE = classe;
		this.entityManager = entityManager;
	}

	public T salvarOuAtualizar(T entidade) {
		return entityManager.merge(entidade);
	}

	public T buscarPorId(Long id) {
		return entityManager.find(CLASSE, id);
	}

	public List<T> buscarTodos() {

		CriteriaQuery<T> query = entityManager.getCriteriaBuilder().createQuery(CLASSE);

		query.select(query.from(CLASSE));

		return entityManager.createQuery(query).getResultList();
	}

	public void excluir(T entidade) {
		entidade = entityManager.merge(entidade);
		entityManager.remove(entidade);
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<T> buscarPorCriteria(Criterion... criteria) {

		Session session = getHibernateSession();

		Criteria crit = session.createCriteria(CLASSE);

		for (Criterion criterion : criteria)
			crit.add(criterion);

		return crit.list();
	}

	private Session getHibernateSession() {
		return (Session) entityManager.getDelegate();
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<T> buscarPorExemplo(T exemplo, String... propriedadesAExcluir) {

		Example example = Example.create(exemplo);

		example.enableLike(MatchMode.ANYWHERE);
		example.excludeZeroes();
		example.ignoreCase();

		for (String prop : propriedadesAExcluir)
			example.excludeProperty(prop);

		Session session = getHibernateSession();

		Criteria criteria = session.createCriteria(CLASSE).add(example);

		return criteria.list();
	}

}
