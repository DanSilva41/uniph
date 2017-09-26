package br.com.sitedoph.uniph.dominio.repositorios;

import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Disciplina;
import br.com.sitedoph.uniph.dominio.repositorio.DisciplinaRepositorio;

public class DisciplinaRepositorioTest {
	
	//@Test
	public void deveFuncionarRepositorio() {
		
		DisciplinaRepositorio repo = new DisciplinaRepositorio();
		
		Disciplina disciplina = new Disciplina();
		disciplina.setDescricao("Java Web");
		disciplina.setCargaHoraria("20h");
		
		disciplina = repo.salvarOuAtualizar(disciplina);
		
		for (Disciplina disciplinaExibir : repo.buscarTodos()) {
			System.out.println(disciplinaExibir);
		}
	}
}
