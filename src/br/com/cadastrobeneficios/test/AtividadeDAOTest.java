package br.com.cadastrobeneficios.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.cadastrobeneficios.dao.AtividadeDAO;
import br.com.cadastrobeneficios.domain.Atividade;

public class AtividadeDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Atividade atividade = new Atividade();
		atividade.setNome("INCLUSÃO DIGITAL");

		AtividadeDAO atividadeDAO = new AtividadeDAO();
		atividadeDAO.salvar(atividade);

	}

	@Test
	@Ignore
	public void listar() {
		AtividadeDAO atividadeDAO = new AtividadeDAO();
		List<Atividade> atividades = atividadeDAO.listar();

		System.out.println(atividades);
	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		AtividadeDAO atividadeDAO = new AtividadeDAO();
		Atividade atividade = atividadeDAO.buscarPorCodigo(2L);

		System.out.println(atividade);
	}

	@Test
	@Ignore
	public void excluir() {
		AtividadeDAO atividadeDAO = new AtividadeDAO();
		Atividade atividade = atividadeDAO.buscarPorCodigo(8L);

		atividadeDAO.excluir(atividade);
	}

	@Test
	public void editar() {
		AtividadeDAO atividadeDAO = new AtividadeDAO();
		Atividade atividade = atividadeDAO.buscarPorCodigo(7L);
		
		atividade.setNome("INCLUSÃO DIGITAL");

		atividadeDAO.editar(atividade);
	}

}
