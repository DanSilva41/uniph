package br.com.sitedoph.uniph.dominio.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.dominio.repositorios.AlunoRepositorio;
import br.com.sitedoph.uniph.infraestrutura.persistencia.util.Transacional;

public class AlunoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AlunoRepositorio repo;

	public Aluno buscarPorId(Long id) {
		return repo.buscarPorId(id);
	}

	public Aluno buscarPorCPF(String cpf) {
		return repo.buscarPorCPF(cpf);
	}

	public List<Aluno> buscarTodos() {
		return repo.buscarTodos();
	}

	@Transacional
	public void excluir(Aluno aluno) {
		repo.excluir(aluno);
	}

	@Transacional
	public Aluno salvarOuAtualizar(Aluno aluno) {
		return repo.salvarOuAtualizar(aluno);
	}

	public List<Aluno> filtrarPorPalavraChave(String filtro) {
		return repo.filtrarPorPalavraChave(filtro);
	}

}
