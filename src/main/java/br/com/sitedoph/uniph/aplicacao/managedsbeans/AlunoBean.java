package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.dominio.services.AlunoService;

@Named
@ViewScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AlunoService alunoService;

	private Aluno aluno = new Aluno();
	private List<Aluno> alunos;

	private String filtro = "";

	public void salvar() {
		boolean edicao = aluno.getId() != null;

		alunoService.salvarOuAtualizar(aluno);
		limpar();
		alunos = alunoService.buscarTodos();

		FacesMessage mensagem;
		if (edicao)
			mensagem = new FacesMessage("Aluno alterado com sucesso!");
		else
			mensagem = new FacesMessage("Aluno cadastrado com sucesso!");

		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	public void remover(Aluno aluno) {
		alunoService.excluir(aluno);
		alunos = alunoService.buscarTodos();

		FacesMessage msg = new FacesMessage("Aluno excluído com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void filtrar() {
		this.alunos = alunoService.filtrarPorPalavraChave(filtro);
	}

	public void limpar() {
		this.aluno = new Aluno();
	}

	public Collection<Aluno> getAlunos() {
		if (alunos == null)
			alunos = alunoService.buscarTodos();

		return alunos;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

}
