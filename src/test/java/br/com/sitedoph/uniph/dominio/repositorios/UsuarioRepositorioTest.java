package br.com.sitedoph.uniph.dominio.repositorios;

import br.com.sitedoph.uniph.dominio.entidades.Usuario;
import br.com.sitedoph.uniph.tests.BaseTest;
import br.com.six2six.fixturefactory.Fixture;

public class UsuarioRepositorioTest extends BaseTest {

	//@Test
	public void deveFuncionarORepositorio() {

		UsuarioRepositorio repo = new UsuarioRepositorio();

		Usuario user = Fixture.from(Usuario.class).gimme(VALID);
		Usuario buscarPorLoginESenha = repo.buscarPorLoginESenha(user.getLogin(), user.getSenha());

		if (buscarPorLoginESenha != null) {
			repo.excluir(buscarPorLoginESenha);
		}

		user = repo.salvarOuAtualizar(user);

		for (Usuario usuario : repo.buscarTodos()) {
			System.out.println(usuario);
		}
	}

}
