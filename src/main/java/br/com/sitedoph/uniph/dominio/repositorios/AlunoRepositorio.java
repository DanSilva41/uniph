package br.com.sitedoph.uniph.dominio.repositorios;

import java.io.Serializable;
import java.util.List;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;

public interface AlunoRepositorio extends Serializable {

	Aluno buscarPorId(Long id);
	
	Aluno buscarPorCPF(String cpf);
	
	List<Aluno> buscarTodos();
	
	void excluir(Aluno aluno);
	
	Aluno salvarOuAtualizar(Aluno aluno);

}
