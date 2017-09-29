package br.com.sitedoph.uniph.infraestrutura.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.dominio.repositorios.AlunoRepositorio;

public class AlunoDAO extends GenericDAOHibernate<Aluno> implements AlunoRepositorio, Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager entityManager;
	
	@Inject
	public AlunoDAO(EntityManager entityManager) {
		super(Aluno.class, entityManager);
		this.entityManager = entityManager;
	}

	
	public Aluno buscarPorCPF(String cpf) {
		
		Aluno exemplo = new Aluno();
		exemplo.setCpf(cpf);
		
		List<Aluno> list = buscarPorExemplo(exemplo);
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
}
