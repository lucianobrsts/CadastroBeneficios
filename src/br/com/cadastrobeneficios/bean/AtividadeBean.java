package br.com.cadastrobeneficios.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.cadastrobeneficios.dao.AtividadeDAO;
import br.com.cadastrobeneficios.domain.Atividade;
import br.com.cadastrobeneficios.util.FacesUtil;

@ManagedBean
@ViewScoped
public class AtividadeBean {
	private Atividade atividadeCadastro;
	private List<Atividade> listaAtividades;
	private List<Atividade> listaAtividadesFiltrados;
	private String acao;
	private Long codigo;

	public Atividade getAtividadeCadastro() {
		return atividadeCadastro;
	}

	public void setAtividadeCadastro(Atividade atividadeCadastro) {
		this.atividadeCadastro = atividadeCadastro;
	}

	public List<Atividade> getListaAtividades() {
		return listaAtividades;
	}

	public void setListaAtividades(List<Atividade> listaAtividades) {
		this.listaAtividades = listaAtividades;
	}

	public List<Atividade> getListaAtividadesFiltrados() {
		return listaAtividadesFiltrados;
	}

	public void setListaAtividadesFiltrados(List<Atividade> listaAtividadesFiltrados) {
		this.listaAtividadesFiltrados = listaAtividadesFiltrados;
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
		atividadeCadastro = new Atividade();
	}

	public void salvar() {
		try {
			AtividadeDAO atividadeDAO = new AtividadeDAO();
			atividadeDAO.salvar(atividadeCadastro);

			atividadeCadastro = new Atividade();

			FacesUtil.adicionarMensagemInfo("Atividade salva com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar incluir uma Atividade: " + ex.getMessage());
		}

	}

	public void carregarPesquisa() {
		try {
			AtividadeDAO atividadeDAO = new AtividadeDAO();
			listaAtividades = atividadeDAO.listar();
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar listar as atividades: " + ex.getMessage());
		}
	}

	public void carregarCadastro() {
		try {
			acao = FacesUtil.getParam("atividadeAcao");

			if (codigo != null) {
				AtividadeDAO atividadeDAO = new AtividadeDAO();
				atividadeCadastro = atividadeDAO.buscarPorCodigo(codigo);
			} else {
				atividadeCadastro = new Atividade();
			}
		} catch (Exception ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar obter os dados da atividade: " + ex.getMessage());
		}
	}

	public void excluir() {
		try {
			AtividadeDAO atividadeDAO = new AtividadeDAO();
			atividadeDAO.excluir(atividadeCadastro);

			FacesUtil.adicionarMensagemInfo("Atividade excluída com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar excluir a atividade: " + ex.getMessage());
		}
	}

	public void editar() {
		try {
			AtividadeDAO atividadeDAO = new AtividadeDAO();

			atividadeDAO.editar(atividadeCadastro);

			FacesUtil.adicionarMensagemInfo("Atividade editada com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar editar a atividade: " + ex.getMessage());
		}
	}

}
