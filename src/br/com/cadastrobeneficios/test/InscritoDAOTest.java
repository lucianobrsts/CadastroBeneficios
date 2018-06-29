package br.com.cadastrobeneficios.test;

import org.junit.Test;

import br.com.cadastrobeneficios.dao.InscritoDAO;

public class InscritoDAOTest {

	@Test
	public void buscarPorDataNascimento() {
		InscritoDAO inscritoDAO = new InscritoDAO();
		String dtNasc = inscritoDAO.buscarPorDataNascimento(11L);

		System.out.println(dtNasc);
	}

}
