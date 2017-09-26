package br.com.sitedoph.uniph.infraestrutura.persistencia;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;

public class PersistenciaTest {

	// @Test
	public void deveCriarOEntityManagerFactoryEEntityManager() {

		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("uniph");

			EntityManager em = emf.createEntityManager();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	// @Test
	public void devePersistirUmAluno() {

		// Retorna um instância de EntityManager
		EntityManager em = JPAUtil.getEntityManager();

		Aluno dan = new Aluno();

		dan.setNomeCompleto("Danilo Silva");
		dan.setCpf("11111111111");
		dan.setDataDeNascimento(Calendar.getInstance());
		dan.setEmail("dan@mail.com");
		dan.setRg("1234567");
		dan.setTelefone("61982837464");

		em.getTransaction().begin();
		em.persist(dan);
		em.getTransaction().commit();

		// HQL

		Query query = em.createQuery("SELECT a FROM Aluno a");

		List<Aluno> lista = query.getResultList();

		for (Aluno a : lista) {
			System.out.println(a.getNomeCompleto());
		}

		em.close();
	}
}
