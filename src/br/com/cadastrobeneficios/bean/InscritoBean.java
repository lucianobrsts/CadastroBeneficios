package br.com.cadastrobeneficios.bean;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.cadastrobeneficios.dao.InscritoDAO;
import br.com.cadastrobeneficios.domain.Inscrito;
import br.com.cadastrobeneficios.util.FacesUtil;

@ManagedBean
@ViewScoped
public class InscritoBean {
	private Inscrito inscritoCadastro;

	private List<Inscrito> listaInscritos;
	private List<Inscrito> listaInscritosFiltrados;

	private String acao;
	private Long codigo;

	public Inscrito getInscritoCadastro() {
		return inscritoCadastro;
	}

	public void setInscritoCadastro(Inscrito inscritoCadastro) {
		this.inscritoCadastro = inscritoCadastro;
	}

	public List<Inscrito> getListaInscritos() {
		return listaInscritos;
	}

	public void setListaInscritos(List<Inscrito> listaInscritos) {
		this.listaInscritos = listaInscritos;
	}

	public List<Inscrito> getListaInscritosFiltrados() {
		return listaInscritosFiltrados;
	}

	public void setListaInscritosFiltrados(List<Inscrito> listaInscritosFiltrados) {
		this.listaInscritosFiltrados = listaInscritosFiltrados;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public void novo() {
		inscritoCadastro = new Inscrito();
	}

	public void salvar() {
		try {
			InscritoDAO inscritoDAO = new InscritoDAO();
			inscritoDAO.salvar(inscritoCadastro);

			inscritoCadastro = new Inscrito();

			FacesUtil.adicionarMensagemInfo("Inscrito salvo com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar incluir um inscrito: " + ex.getMessage());
		}

	}

	public void carregarPesquisa() {
		try {
			InscritoDAO inscritoDAO = new InscritoDAO();
			listaInscritos = inscritoDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar listar os inscritos: " + ex.getMessage());
		}
	}

	public void carregarCadastro() {
		try {
			if (codigo != null) {
				InscritoDAO inscritoDAO = new InscritoDAO();
				inscritoCadastro = inscritoDAO.buscarPorCodigo(codigo);
			} else {
				inscritoCadastro = new Inscrito();
			}
		} catch (Exception ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar obter os dados do inscrito: " + ex.getMessage());
		}
	}

	public void excluir() {
		try {
			InscritoDAO inscritoDAO = new InscritoDAO();
			inscritoDAO.excluir(inscritoCadastro);

			FacesUtil.adicionarMensagemInfo("Inscrito excluído com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar excluir o inscrito: " + ex.getMessage());
		}
	}

	public void editar() {
		try {
			InscritoDAO inscritoDAO = new InscritoDAO();

			inscritoDAO.editar(inscritoCadastro);

			FacesUtil.adicionarMensagemInfo("Inscrito editado com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar editar o inscrito: " + ex.getMessage());
		}
	}

	public String calculaIdade() {
		String dtNasc = null;

		// Data atual
		GregorianCalendar atual = new GregorianCalendar();
		int diaAtual = atual.get(Calendar.DAY_OF_MONTH);
		int mesAtual = atual.get(Calendar.MONTH);
		int anoAtual = atual.get(Calendar.YEAR);

		// Data nascimento
		if (inscritoCadastro.getDataNascimento() != null) {
			dtNasc = inscritoCadastro.getDataNascimento();
		}
		int diaNasc = Integer.valueOf(dtNasc.substring(0, 2));
		int mesNasc = Integer.valueOf(dtNasc.substring(3, 5));
		int anoNasc = Integer.valueOf(dtNasc.substring(6, 10));

		// Idade
		int idade;

		if (mesNasc < mesAtual || (mesNasc == mesAtual && diaNasc <= diaAtual)) {
			idade = anoAtual - anoNasc;
		} else {
			idade = (anoAtual - anoNasc) - 1;
		}

		return String.valueOf(idade);
	}
}