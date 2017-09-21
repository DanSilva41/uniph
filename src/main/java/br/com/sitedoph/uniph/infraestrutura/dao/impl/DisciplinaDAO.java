package br.com.sitedoph.uniph.infraestrutura.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.sitedoph.uniph.dominio.entidade.Disciplina;

public class DisciplinaDAO {
	
	private final GenericDAOHibernate<Disciplina, Long> DAO;
	
	public DisciplinaDAO(EntityManager entityManager) {
		
		DAO = new GenericDAOHibernate<>(entityManager, Disciplina.class);
		
	}
	
	public void excluir(Disciplina entidade) {
		DAO.excluir(entidade);
	}
	
	public Disciplina salvarOuAtualizar(Disciplina entidade) {
		return DAO.salvarOuAtualizar(entidade);
	}
	
	public Disciplina buscarPorId(Long id) {
		return DAO.buscarPorId(id);
	}
	
	public List<Disciplina> buscarTodos(){
		return DAO.buscarTodos();
	}
	
	public Disciplina buscarPorDescricao(String descricao) {
		
		Disciplina exemplo = new Disciplina();
		
		exemplo.setDescricao(descricao);
		
		List<Disciplina> porExemplo = DAO.buscarPorExemplo(exemplo);
		
		if (porExemplo != null && !porExemplo.isEmpty()) {
			return porExemplo.get(0);
		} else {
			return null;
		}
	}
}