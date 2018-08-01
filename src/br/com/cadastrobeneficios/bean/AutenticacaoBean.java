package br.com.cadastrobeneficios.bean;

import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;

import br.com.cadastrobeneficios.dao.UsuarioDAO;
import br.com.cadastrobeneficios.domain.Usuario;
import br.com.cadastrobeneficios.util.FacesUtil;

@ManagedBean
@SessionScoped
public class AutenticacaoBean {
	private Usuario usuarioLogado;

	public Usuario getUsuarioLogado() {
		if (usuarioLogado == null) {
			usuarioLogado = new Usuario();
		}
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public String autenticar() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioLogado = usuarioDAO.autenticar(usuarioLogado.getLogin(), usuarioLogado.getSenha());
			if (usuarioLogado == null) {
				FacesUtil.adiconarMensagemErro("Login e/ou senha inválidos.");
				return null;
			} else {
				FacesUtil.adicionarMensagemInfo("Usuário autenticado com sucesso.");
				return "/pages/principal.xhtml?faces-redirect=true";
			}
		} catch (RuntimeException e) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar Autenticar no Sistema: " + e.getMessage());
			return null;
		}
	}
	
	public String sair() {
		usuarioLogado = null;
		FacesUtil.adicionarMensagemInfo("Usuário deslogado com sucesso.");
		return "/pages/autenticacao.xhtml?faces-redirect=true";
	}
}
