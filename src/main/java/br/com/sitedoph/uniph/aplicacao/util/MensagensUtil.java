package br.com.sitedoph.uniph.aplicacao.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

public class MensagensUtil {

	public static void adicionarMensagem(Severity severiryInfo, String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severiryInfo, mensagem, mensagem));
	}

	public static void adicionarMensagemDeValidacao(ConstraintViolationException e) {

		for (ConstraintViolation<?> violacao : e.getConstraintViolations()) {
			warning(violacao.getMessage());
		}
	}

	public static void info(String mensagem) {
		adicionarMensagem(FacesMessage.SEVERITY_INFO, mensagem);
	}

	public static void error(String mensagem) {
		adicionarMensagem(FacesMessage.SEVERITY_ERROR, mensagem);
	}

	public static void warning(String mensagem) {
		adicionarMensagem(FacesMessage.SEVERITY_WARN, mensagem);
	}
}