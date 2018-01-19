package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.dominio.entidades.Turma;
import br.com.sitedoph.uniph.dominio.services.AlunoService;
import br.com.sitedoph.uniph.dominio.services.DisciplinaService;
import br.com.sitedoph.uniph.dominio.services.TurmaService;

@Named
@ViewScoped
public class TurmaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TurmaService turmaService;

	@Inject
	private AlunoService alunoService;

	@Inject
	private DisciplinaService disciplinaService;

	private Turma turma = new Turma();
	private List<Turma> turmas;

	private DualListModel<Aluno> dualListAlunos;
	private List<Aluno> alunosRelacionados = new ArrayList<>();

	private List<Aluno> alunos;
	private List<Disciplina> disciplinas;

	private String filtro;

	public void salvar() {

		boolean edicao = turma.getId() != null;
		turma.setAlunos(dualListAlunos.getTarget());

		turmaService.salvarOuAtualizar(turma);
		limpar();
		turmas = turmaService.buscarTodos();

		FacesMessage msg;
		if (edicao)
			msg = new FacesMessage("Turma alterada com sucesso!");
		else
			msg = new FacesMessage("Turma cadastrada com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void remover(Turma turma) {
		turmaService.excluir(turma);
		turmas = turmaService.buscarTodos();

		FacesMessage msg = new FacesMessage("Turma excluída com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void filtrar() {
		this.turmas = turmaService.filtrarPorPalavraChave(filtro);
	}

	public void prepararPickList(Turma turma) {
		if (!turma.getAlunos().isEmpty())
			dualListAlunos.setTarget(turma.getAlunos());
	}

	public void limpar() {
		this.turma = new Turma();
	}

	public Collection<Turma> getTurmas() {
		if (turmas == null)
			turmas = turmaService.buscarTodos();

		return turmas;
	}

	public Turma getTurma() {

		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public String getFiltro() {
		return filtro;
	}

	public DualListModel<Aluno> getDualListAlunos() {
		if (this.dualListAlunos == null)
			this.dualListAlunos = new DualListModel<>(getAlunos(), alunosRelacionados);
		return dualListAlunos;
	}

	public List<Aluno> getAlunosRelacionados() {
		return alunosRelacionados;
	}

	public void setAlunosRelacionados(List<Aluno> alunosRelacionados) {
		this.alunosRelacionados = alunosRelacionados;
	}

	public void setDualListAlunos(DualListModel<Aluno> dualListAlunos) {
		this.dualListAlunos = dualListAlunos;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<Aluno> getAlunos() {

		if (alunos == null)
			alunos = alunoService.buscarTodos();

		return alunos;
	}

	public List<Disciplina> getDisciplinas() {

		if (disciplinas == null)
			disciplinas = disciplinaService.buscarTodos();

		return disciplinas;
	}

}
