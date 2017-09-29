package br.com.sitedoph.uniph.dominio.repositorios;

import java.util.List;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;

public interface UsuarioRepositorio {

	Usuario buscarPorId(Long id);
	
	Usuario buscarPorLoginESenha(String login, String senha);
	
	List<Usuario> buscarTodos();
	
	void excluir(Usuario usuario);
	
	Usuario salvarOuAtualizar(Usuario usuario);

}
