package br.com.sitedoph.uniph.dominio.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -162222018784333347L;

	/**
	 * The id
	 */
	@Id
	@SequenceGenerator(name = "tb_usuario_id_seq", sequenceName = "tb_usuario_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_usuario_id_seq")
	private Long id;

	/**
	 * The nome completo
	 */
	@NotBlank(message = "O nome não pode estar vazio")
	@Size(min = 5, max = 100, message = "O nome deve ter ao" + "menos 5 caracteres ")
	@Column(name = "nome_completo", length = 100)
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
	@Size(min = 3, message = "O login deve ter ao" + "menos 3 caracteres ")
	private String login;

	/**
	 * The senha
	 */
	@NotBlank(message = "A senha não pode estar em branco")
	@Size(min = 5, message = "A senha deve ter pelo" + "menos 5 caracteres ")
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
