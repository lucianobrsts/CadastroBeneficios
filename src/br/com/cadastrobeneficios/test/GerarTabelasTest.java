package br.com.cadastrobeneficios.test;

import org.junit.Test;

import br.com.cadastrobeneficios.util.HibernateUtil;

public class GerarTabelasTest {

	@Test
	public void gerar() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}

}
