package br.com.sitedoph.uniph.dominio.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.dominio.repositorios.DisciplinaRepositorio;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.Transacional;

public class DisciplinaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DisciplinaRepositorio disciplinaRepo;

	public Disciplina buscarPorId(Long id) {
		return disciplinaRepo.buscarPorId(id);
	}

	public List<Disciplina> buscarTodos() {
		return disciplinaRepo.buscarTodos();
	}

	@Transacional
	public void excluir(Disciplina disciplina) {
		disciplinaRepo.excluir(disciplina);
	}

	@Transacional
	public Disciplina salvarOuAtualizar(Disciplina disciplina) {
		return disciplinaRepo.salvarOuAtualizar(disciplina);
	}

	public List<Disciplina> filtrarPorPalavraChave(String filtro) {
		return disciplinaRepo.filtrarPorPalavraChave(filtro);
	}

}
