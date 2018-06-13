package br.com.cadastrobeneficios.bean;

import java.util.List;

import br.com.cadastrobeneficios.dao.InscritoDAO;
import br.com.cadastrobeneficios.dao.UsuarioDAO;
import br.com.cadastrobeneficios.domain.Inscrito;
import br.com.cadastrobeneficios.domain.Usuario;
import br.com.cadastrobeneficios.util.FacesUtil;

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
			FacesUtil.adiconarMensagemErro("Erro ao tentar incluir um Usuário: " + ex.getMessage());
		}

	}

}
