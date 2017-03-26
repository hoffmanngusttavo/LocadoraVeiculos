package br.com.locadora.control;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import br.com.locadora.model.Cambio;
import br.com.locadora.model.Combustivel;
import br.com.locadora.model.TipoVeiculo;
import br.com.locadora.model.Veiculo;
import br.com.locadora.service.VeiculoService;
/**
 * @author Gustavo Hoffmann
 * Classe respons�vel por se comunicar com a camada view e de servi�o
 * */
@ManagedBean
@SessionScoped
public class VeiculoManagedBean extends AbstractManagedBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Veiculo entity;
	private int posicaoArray;
	private VeiculoService service;
	private List<Veiculo> veiculos;

	/**
	 * Construtor respons�vel por instanciar a classe de servi�o
	 * */
	public VeiculoManagedBean() {
		service = new VeiculoService();
	}

	/**
	 * M�todo invocado pela interface form.xhtml
	 * responsavel por identificar se est� criando um novo
	 * ou editando um ve�culo
	 * @return
	 * */
	public String doSaveVeiculo() {
		try {
			if (entity != null) {
				if (entity.getId() == null) {
					service.create(entity);
				} else {
					service.update(posicaoArray, entity);
				}
			}
			createFacesInfoMessage("Dados gravados com sucesso");
			veiculos = null;
			return "/index.xhtml";
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
			createFacesErrorMessage(e.getMessage());
		}
		return null;
	}

	/**
	 * M�todo invocado pela interface index.xhtml
	 * responsavel por instanciar um novo ve�culo
	 *  e redirecionar para o formul�rio
	 * @return
	 * */
	public String doStartCreate() {
		setEntity(new Veiculo());
		return "/form.xhtml";
	}

	/**
	 * M�todo invocado pela interface index.xhtml
	 * responsavel por carregar a posi��o do ve�culo
	 *  e redirecionar para a edi��o no  formul�rio
	 * @return
	 * */
	public String doStartUpdate() {
		try {
			String index = getRequestParam("indexVeiculo");
			if (index != null && !index.isEmpty()) {
				posicaoArray = Integer.parseInt(index);
				return "/form.xhtml";
			}
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
			createFacesErrorMessage(e.getMessage());
		}
		return null;
	}

	/**
	 * M�todo invocado pela interface index.xhtml
	 * responsavel por remover o ve�culo ap�s a confirma��o 
	 * do usu�rio 
	 * @return
	 * */
	public String doFinishDelete() {
		try {
			String index = getRequestParam("indexVeiculo");
			if (index != null && !index.isEmpty()) {
				posicaoArray = Integer.parseInt(index);
				service.delete(posicaoArray);
				createFacesInfoMessage("Ve�culo removido com sucesso");
				veiculos = null;
				return "/index.xhtml";
			}
		} catch (Exception e) {
			Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
			createFacesErrorMessage(e.getMessage());
		}
		return null;
	}

	/**
	 * M�todo respons�vel por carregar os ve�culos cadastrados na listagem
	 * @return
	 * */
	public List<Veiculo> getVeiculos() {
		if (veiculos == null) {
			veiculos = service.getVeiculos();
		}
		return veiculos;
	}

	/**
	 * M�todo respons�vel por carregar os tipos de ve�culos no formul�rio
	 * @return
	 * */
	public List<SelectItem> getComboTipoVeiculo() {
		List<SelectItem> itens = new ArrayList<SelectItem>();
		itens.add(new SelectItem(null, null));
		for (TipoVeiculo tipoVeiculo : TipoVeiculo.values()) {
			itens.add(new SelectItem(tipoVeiculo, tipoVeiculo.getLabel()));
		}
		return itens;
	}

	/**
	 * M�todo respons�vel por carregar os tipos de combust�veis no formul�rio
	 * @return
	 * */
	public List<SelectItem> getComboCombustivel() {
		List<SelectItem> itens = new ArrayList<SelectItem>();
		itens.add(new SelectItem(null, null));
		for (Combustivel combustivel : Combustivel.values()) {
			itens.add(new SelectItem(combustivel, combustivel.getLabel()));
		}
		return itens;
	}

	/**
	 * M�todo respons�vel por carregar os tipos de c�mbios no formul�rio
	 * @return
	 * */
	public List<SelectItem> getComboCambio() {
		List<SelectItem> itens = new ArrayList<SelectItem>();
		itens.add(new SelectItem(null, null));
		for (Cambio cambio : Cambio.values()) {
			itens.add(new SelectItem(cambio, cambio.getLabel()));
		}
		return itens;
	}

	public Veiculo getEntity() {
		return entity;
	}

	public void setEntity(Veiculo entity) {
		this.entity = entity;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}
