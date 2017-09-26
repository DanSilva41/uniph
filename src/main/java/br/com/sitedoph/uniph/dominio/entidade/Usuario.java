package br.com.sitedoph.uniph.dominio.entidade;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable{

	/**
	 * The Constant serialVersionUID
	 */
	private static final long serialVersionUID = -162222018784333347L;

	/**
	 * The id
	 */
	@Id
	@GeneratedValue
	private Long id;
	
	/**
	 * The nome completo
	 */
	@NotBlank(message = "O nome não pode estar vazio")
	@Size(min = 5, message = "O nome deve ter ao"
						+ "menos 5 caracteres ")
	private String nomeCompleto;

	/**
	 * The email
	 */
	@Email(message = "E-mail inválido")
	@NotBlank(message = "É necessário um " + "endereço de e-mail")
	@Column(unique = true)
	private String email;

	/**
	 * The login
	 */
	@NotBlank(message = "Login obrigatório")
	@Size(min = 3, message = "O login deve ter ao"
						+ "menos 3 caracteres ")
	private String login;
	
	/**
	 * The senha	
	 */
	@NotBlank(message = "A senha não pode estar em branco")
	@Size(min = 5, message = "A senha deve ter pelo"
						+ "menos 5 caracteres ")
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
	public String toString() {
		return "[USUARIO]:" + (id != null ? "\nID = " + id + ";" : "")
				+ (nomeCompleto != null ? "\nNome = " + nomeCompleto + ";" : "")
				+ (email != null ? "\nE-mail = " + email + ";" : "") + (login != null ? "\nLogin = " + login + ";" : "")
				+ (senha != null ? "\nSenha = " + senha + ";" : "");
	}
}
