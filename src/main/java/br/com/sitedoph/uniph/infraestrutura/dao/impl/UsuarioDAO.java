package br.com.sitedoph.uniph.infraestrutura.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.infraestrutura.dao.GenericDAO;

public class UsuarioDAO {

	private final GenericDAO<Usuario, Long> DAO;

	public UsuarioDAO(EntityManager entityManager) {

		DAO = new GenericDAOHibernate<>(entityManager, Usuario.class);

	}

	public Usuario buscarPorId(Long id) {
		return DAO.buscarPorId(id);
	}

	public Usuario buscarPorLoginESenha(String login, String senha) {

		Usuario exemplo = new Usuario();
		exemplo.setLogin(login);
		exemplo.setSenha(senha);

		List<Usuario> lista = DAO.buscarPorExemplo(exemplo);

		if (lista != null && !lista.isEmpty()) {
			return lista.get(0);
		} else {
			return null;
		}
	}

	public List<Usuario> buscarTodos() {
		return DAO.buscarTodos();
	}

	public void excluir(Usuario usuario) {
		DAO.excluir(usuario);
	}

	public Usuario salvarOuAtualizar(Usuario usuario) {
		return DAO.salvarOuAtualizar(usuario);
	}
}
