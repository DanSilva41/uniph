package br.com.sitedoph.uniph.dominio.repositorios;

import java.util.Calendar;

import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Professor;
import br.com.sitedoph.uniph.dominio.repositorio.ProfessorRepositorio;

public class ProfessorRepositorioTest {
	
	private static final String CPF = "454.454.454.55";
	
	// @Test
	public void deveFuncionarRepositorio() {
		
		ProfessorRepositorio repo = new ProfessorRepositorio();
		
		Professor buscarPorCpf = repo.buscarPorCPF(CPF);
		
		if(buscarPorCpf != null) {
			repo.excluir(buscarPorCpf);
		}
		
		Professor teacher = new Professor();
		teacher.setNomeCompleto("Angilvado Correia");
		teacher.setEmail("angi@gmail.com");
		teacher.setDataCadastro(Calendar.getInstance());
		teacher.setCpf(CPF);
		
		teacher = repo.salvarOuAtualizar(teacher);
		
		for(Professor professor : repo.buscarTodos()){
			System.out.println(professor);
		}
	}
}
