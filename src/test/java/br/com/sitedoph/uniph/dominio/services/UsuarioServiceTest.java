package br.com.sitedoph.uniph.dominio.services;

import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;

public class UsuarioServiceTest extends BaseTest {

	@Test
	public void deveFuncionarOService() {

		UsuarioService service = new UsuarioService();

		Usuario user = Fixture.from(Usuario.class).gimme(VALID);

		Usuario buscarPorLoginESenha = service.buscarPorLoginESenha(user.getLogin(), user.getSenha());

		if (buscarPorLoginESenha != null) {
			service.excluir(buscarPorLoginESenha);
		}

		user = service.salvarOuAtualizar(user);

		for (Usuario usuario : service.buscarTodos()) {
			System.out.println(usuario);
		}
	}

}
