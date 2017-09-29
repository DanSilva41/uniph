package br.com.sitedoph.uniph.infraestrutura.persistencia.util;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.sitedoph.uniph.infraestrutura.dao.impl.GenericDAOHibernate;

/**
 * @author danilosilva
 */
public class DAOFactory {

	@Inject
	private EntityManager entityManager;

	@Produces
	public GenericDAOHibernate create(InjectionPoint injectionPoint) {
		ParameterizedType type = (ParameterizedType) injectionPoint.getType();
		Class classe = (Class) type.getActualTypeArguments()[0];
		return new GenericDAOHibernate<>(classe, entityManager);
	}

}
