package br.com.sitedoph.uniph.aplicacao.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sitedoph.uniph.dominio.entidades.Disciplina;
import br.com.sitedoph.uniph.dominio.services.DisciplinaService;

/**
 *
 * @author Danilo Silva on 18/01/2018
 *
 */
@Named("disciplinaConverter")
public class DisciplinaConverter implements Converter {

	@Inject
	DisciplinaService disciplinaService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0)
			try {
				return disciplinaService.buscarPorId(Long.parseLong(value));
			} catch (NumberFormatException e) {
				throw new ConverterException(
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de conversão", "Disciplina inexistente."));
			}
		else
			return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object objeto) {
		if (objeto != null && objeto instanceof Disciplina)
			return String.valueOf(((Disciplina) objeto).getId());
		else
			return null;
	}

}
