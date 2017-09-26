package br.com.sitedoph.uniph.tests;

import org.junit.BeforeClass;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * CreatedBy danilosilva
 */
public class BaseTest {
	protected static final String VALID = "valid";

	@BeforeClass
	public static void setUp() {
		FixtureFactoryLoader.loadTemplates("br.com.sitedoph.uniph.dominio.entidades.templateloader");
	}
}
