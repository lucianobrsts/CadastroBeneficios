package br.com.cadastrobeneficios.util;

import javax.faces.application.Application;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.cadastrobeneficios.bean.AutenticacaoBean;
import br.com.cadastrobeneficios.domain.Usuario;

@SuppressWarnings("serial")
public class AutenticacaoPhaseListener implements PhaseListener {

	@Override
	public void afterPhase(PhaseEvent event) {
		AutenticacaoBean autenticacaoBean = new AutenticacaoBean();

		FacesContext facesContext = event.getFacesContext();
		UIViewRoot uiViewRoot = facesContext.getViewRoot();
		String paginaAtual = uiViewRoot.getViewId();

		boolean ehPaginaAutenticacao = paginaAtual.contains("autenticacao.xhtml");

		if (!ehPaginaAutenticacao) {

			Usuario usuario = (Usuario) autenticacaoBean.getSession().getAttribute("usuario");

			if (usuario == null) {
				FacesUtil.adicionarMensagemInfo("Usuário não autenticado. Faça o Login.");

				Application application = facesContext.getApplication();
				NavigationHandler navigationHandler = application.getNavigationHandler();
				navigationHandler.handleNavigation(facesContext, null, "/pages/autenticacao.xhtml?faces-redirect=true");
			}
		}

	}

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
