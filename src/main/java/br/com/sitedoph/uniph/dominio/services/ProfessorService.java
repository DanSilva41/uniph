package br.com.sitedoph.uniph.dominio.services;

import java.util.List;

import br.com.sitedoph.uniph.dominio.entidades.Professor;
import br.com.sitedoph.uniph.dominio.repositorios.ProfessorRepositorio;

public class ProfessorService {

	private final ProfessorRepositorio repo = new ProfessorRepositorio();

	public Professor buscarPorId(final Long id) {
		return repo.buscarPorId(id);
	}

	public Professor buscarPorCPF(String cpf) {
		return repo.buscarPorCPF(cpf);
	}

	public List<Professor> buscarTodos() {
		return repo.buscarTodos();
	}

	public void excluir(Professor professor) {
		repo.excluir(professor);
	}

	public Professor salvarOuAtualizar(Professor professor) {
		return repo.salvarOuAtualizar(professor);
	}
}
