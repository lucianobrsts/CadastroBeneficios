package br.com.cadastrobeneficios.test;

import org.junit.Test;

import br.com.cadastrobeneficios.util.HibernateUtil;
import jdk.nashorn.internal.ir.annotations.Ignore;

public class GerarTabelasTest {

	@Test
	@Ignore
	public void gerar() {
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}

}
