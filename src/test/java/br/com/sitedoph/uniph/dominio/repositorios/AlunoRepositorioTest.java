package br.com.sitedoph.uniph.dominio.repositorios;

import java.util.Calendar;

import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Aluno;
import br.com.sitedoph.uniph.dominio.entidade.Sexo;
import br.com.sitedoph.uniph.dominio.repositorio.AlunoRepositorio;

public class AlunoRepositorioTest {
	
	private static final String CPF = "888.888.888-88";
	
	// @Test
	public void deveFuncionarRepositorio(){
		
		AlunoRepositorio repo = new AlunoRepositorio();
		
		Aluno buscarPorCpf = repo.buscarPorCPF(CPF);
		
		if(buscarPorCpf != null){
			repo.exluir(buscarPorCpf);
		}
		
		Aluno student = new Aluno();
		student.setNomeCompleto("João Pedro Silva");
		student.setEmail("joam@gmail.com");
		student.setDataDeNascimento(Calendar.getInstance());
		student.setSexo(Sexo.MASCULINO);
		
		student = repo.salvarOuAtualizar(student);
		
		for(Aluno alunos : repo.buscarTodos()) {
			System.out.println(alunos);
		}
	}
}
