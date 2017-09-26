package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidade.Aluno;
import br.com.sitedoph.uniph.dominio.repositorio.AlunoRepositorio;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;

public class AlunoRepositorioTest extends BaseTest {
	
	// @Test
	public void deveFuncionarRepositorio(){
		
		AlunoRepositorio repo = new AlunoRepositorio();
		
		Aluno estudante = Fixture.from(Aluno.class).gimme(VALID);
		
		Aluno buscarPorCpf = repo.buscarPorCPF(estudante.getCpf());
		
		if(buscarPorCpf != null){
			repo.exluir(buscarPorCpf);
		}
		
		estudante = repo.salvarOuAtualizar(estudante);
		
		for(Aluno alunos : repo.buscarTodos()) {
			System.out.println(alunos);
		}
	}
}
