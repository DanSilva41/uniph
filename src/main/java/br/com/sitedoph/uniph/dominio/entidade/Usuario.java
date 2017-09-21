package br.com.sitedoph.uniph.dominio.entidade;

import javax.persistence.*;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

	@Id
	@GeneratedValue
	private Long id;
	private String nomeCompleto;
	
	@Column(unique = true)
	private String email;
	private String login;
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString(){
		return "[USUARIO]:" + (id != null ? "\nID = " + id + ";" : "") +
				(nomeCompleto != null ? "\nNome = " + nomeCompleto + ";" : "") +
				(email != null ? "\nE-mail = " + email + ";" : "") +
				(login != null ? "\nLogin = " + login + ";" : "") +
				(senha != null ? "\nSenha = " + senha + ";" : "");
	}
}

