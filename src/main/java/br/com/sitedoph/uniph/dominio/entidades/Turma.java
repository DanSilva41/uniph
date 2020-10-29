package br.com.sitedoph.uniph.dominio.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "TB_TURMA")
public class Turma {

	@Id
	@SequenceGenerator(name = "tb_turma_id_seq", sequenceName = "tb_turma_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_turma_id_seq")
	private Integer id;

	@NotEmpty(message = "Preencha a descrição!")
	private String descricao;

	@Column(name = "dias_da_semanda")
	private String diasDaSemana;

	private String horario;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "TB_TURMA_ALUNO", joinColumns = @JoinColumn(name = "id_turma"), inverseJoinColumns = @JoinColumn(name = "id_aluno"))
	private List<Aluno> alunos = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "TB_TURMA_DISCIPLINA", joinColumns = @JoinColumn(name = "id_turma"), inverseJoinColumns = @JoinColumn(name = "id_disciplina"))
	private List<Disciplina> disciplinas = new ArrayList<>();

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
	public String toString() {
		return "[TURMA]:" + (id != null ? "\nID = " + id + ";" : "")
				+ (descricao != null ? "\nDescrição = " + descricao + ";" : "")
				+ (diasDaSemana != null ? "\nDIas da semanda = " + diasDaSemana + ";" : "")
				+ (horario != null ? "\nHorário = " + horario + ";" : "")
				+ (alunos != null ? "\nAlunos = " + alunos + ";" : "")
				+ (disciplinas != null ? "\nDisciplinas = " + disciplinas + ";" : "");
	}
}
