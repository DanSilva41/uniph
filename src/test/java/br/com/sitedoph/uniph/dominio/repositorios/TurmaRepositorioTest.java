package br.com.sitedoph.uniph.dominio.repositorios;

import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Turma;
import br.com.sitedoph.uniph.dominio.repositorio.TurmaRepositorio;

public class TurmaRepositorioTest {

	// @Test
	public void deveFuncionarRepositorio() {

		TurmaRepositorio repo = new TurmaRepositorio();

		Turma turma = new Turma();
		turma.setDescricao("A1");
		turma.setHorario("10h as 11h");
		turma.setDiasDaSemana("Quarta e Sexta");

		turma = repo.salvarOuAtualizar(turma);

		for (Turma turmaExibir : repo.buscarTodos()) {
			System.out.println(turmaExibir);
		}
	}
}
