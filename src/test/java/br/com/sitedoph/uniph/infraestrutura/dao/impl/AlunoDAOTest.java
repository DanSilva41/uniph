package br.com.sitedoph.uniph.infraestrutura.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.sitedoph.uniph.dominio.entidade.Aluno;
import br.com.sitedoph.uniph.dominio.entidade.Sexo;
import br.com.sitedoph.uniph.infraestrutura.persistencia.JPAUtil;

public class AlunoDAOTest {
	
	private static final String CPF = "999.999.999-99";
	
	//@Test
	public void deveFazerCRUDDeAluno(){
		
		EntityManager em = JPAUtil.getEntityManager();
		
		AlunoDAO dao = new AlunoDAO(em);
							// Utilizando método buscarPorExemplo de GenericDAOHibernate
		Aluno alunoPorCPF = dao.buscarCPF(CPF);
		
		em.getTransaction().begin();
		if (alunoPorCPF != null) {
			// Utilizando método excluir
			dao.excluir(alunoPorCPF);
		}
		em.getTransaction().commit();
		
		Aluno ph = new Aluno();
		
		ph.setEmail("ph@gmail.com");
		ph.setCpf(CPF);
		ph.setNomeCompleto("Palerique");
		ph.setTelefone("999999999");
		ph.setRg("7.897.889");
		ph.setDataDeCadastro(Calendar.getInstance());
		ph.setDataDeNascimento(Calendar.getInstance());
		ph.setSexo(Sexo.MASCULINO);
		
		em.getTransaction().begin();
		
		// Utilizando método salvarOuAtualizar
		ph = dao.salvarOuAtualizar(ph);
		
		em.getTransaction().commit();
		
		// Aluno buscarPorId = dao.buscarPorId(ph.getId());
		
								// Utilizando método buscarTodos
		List<Aluno> buscarTodos = dao.buscarTodos();
		
		for(Aluno aluno : buscarTodos) {
			System.out.println(aluno);
		}
		
		em.close();
	}
}
