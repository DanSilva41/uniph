package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sitedoph.uniph.dominio.entidades.Professor;
import br.com.sitedoph.uniph.dominio.services.ProfessorService;

@Named
@ViewScoped
public class ProfessorBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProfessorService professorService;

	private Professor professor = new Professor();
	private List<Professor> professores;

	private String filtro;

	public void salvar() {

		boolean edicao = professor.getId() != null;

		professorService.salvarOuAtualizar(professor);
		limpar();
		professores = professorService.buscarTodos();

		FacesMessage msg;
		if (edicao)
			msg = new FacesMessage("Professor alterado com sucesso!");
		else
			msg = new FacesMessage("Professor cadastrado com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void remover(Professor professor) {
		professorService.excluir(professor);
		professores = professorService.buscarTodos();

		FacesMessage msg = new FacesMessage("Professor excluído com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void filtrar() {
		this.professores = professorService.filtrarPorPalavraChave(filtro);
	}

	public void limpar() {
		this.professor = new Professor();
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Collection<Professor> getProfessores() {
		if (professores == null)
			professores = professorService.buscarTodos();
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
}
