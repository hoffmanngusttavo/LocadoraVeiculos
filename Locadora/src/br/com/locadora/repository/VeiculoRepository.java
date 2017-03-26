package br.com.locadora.repository;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import br.com.locadora.model.Veiculo;

/**
 * Classe responsável por armazenar os veículos 
 * */
public class VeiculoRepository implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static List<Veiculo> entities = new LinkedList<Veiculo>();
	
	
	/**
	 * Método responsável por adicionar um novo veículo na lista
	 * @param entity
	 * @exception Exception
	 * */
	public void create(Veiculo entity) throws Exception{
		entities.add(entity);
	}

	/**
	 * Método responsável setar em uma determinada posição da
	 * lista o veiculo que foi editado.
	 * @param entity
	 * @param posicao
	 * @exception Exception
	 * */
	public void update(int posicao, Veiculo entity) throws Exception{
		entities.set(posicao, entity);
	}

	/**
	 * Método responsável por remover um veículo da lista
	 * passando a posição da lista
	 * @param posicao
	 * @exception Exception
	 * */
	public void delete(int posicao) throws Exception{
		entities.remove(posicao);
	}
	
	/**
	 * Método responsável por listar todos os veículos armazenados
	 * */
	public List<Veiculo> getVeiculos(){
		return entities;
	}
	
	
}
