package br.com.cadastrobeneficios.test;

import br.com.cadastrobeneficios.bean.InscritoBean;

public class CalculaIdadeTest {

	public static void main(String[] args) {
		InscritoBean bean = new InscritoBean();

		String data = bean.getInscritoCadastro().getNascimento();

		System.out.println(data);

	}

}
