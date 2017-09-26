package br.com.sitedoph.uniph.dominio.services;

import java.util.List;

import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.dominio.repositorios.DisciplinaRepositorio;

public class DisciplinaService {

	private final DisciplinaRepositorio repo = new DisciplinaRepositorio();

	public Disciplina buscarPorId(Long id) {
		return repo.buscarPorId(id);
	}

	public Disciplina buscarPorDescricao(String descricao) {
		return repo.buscarPorDescricao(descricao);
	}

	public List<Disciplina> buscarTodos() {
		return repo.buscarTodos();
	}

	public void excluir(Disciplina disciplina) {
		repo.exluir(disciplina);
	}

	public Disciplina salvarOuAtualizar(Disciplina disciplina) {
		return repo.salvarOuAtualizar(disciplina);
	}
}
