package br.com.cadastrobeneficios.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.cadastrobeneficios.dao.AtividadeDAO;
import br.com.cadastrobeneficios.dao.BeneficioDAO;
import br.com.cadastrobeneficios.dao.InscritoDAO;
import br.com.cadastrobeneficios.domain.Atividade;
import br.com.cadastrobeneficios.domain.Beneficio;
import br.com.cadastrobeneficios.domain.Inscrito;
import br.com.cadastrobeneficios.relatorio.Relatorio;
import br.com.cadastrobeneficios.util.FacesUtil;

@ManagedBean
@ViewScoped
public class BeneficioBean {
	private Beneficio beneficioCadastro;
	private List<Beneficio> listaBeneficios;
	private List<Inscrito> listaInscritosFiltrados;
	private List<Atividade> listaAtividadesFiltradas;
	private List<Beneficio> lista = new ArrayList<Beneficio>();
	private String acao;
	private Long codigo;

	public Beneficio getBeneficioCadastro() {
		return beneficioCadastro;
	}

	public void setBeneficioCadastro(Beneficio beneficioCadastro) {
		this.beneficioCadastro = beneficioCadastro;
	}

	public List<Beneficio> getListaBeneficios() {
		return listaBeneficios;
	}

	public void setListaBeneficios(List<Beneficio> listaBeneficios) {
		this.listaBeneficios = listaBeneficios;
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

	public List<Atividade> getListaAtividadesFiltradas() {
		return listaAtividadesFiltradas;
	}

	public void setListaAtividadesFiltradas(List<Atividade> listaAtividadesFiltradas) {
		this.listaAtividadesFiltradas = listaAtividadesFiltradas;
	}

	public List<Beneficio> getLista() {
		return lista;
	}

	public void setLista(List<Beneficio> lista) {
		this.lista = lista;
	}

	public void novo() {
		beneficioCadastro = new Beneficio();
	}

	public void salvar() {
		try {
			BeneficioDAO beneficioDAO = new BeneficioDAO();
			beneficioDAO.salvar(beneficioCadastro);

			beneficioCadastro = new Beneficio();

			FacesUtil.adicionarMensagemInfo("Beneficio salvo com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar incluir um Beneficio: " + ex.getMessage());
		}

	}

	public void carregarPesquisa() {
		try {
			BeneficioDAO beneficioDAO = new BeneficioDAO();
			listaBeneficios = beneficioDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar listar os Beneficios: " + ex.getMessage());
		}
	}

	public void carregarCadastro() {
		try {
			if (codigo != null) {
				BeneficioDAO beneficioDAO = new BeneficioDAO();
				beneficioCadastro = beneficioDAO.buscarPorCodigo(codigo);
			} else {
				beneficioCadastro = new Beneficio();
			}

			InscritoDAO inscritoDAO = new InscritoDAO();
			listaInscritosFiltrados = inscritoDAO.listar();

			AtividadeDAO atividadeDAO = new AtividadeDAO();
			listaAtividadesFiltradas = atividadeDAO.listar();
		} catch (Exception ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar obter os dados do Benefício: " + ex.getMessage());
		}
	}

	public void excluir() {
		try {
			BeneficioDAO beneficioDAO = new BeneficioDAO();
			beneficioDAO.excluir(beneficioCadastro);

			FacesUtil.adicionarMensagemInfo("Benefício excluído com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar excluir o Benefício: " + ex.getMessage());
		}
	}

	public void editar() {
		try {
			BeneficioDAO beneficioDAO = new BeneficioDAO();

			beneficioDAO.editar(beneficioCadastro);

			FacesUtil.adicionarMensagemInfo("Benefício editado com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar editar o Benefício: " + ex.getMessage());
		}
	}

	public void geraRelatorioAtividade() {
		Relatorio relatorio = new Relatorio();
		BeneficioDAO beneficioDAO = new BeneficioDAO();
		lista = beneficioDAO.listar();

		relatorio.getRelatorioComParam(lista);
	}

}
