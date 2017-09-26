package br.com.sitedoph.uniph.dominio.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "TB_DISCIPLINA")
public class Disciplina {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty(message = "Preencha a descrição!")
	private String descricao;
	
	@ManyToOne
	private Professor professor;
	
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
	public String toString(){
		return "[DISCIPLINA]:" + (id != null ? "\nID = " + id + ";" : "") +
				(descricao != null ? "\nDescrição = " + descricao + ";" : "") +
				(professor != null ? "\nProfessor = " + professor + ";" : "") +
				(cargaHoraria != null ? "\nCarga Horária = " + cargaHoraria + ";" : "");
	}

}

