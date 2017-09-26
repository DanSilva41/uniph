package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import java.util.Collection;

import javax.faces.bean.ManagedBean;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.dominio.services.UsuarioService;

@ManagedBean
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private Collection<Usuario> usuarios;

	private UsuarioService service = new UsuarioService();

	public void gravar() {

		System.out.println(usuario);

		service.salvarOuAtualizar(usuario);
		usuario = new Usuario();
		// Atribuindo à lista de UsuarioBean
		usuarios = service.buscarTodos();
	}

	public void remover(Usuario usuario) {

		System.out.println(usuario);

		service.excluir(usuario);
		usuarios = service.buscarTodos();
	}

	public Collection<Usuario> getUsuarios() {

		if (usuarios == null) {
			usuarios = service.buscarTodos();
		}

		return usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
