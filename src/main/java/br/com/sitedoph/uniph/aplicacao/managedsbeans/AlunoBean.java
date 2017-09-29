package br.com.sitedoph.uniph.aplicacao.managedsbeans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang.time.DateUtils;

import br.com.sitedoph.uniph.dominio.entidades.Aluno;
import br.com.sitedoph.uniph.dominio.services.AlunoService;

@Named
@ManagedBean
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private AlunoService alunoService;

	private Aluno aluno = new Aluno();
	private List<Aluno> alunos;

	private Date dataUtilCadastro = new Date();
	private Date dataUtilNascimento;

	public void salvar() {
		boolean edicao = aluno.getId() != null;

		aluno.setDataDeCadastro(DateUtils.toCalendar(dataUtilCadastro));
		aluno.setDataDeNascimento(DateUtils.toCalendar(dataUtilNascimento));

		alunoService.salvarOuAtualizar(aluno);
		aluno = new Aluno();
		alunos = alunoService.buscarTodos();

		FacesMessage mensagem;
		if (edicao) {
			mensagem = new FacesMessage("Aluno alterado com sucesso!");
		} else {
			mensagem = new FacesMessage("Aluno cadastrado com sucesso!");
		}

		FacesContext.getCurrentInstance().addMessage(null, mensagem);
	}

	public void remover(Aluno aluno) {
		alunoService.excluir(aluno);
		alunos = alunoService.buscarTodos();

		FacesMessage msg = new FacesMessage("Aluno excluído com sucesso!");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void limpar() {
		this.aluno = new Aluno();
	}

	public Collection<Aluno> getAlunos() {
		if (alunos == null) {
			alunos = alunoService.buscarTodos();
		}

		return alunos;
	}

	public Aluno getAluno() {

		if (aluno.getDataDeCadastro() != null) {
			dataUtilCadastro = aluno.getDataDeCadastro().getTime();
		}

		if (aluno.getDataDeNascimento() != null) {
			dataUtilNascimento = aluno.getDataDeNascimento().getTime();
		}

		return aluno;
	}

	public Date getDataUtilCadastro() {
		return dataUtilCadastro;
	}

	public void setDataUtilCadastro(Date dataUtilCadastro) {
		this.dataUtilCadastro = dataUtilCadastro;
	}

	public Date getDataUtilNascimento() {
		return dataUtilNascimento;
	}

	public void setDataUtilNascimento(Date dataUtilNascimento) {
		this.dataUtilNascimento = dataUtilNascimento;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
