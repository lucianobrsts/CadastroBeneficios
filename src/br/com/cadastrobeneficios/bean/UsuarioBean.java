package br.com.cadastrobeneficios.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.cadastrobeneficios.dao.UsuarioDAO;
import br.com.cadastrobeneficios.domain.Usuario;
import br.com.cadastrobeneficios.util.FacesUtil;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	private Usuario usuarioCadastro;

	private List<Usuario> listaUsuarios;
	private List<Usuario> listaUsuariosFiltrados;

	private String acao;
	private Long codigo;

	public Usuario getUsuarioCadastro() {
		return usuarioCadastro;
	}

	public void setUsuarioCadastro(Usuario usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<Usuario> getListaUsuariosFiltrados() {
		return listaUsuariosFiltrados;
	}

	public void setListaUsuariosFiltrados(List<Usuario> listaUsuariosFiltrados) {
		this.listaUsuariosFiltrados = listaUsuariosFiltrados;
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
		usuarioCadastro = new Usuario();
	}

	public void salvar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.salvar(usuarioCadastro);

			usuarioCadastro = new Usuario();

			FacesUtil.adicionarMensagemInfo("Usuário salvo com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar salvar um Usuário: " + ex.getMessage());
		}

	}

	public void carregarPesquisa() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			listaUsuarios = usuarioDAO.listar();
		} catch (Exception ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar listar os usuários: " + ex.getMessage());
		}
	}
	
	public void carregarCadastro() {
		try {
			if (codigo != null) {
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				usuarioCadastro = usuarioDAO.buscarPorCodigo(codigo);
			} else {
				usuarioCadastro = new Usuario();
			}
		} catch (Exception ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar obter os dados do Usuário: " + ex.getMessage());
		}
	}
	
	public void excluir() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.excluir(usuarioCadastro);

			FacesUtil.adicionarMensagemInfo("Usuário excluído com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar excluir o Usuário: " + ex.getMessage());
		}
	}

	public void editar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();

			usuarioDAO.editar(usuarioCadastro);

			FacesUtil.adicionarMensagemInfo("Usuário editado com sucesso!");
		} catch (RuntimeException ex) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar editar o Usuário: " + ex.getMessage());
		}
	}

}
