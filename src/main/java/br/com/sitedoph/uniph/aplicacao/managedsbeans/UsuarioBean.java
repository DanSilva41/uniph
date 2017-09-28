package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.dominio.services.UsuarioService;

@ViewScoped
@ManagedBean
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	private Collection<Usuario> usuarios;

	private UsuarioService service = new UsuarioService();

	public void gravar() {

		service.salvarOuAtualizar(usuario);
		limpar();
		usuarios = service.buscarTodos();
	}

	public void remover(Usuario usuario) {
		service.excluir(usuario);
		usuarios = service.buscarTodos();
	}

	public Collection<Usuario> getUsuarios() {

		if (usuarios == null) {
			usuarios = service.buscarTodos();
		}

		return usuarios;
	}

	public void limpar() {
		usuario = new Usuario();
	}

	public void cancelar() {
		limpar();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
