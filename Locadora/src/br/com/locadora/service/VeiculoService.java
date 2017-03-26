package br.com.locadora.service;

import java.io.Serializable;
import java.util.List;
import java.util.Random;


import br.com.locadora.model.Veiculo;
import br.com.locadora.repository.VeiculoRepository;

/**
 * Classe respons�vel por implementar a regra de neg�cio Classe que se comunica
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
	 * Construtor respons�vel por instanciar classe de reposit�rio
	 */
	public VeiculoService() {
		repository = new VeiculoRepository();
	}

	/**
	 * M�todo respons�vel por validar se j� existe um veiculo com mesma placa
	 *  e criar um novo ve�culo 
	 * @param entity
	 * @exception Exception
	 */
	public void create(Veiculo entity) throws Exception {
		if (entity != null) {
			List<Veiculo> veiculos = repository.getVeiculos();
			for (Veiculo veiculo : veiculos) {
				if (veiculo.getPlaca().equalsIgnoreCase(entity.getPlaca())) {
					throw new Exception("J� existe um ve�culo com essa placa cadastrada");
				}
			}
		}
		entity.setId(new Random().nextLong());
		repository.create(entity);
	}

	/**
	 * M�todo respons�vel por editar um ve�culo passando a posi��o da lista para
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
	 * M�todo respons�vel por remover um ve�culo passando a posi��o da lista
	 * 
	 * @param posicao
	 * @exception Exception
	 */
	public void delete(int posicao) throws Exception {
		repository.delete(posicao);
	}

	/**
	 * M�todo respons�vel por listar todos os ve�culos
	 */
	public List<Veiculo> getVeiculos() {
		return repository.getVeiculos();
	}

}
