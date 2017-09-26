package br.com.sitedoph.uniph.dominio.repositorios;

import org.junit.Test;

import br.com.sitedoph.uniph.dominio.entidade.Usuario;
import br.com.sitedoph.uniph.dominio.repositorio.UsuarioRepositorio;

public class UsuarioRepositorioTest {

	private static final String LOGIN = "LOGAN";
	private static final String SENHA = "SENHAM";

	// @Test
	public void deveFuncionarORepositorio() {

		UsuarioRepositorio repo = new UsuarioRepositorio();

		Usuario buscarPorLoginESenha = repo.buscarPorLoginESenha(LOGIN, SENHA);

		if (buscarPorLoginESenha != null) {
			repo.excluir(buscarPorLoginESenha);
		}

		Usuario user = new Usuario();
		user.setLogin(LOGIN);
		user.setSenha(SENHA);

		user = repo.salvarOuAtualizar(user);

		for (Usuario usuario : repo.buscarTodos()) {
			System.out.println(usuario);
		}
	}

}
