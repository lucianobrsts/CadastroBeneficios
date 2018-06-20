package br.com.cadastrobeneficios.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.cadastrobeneficios.dao.UsuarioDAO;
import br.com.cadastrobeneficios.domain.Usuario;

public class UsuarioDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Usuario usuario = new Usuario();
		usuario.setNome("Admin");
		usuario.setSenha("123456");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
	}

}
