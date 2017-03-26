package br.com.locadora.service;

import java.io.Serializable;
import java.util.List;
import java.util.Random;


import br.com.locadora.model.Veiculo;
import br.com.locadora.repository.VeiculoRepository;

/**
 * Classe responsável por implementar a regra de negócio Classe que se comunica
 * com controller e repositorio
 * 
 * @author Gustavo Hoffmann
 */
public class VeiculoService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VeiculoRepository repository;

	/**
	 * Construtor responsável por instanciar classe de repositório
	 */
	public VeiculoService() {
		repository = new VeiculoRepository();
	}

	/**
	 * Método responsável por validar se já existe um veiculo com mesma placa
	 *  e criar um novo veículo 
	 * @param entity
	 * @exception Exception
	 */
	public void create(Veiculo entity) throws Exception {
		if (entity != null) {
			List<Veiculo> veiculos = repository.getVeiculos();
			for (Veiculo veiculo : veiculos) {
				if (veiculo.getPlaca().equalsIgnoreCase(entity.getPlaca())) {
					throw new Exception("Já existe um veículo com essa placa cadastrada");
				}
			}
		}
		entity.setId(new Random().nextLong());
		repository.create(entity);
	}

	/**
	 * Método responsável por editar um veículo passando a posição da lista para
	 * atualizar
	 * 
	 * @param entity
	 * @param posicao
	 * @exception Exception
	 */
	public void update(int posicao, Veiculo entity) throws Exception {
		repository.update(posicao, entity);
	}

	/**
	 * Método responsável por remover um veículo passando a posição da lista
	 * 
	 * @param posicao
	 * @exception Exception
	 */
	public void delete(int posicao) throws Exception {
		repository.delete(posicao);
	}

	/**
	 * Método responsável por listar todos os veículos
	 */
	public List<Veiculo> getVeiculos() {
		return repository.getVeiculos();
	}

}
