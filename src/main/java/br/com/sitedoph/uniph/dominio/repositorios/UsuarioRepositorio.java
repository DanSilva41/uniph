package br.com.sitedoph.uniph.dominio.repositorios;

import java.io.Serializable;
import java.util.List;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;

public interface UsuarioRepositorio extends Serializable {

	Usuario buscarPorId(Long id);
	
	Usuario buscarPorLoginESenha(String login, String senha);
	
	List<Usuario> buscarTodos();
	
	void excluir(Usuario usuario);
	
	Usuario salvarOuAtualizar(Usuario usuario);

}
