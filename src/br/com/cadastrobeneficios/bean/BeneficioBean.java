package br.com.cadastrobeneficios.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.cadastrobeneficios.dao.BeneficioDAO;
import br.com.cadastrobeneficios.domain.Beneficio;
import br.com.cadastrobeneficios.domain.Inscrito;
import br.com.cadastrobeneficios.util.FacesUtil;

@ManagedBean
@ViewScoped
public class BeneficioBean {
	private Beneficio beneficioCadastro;
	private List<Beneficio> listaBeneficios;
	private List<Inscrito> listaBeneficiosFiltrados;
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

	public List<Inscrito> getListaBeneficiosFiltrados() {
		return listaBeneficiosFiltrados;
	}

	public void setListaBeneficiosFiltrados(List<Inscrito> listaBeneficiosFiltrados) {
		this.listaBeneficiosFiltrados = listaBeneficiosFiltrados;
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
		} catch (Exception ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar obter os dados do Benef�cio: " + ex.getMessage());
		}
	}

	public void excluir() {
		try {
			BeneficioDAO beneficioDAO = new BeneficioDAO();
			beneficioDAO.excluir(beneficioCadastro);

			FacesUtil.adicionarMensagemInfo("Benef�cio exclu�do com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar excluir o Benef�cio: " + ex.getMessage());
		}
	}

	public void editar() {
		try {
			BeneficioDAO beneficioDAO = new BeneficioDAO();

			beneficioDAO.editar(beneficioCadastro);

			FacesUtil.adicionarMensagemInfo("Benef�cio editado com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar editar o Benef�cio: " + ex.getMessage());
		}
	}

}
