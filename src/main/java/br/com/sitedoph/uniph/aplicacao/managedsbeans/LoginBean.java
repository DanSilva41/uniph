package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.dominio.services.UsuarioService;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(LoginBean.class);

	private Usuario usuario = new Usuario();

	@Inject
	UsuarioService usuarioService;

	private boolean logado;

	public String efetuarLogin() {
		String outcome = "login";

		Usuario existente = usuarioService.buscarPorLoginESenha(usuario.getLogin(), usuario.getSenha());

		if (existente != null && existente.getId() != null) {
			log.warn("Usuario > {} <  acessando o sistema", existente.getLogin());
			setLogado(true);

		} else {
			usuario = new Usuario();
			setLogado(false);

			FacesMessage msg = new FacesMessage("Usuário inexistente!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		return "usuarios";
	}

	public String efetuarLogout() {
		logado = false;
		usuario = new Usuario();

		return "login?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

}
