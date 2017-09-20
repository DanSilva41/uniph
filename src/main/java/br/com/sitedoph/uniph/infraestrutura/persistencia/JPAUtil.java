package br.com.sitedoph.uniph.infraestrutura.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	//Criação de um EntityManagerFactory somente um vez;
	private static EntityManagerFactory emf =
					Persistence.createEntityManagerFactory("uniph");
	
	//Método a ser invocado
	public static EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
}
