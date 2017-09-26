package br.com.sitedoph.uniph.dominio.entidades;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.infraestrutura.validacao.util.ValidadorUtil;
import junit.framework.Assert;

public class UsuarioTest {
	
	//@Test
	public void deveValidar() {
		
		Validator validador = ValidadorUtil.getValidator();
		
		Usuario xpto = new Usuario();
		
		Set<ConstraintViolation<Usuario>> violacoes = validador.validate(xpto);
		
		for (ConstraintViolation<Usuario> constraintViolation : violacoes) {
			System.out.println(constraintViolation);
		}
		
		Assert.assertEquals(4, violacoes.size());
	}
}
