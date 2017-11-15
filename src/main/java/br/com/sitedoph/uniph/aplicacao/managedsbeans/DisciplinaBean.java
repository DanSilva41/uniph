package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.dominio.entidades.Professor;
import br.com.sitedoph.uniph.dominio.services.DisciplinaService;
import br.com.sitedoph.uniph.dominio.services.ProfessorService;

@Named
@ViewScoped
public class DisciplinaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DisciplinaService disciplinaService;

	@Inject
	private ProfessorService professorService;

	private Disciplina disciplina = new Disciplina();
	private List<Disciplina> disciplinas;

	private Collection<Professor> professores;
	private String filtro;

	public void salvar() {

		boolean edicao = disciplina.getId() != null;

		disciplinaService.salvarOuAtualizar(disciplina);
		limpar();
		disciplinas = disciplinaService.buscarTodos();

		FacesMessage msg;
		if (edicao) {
			msg = new FacesMessage("Disciplina alterada com sucesso!");
		} else {
			msg = new FacesMessage("Disciplina cadastrada com sucesso!");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public void remover(Disciplina disciplina) {
		disciplinaService.excluir(disciplina);
		disciplinas = disciplinaService.buscarTodos();

		FacesMessage msg = new FacesMessage("Disciplina removida com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void filtrar() {
		this.disciplinas = disciplinaService.filtrarPorPalavraChave(filtro);
	}

	public void limpar() {
		this.disciplina = new Disciplina();

	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Collection<Disciplina> getDisciplinas() {

		if (disciplinas == null) {
			disciplinas = disciplinaService.buscarTodos();
		}

		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Collection<Professor> getProfessores() {

		if (professores == null) {
			professores = professorService.buscarTodos();
		}

		return professores;
	}

	public void setProfessores(Collection<Professor> professores) {
		this.professores = professores;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
