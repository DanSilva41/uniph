package br.com.sitedoph.uniph.dominio.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.sitedoph.uniph.dominio.entidades.Professor;
import br.com.sitedoph.uniph.dominio.repositorios.ProfessorRepositorio;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.Transacional;

public class ProfessorService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProfessorRepositorio professorRepo;

	public Professor buscarPorId(Long id) {
		return professorRepo.buscarPorId(id);
	}

	public List<Professor> buscarTodos() {
		return professorRepo.buscarTodos();
	}

	@Transacional
	public void excluir(Professor professor) {
		professorRepo.excluir(professor);
	}

	@Transacional
	public Professor salvarOuAtualizar(Professor professor) {
		return professorRepo.salvarOuAtualizar(professor);
	}

	public List<Professor> filtrarPorPalavraChave(String filtro) {
		return professorRepo.filtrarPorPalavraChave(filtro);
	}

}
