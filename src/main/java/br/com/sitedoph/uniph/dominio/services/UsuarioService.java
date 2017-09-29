package br.com.sitedoph.uniph.dominio.services;

import java.util.List;

import javax.inject.Inject;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.dominio.repositorios.UsuarioRepositorio;

public class UsuarioService {

	@Inject
	private UsuarioRepositorio repo;
	
	public Usuario buscarPorId(final Long id) {
		return repo.buscarPorId(id);
	}
	
	public Usuario buscarPorLoginESenha(String login, String senha) {
		return repo.buscarPorLoginESenha(login, senha);
	}
	
	public List<Usuario> buscarTodos() {
		return repo.buscarTodos();
	}
	
	public void excluir(Usuario usuario) {
		repo.excluir(usuario);
	}
	
	public Usuario salvarOuAtualizar(Usuario usuario) {
		return repo.salvarOuAtualizar(usuario);
	}
	
}
