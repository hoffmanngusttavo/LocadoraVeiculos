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
 * Classe responsável por se comunicar com a camada view e de serviço
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
	 * Construtor responsável por instanciar a classe de serviço
	 * */
	public VeiculoManagedBean() {
		service = new VeiculoService();
	}

	/**
	 * Método invocado pela interface form.xhtml
	 * responsavel por identificar se está criando um novo
	 * ou editando um veículo
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
	 * Método invocado pela interface index.xhtml
	 * responsavel por instanciar um novo veículo
	 *  e redirecionar para o formulário
	 * @return
	 * */
	public String doStartCreate() {
		setEntity(new Veiculo());
		return "/form.xhtml";
	}

	/**
	 * Método invocado pela interface index.xhtml
	 * responsavel por carregar a posição do veículo
	 *  e redirecionar para a edição no  formulário
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
	 * Método invocado pela interface index.xhtml
	 * responsavel por remover o veículo após a confirmação 
	 * do usuário 
	 * @return
	 * */
	public String doFinishDelete() {
		try {
			String index = getRequestParam("indexVeiculo");
			if (index != null && !index.isEmpty()) {
				posicaoArray = Integer.parseInt(index);
				service.delete(posicaoArray);
				createFacesInfoMessage("Veículo removido com sucesso");
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
	 * Método responsável por carregar os veículos cadastrados na listagem
	 * @return
	 * */
	public List<Veiculo> getVeiculos() {
		if (veiculos == null) {
			veiculos = service.getVeiculos();
		}
		return veiculos;
	}

	/**
	 * Método responsável por carregar os tipos de veículos no formulário
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
	 * Método responsável por carregar os tipos de combustíveis no formulário
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
	 * Método responsável por carregar os tipos de câmbios no formulário
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
