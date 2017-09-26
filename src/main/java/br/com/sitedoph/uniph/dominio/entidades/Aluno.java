package br.com.sitedoph.uniph.dominio.entidades;

import java.util.Calendar;
import javax.persistence.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "TB_ALUNO")
public class Aluno {

	@Id
	@GeneratedValue
	private Long id;

	@NotBlank(message = "Preencha o nome completo!")
	private String nomeCompleto;

	private String rg;

	@CPF(message = "CPF inváĺido")
	@NotBlank(message = "Preencha o CPF!")
	private String cpf;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDeNascimento;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataDeCadastro;

	private String telefone;

	@NotBlank(message = "Preenche o e-mail!")
	@Email(message = "Endereço de e-mail inválido")
	private String email;

	@Enumerated(EnumType.ORDINAL)
	private Sexo sexo;

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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Calendar getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Calendar dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public Calendar getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Calendar dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
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

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "[ALUNO]:" + (id != null ? "\nID = " + id + ";" : "")
				+ (nomeCompleto != null ? "\nNome = " + nomeCompleto + ";" : "")
				+ (rg != null ? "\nRG = " + rg + ";" : "") + (cpf != null ? "\nCPF = " + cpf + ";" : "")
				+ (dataDeNascimento != null ? "\nDt de Nascimento = " + dataDeNascimento + ";" : "")
				+ (dataDeCadastro != null ? "\nDt de Cadastro = " + dataDeCadastro + ";" : "")
				+ (telefone != null ? "\nTelefone = " + telefone + ";" : "")
				+ (email != null ? "\nE-mail = " + email + ";" : "")
				+ (sexo != null ? "\nSexo = " + sexo.getDescricao() + ";" : "");
	}
}
