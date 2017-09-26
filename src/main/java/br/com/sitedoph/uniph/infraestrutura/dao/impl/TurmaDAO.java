package br.com.sitedoph.uniph.infraestrutura.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.sitedoph.uniph.dominio.entidade.Turma;
import br.com.sitedoph.uniph.infraestrutura.dao.GenericDAO;

public class TurmaDAO {
	
	private final GenericDAO<Turma, Long> DAO;

	public TurmaDAO(EntityManager entityManager) {
		DAO = new GenericDAOHibernate<>(entityManager, Turma.class);
	}

	public void excluir(Turma entidade) {
		DAO.excluir(entidade);
	}

	public Turma salvarOuAtualizar(Turma entidade) {
		return DAO.salvarOuAtualizar(entidade);
	}

	public Turma buscarPorId(Long id) {
		return DAO.buscarPorId(id);
	}

	public List<Turma> buscarTodos() {
		
		List<Turma> exemplo = DAO.buscarTodos();
		
		if (exemplo != null && !exemplo.isEmpty()) {
			return exemplo;
		} else {
			return null;
		}
	}

	public Turma buscarPorDescricao(String descricao) {

		Turma exemplo = new Turma();

		exemplo.setDescricao(descricao);

		List<Turma> porExemplo = DAO.buscarPorExemplo(exemplo);

		if (porExemplo != null && !porExemplo.isEmpty()) {
			return porExemplo.get(0);
		} else {
			return null;
		}
	}
}
