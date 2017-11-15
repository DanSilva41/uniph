package br.com.sitedoph.uniph.dominio.repositorios;

import java.io.Serializable;
import java.util.List;

import br.com.sitedoph.uniph.dominio.entidades.Turma;

public interface TurmaRepositorio extends Serializable {

	Turma buscarPorId(Long id);

	List<Turma> buscarTodos();

	void excluir(Turma turma);

	Turma salvarOuAtualizar(Turma turma);

	List<Turma> filtrarPorPalavraChave(String filtro);

}
