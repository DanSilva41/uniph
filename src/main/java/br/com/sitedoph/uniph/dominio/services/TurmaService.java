package br.com.sitedoph.uniph.dominio.services;

import java.util.List;

import br.com.sitedoph.uniph.dominio.entidades.Turma;
import br.com.sitedoph.uniph.dominio.repositorios.TurmaRepositorio;

public class TurmaService {

	private final TurmaRepositorio repo = new TurmaRepositorio();

	public Turma buscarPorId(Long id) {
		return repo.buscarPorId(id);
	}

	public Turma buscarPorDescricao(String descricao) {
		return repo.buscarPorDescricao(descricao);
	}

	public List<Turma> buscarTodos() {
		return repo.buscarTodos();
	}

	public void excluir(Turma turma) {
		repo.excluir(turma);
	}

	public Turma salvarOuAtualizar(Turma turma) {
		return repo.salvarOuAtualizar(turma);
	}
}
