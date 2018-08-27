package br.com.cadastrobeneficios.bean;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.cadastrobeneficios.dao.UsuarioDAO;
import br.com.cadastrobeneficios.domain.Usuario;
import br.com.cadastrobeneficios.util.FacesUtil;

@SuppressWarnings("deprecation")
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
				FacesUtil.adiconarMensagemErro("Login e/ou senha inv�lidos.");
				return null;
			} else {
				if (usuarioLogado != null) {
					getSession().setAttribute("usuario", usuarioLogado);
				}
				FacesUtil.adicionarMensagemInfo("Usu�rio autenticado com sucesso.");
				return "/pages/principal.xhtml?faces-redirect=true";
			}
		} catch (RuntimeException e) {
			FacesUtil.adiconarMensagemErro("Erro ao tentar Autenticar no Sistema: " + e.getMessage());
			return null;
		}
	}

	public String sair() {
		// Gera o contexto da aplica��o
		FacesContext context = FacesContext.getCurrentInstance();
		// Verifica a sess�o e a grava na vari�vel
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		// Fecha/Destroi a sess�o
		session.invalidate();
		FacesUtil.adicionarMensagemInfo("Usu�rio deslogado com sucesso.");
		return "/pages/autenticacao.xhtml?faces-redirect=true";
	}

	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public HttpSession getSession() {
		return (HttpSession) getFacesContext().getExternalContext().getSession(false);
	}

}
