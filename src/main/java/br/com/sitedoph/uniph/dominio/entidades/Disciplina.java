package br.com.sitedoph.uniph.dominio.entidades;

import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "TB_DISCIPLINA")
public class Disciplina {

	@Id
	@SequenceGenerator(name = "tb_disciplina_id_seq", sequenceName = "tb_disciplina_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_disciplina_id_seq")
	private Long id;

	@NotEmpty(message = "Preencha a descrição!")
	private String descricao;

	@ManyToOne
	private Professor professor;

	@Column(name = "carga_horaria")
	private String cargaHoraria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public String toString() {
		return "[DISCIPLINA]:" + (id != null ? "\nID = " + id + ";" : "")
				+ (descricao != null ? "\nDescrição = " + descricao + ";" : "")
				+ (professor != null ? "\nProfessor = " + professor + ";" : "")
				+ (cargaHoraria != null ? "\nCarga Horária = " + cargaHoraria + ";" : "");
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Disciplina that = (Disciplina) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
