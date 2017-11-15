package br.com.sitedoph.uniph.dominio.repositorios;

import java.io.Serializable;
import java.util.List;

import br.com.sitedoph.uniph.dominio.entidades.Professor;

public interface ProfessorRepositorio extends Serializable {

	Professor buscarPorId(Long id);

	List<Professor> buscarTodos();

	void excluir(Professor professor);

	Professor salvarOuAtualizar(Professor professor);

	List<Professor> filtrarPorPalavraChave(String filtro);

}
