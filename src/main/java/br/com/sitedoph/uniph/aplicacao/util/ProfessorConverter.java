package br.com.sitedoph.uniph.aplicacao.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sitedoph.uniph.dominio.entidades.Professor;
import br.com.sitedoph.uniph.dominio.services.ProfessorService;

/**
 *
 * @author Danilo Silva on 15/11/2017
 *
 */
@Named("professorConverter")
public class ProfessorConverter implements Converter<Object> {

	@Inject
	private ProfessorService professorService;

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0)
			try {
				return professorService.buscarPorId(Long.parseLong(value));
			} catch (NumberFormatException e) {
				throw new ConverterException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de Conversão", "Professor Inexistente."));
			}
		else
			return null;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null && object instanceof Professor)
			return String.valueOf(((Professor) object).getId());
		else
			return null;
	}

}
