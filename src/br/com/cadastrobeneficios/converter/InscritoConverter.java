package br.com.cadastrobeneficios.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.cadastrobeneficios.dao.InscritoDAO;
import br.com.cadastrobeneficios.domain.Inscrito;

@SuppressWarnings("rawtypes")
@FacesConverter("inscritoConverter")
public class InscritoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String valor) {
		try {
			Long codigo = Long.parseLong(valor);
			InscritoDAO inscritoDAO = new InscritoDAO();
			Inscrito inscrito = inscritoDAO.buscarPorCodigo(codigo);
			return inscrito;
		} catch (RuntimeException ex) {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object objeto) {
		try {
			Inscrito inscrito = (Inscrito) objeto;
			Long codigo = inscrito.getCodigo();
			return codigo.toString();
		} catch (RuntimeException ex) {
			return null;
		}
	}

}
