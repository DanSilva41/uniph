package br.com.sitedoph.uniph.dominio.entidades;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import br.com.sitedoph.uniph.aplicacao.util.config.Formatador;

@Entity
@Table(name = "TB_ALUNO", schema = "dominio")
public class Aluno {

	public Aluno() {
		this.dataDeCadastro = LocalDate.now(Formatador.getZoneId());
	}

	@Id
	@SequenceGenerator(name = "tb_aluno_id_seq", sequenceName = "tb_aluno_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_aluno_id_seq")
	private Long id;

	@NotBlank(message = ": Preencha o nome completo!")
	private String nomeCompleto;

	private String rg;

	@CPF(message = ": Inváĺido")
	@NotBlank(message = ": Preencha o CPF!")
	private String cpf;

	private LocalDate dataDeNascimento;

	private LocalDate dataDeCadastro;

	private String telefone;

	@NotBlank(message = ": Preencha o e-mail!")
	@Email(message = ": Endereço de e-mail inválido")
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

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public LocalDate getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(LocalDate dataDeCadastro) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || this.getClass() != o.getClass())
			return false;
		Aluno aluno = (Aluno) o;
		return Objects.equals(this.id, aluno.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}

}
