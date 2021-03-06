package br.com.sitedoph.uniph.dominio.repositorios;

import java.io.Serializable;
import java.util.List;

import br.com.sitedoph.uniph.dominio.entidades.Disciplina;

public interface DisciplinaRepositorio extends Serializable {

	Disciplina buscarPorId(Long id);

	List<Disciplina> buscarTodos();

	void excluir(Disciplina disciplina);

	Disciplina salvarOuAtualizar(Disciplina disciplina);

	List<Disciplina> filtrarPorPalavraChave(String filtro);

}
