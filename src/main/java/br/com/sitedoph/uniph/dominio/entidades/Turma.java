package br.com.sitedoph.uniph.dominio.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "TB_TURMA")
public class Turma {

	@Id
	@GeneratedValue
	private Integer id;
	private String descricao;
	private String diasDaSemana;
	private String horario;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Aluno> alunos;
	@ManyToMany(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SUBSELECT)
	private List<Disciplina> disciplinas;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDiasDaSemana() {
		return diasDaSemana;
	}

	public void setDiasDaSemana(String diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	@Override
	public String toString(){
		return "[TURMA]:" + (id != null ? "\nID = " + id + ";" : "") +
				(descricao != null ? "\nDescrição = " + descricao + ";" : "") +
				(diasDaSemana != null ? "\nDIas da semanda = " + diasDaSemana + ";" : "") +
				(horario != null ? "\nHorário = " + horario+ ";" : "") +
				(alunos != null ? "\nAlunos = " + alunos + ";" : "") +
				(disciplinas != null ? "\nDisciplinas = " + disciplinas + ";" : "");
	}
}
