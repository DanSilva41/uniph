package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import java.io.Serializable;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.validation.ConstraintViolationException;

import br.com.sitedoph.uniph.aplicacao.util.MensagensUtil;
import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.dominio.services.UsuarioService;

@ViewScoped
@ManagedBean
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	private Collection<Usuario> usuarios;

	public void gravar() {

		try {
			new UsuarioService().salvarOuAtualizar(usuario);
			limpar();
			usuarios = new UsuarioService().buscarTodos();
			MensagensUtil.info("Usuário foi CADASTRADO com sucesso!");
		} catch (Exception e) {

			if (e.getCause() instanceof ConstraintViolationException) {

				MensagensUtil.adicionarMensagemDeValidacao((ConstraintViolationException) e.getCause());

			} else if (e.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {

				MensagensUtil.error("Login ou endereço de e-mail em uso!");

			} else {
				throw e;
			}
		}
	}

	public void remover(Usuario usuario) {
		new UsuarioService().excluir(usuario);
		usuarios = new UsuarioService().buscarTodos();
	}

	public Collection<Usuario> getUsuarios() {

		if (usuarios == null) {
			usuarios = new UsuarioService().buscarTodos();
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
