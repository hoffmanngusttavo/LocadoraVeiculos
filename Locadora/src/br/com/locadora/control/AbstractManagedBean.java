package br.com.locadora.control;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Gustavo Hoffmann
 */
public class AbstractManagedBean implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	/**
	 * Método responsável por lançar mensagem de erro
	 * @param message
	 */
	protected void createFacesErrorMessage(String message) {
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}

	/**
	 * Método responsável por lançar mensagem de info
	 * @param message
	 */
	protected void createFacesInfoMessage(String message) {
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}

	/**
	 * Método responsável por lançar mensagem de aviso
	 * @param message
	 */
	protected void createFacesWarnMessage(String message) {
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, message, message);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}

	/**
	 * Método responsável por recuperar um parâmetro passado pela view
	 * @param param
	 * @return
	 */
	public String getRequestParam(String param) {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		return req.getParameter(param);
	}

}
