package br.com.sitedoph.uniph.dominio.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.sitedoph.uniph.dominio.entidades.Turma;
import br.com.sitedoph.uniph.dominio.repositorios.TurmaRepositorio;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.Transacional;

public class TurmaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TurmaRepositorio turmaRepo;

	public Turma buscarPorId(Long id) {
		return turmaRepo.buscarPorId(id);
	}

	public List<Turma> buscarTodos() {
		return turmaRepo.buscarTodos();
	}

	@Transacional
	public void excluir(Turma turma) {
		turmaRepo.excluir(turma);
	}

	@Transacional
	public Turma salvarOuAtualizar(Turma turma) {
		return turmaRepo.salvarOuAtualizar(turma);
	}

	public List<Turma> filtrarPorPalavraChave(String filtro) {
		return turmaRepo.filtrarPorPalavraChave(filtro);
	}

}
