package br.com.sitedoph.uniph.dominio.entidades;

import java.util.Calendar;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "TB_PROFESSOR")
public class Professor {

	@Id
	@SequenceGenerator(name = "tb_professor_id_seq", sequenceName = "tb_professor_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_professor_id_seq")
	private Long id;

	@NotEmpty(message = "Preencha o nome completo!")
	@Size(min = 5)
	private String nomeCompleto;

	@CPF(message = "CPF inválido")
	private String cpf;

	private String telefone;

	@NotEmpty(message = "Preencha o e-mail!")
	@Email(message = "Endereço de e-mail inválido")
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;

	@Column(length = 5000)
	private String curriculo;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}

	@Override
	public String toString() {
		return "[PROFESSOR]:" + (id != null ? "\nID = " + id + ";" : "")
				+ (nomeCompleto != null ? "\nNome = " + nomeCompleto + ";" : "")
				+ (cpf != null ? "\nCPF = " + cpf + ";" : "")
				+ (dataCadastro != null ? "\nDt Cadastro = " + dataCadastro + ";" : "")
				+ (telefone != null ? "\nTelefone = " + telefone + ";" : "")
				+ (email != null ? "\nE-mail = " + email + ";" : "")
				+ (curriculo != null ? "\nCurrículo = " + curriculo + ";" : "");
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Professor professor = (Professor) o;
		return Objects.equals(id, professor.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
