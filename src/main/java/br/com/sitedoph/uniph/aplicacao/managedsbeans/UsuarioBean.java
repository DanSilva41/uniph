package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.dominio.services.UsuarioService;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;

	private Usuario usuario = new Usuario();

	public void salvar() {
		usuarioService.salvarOuAtualizar(usuario);
		usuario = new Usuario();

		FacesMessage mensagem = new FacesMessage("Usuári cadastrado com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
