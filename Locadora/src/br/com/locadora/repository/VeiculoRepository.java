package br.com.locadora.repository;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import br.com.locadora.model.Veiculo;

/**
 * Classe respons�vel por armazenar os ve�culos 
 * */
public class VeiculoRepository implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static List<Veiculo> entities = new LinkedList<Veiculo>();
	
	
	/**
	 * M�todo respons�vel por adicionar um novo ve�culo na lista
	 * @param entity
	 * @exception Exception
	 * */
	public void create(Veiculo entity) throws Exception{
		entities.add(entity);
	}

	/**
	 * M�todo respons�vel setar em uma determinada posi��o da
	 * lista o veiculo que foi editado.
	 * @param entity
	 * @param posicao
	 * @exception Exception
	 * */
	public void update(int posicao, Veiculo entity) throws Exception{
		entities.set(posicao, entity);
	}

	/**
	 * M�todo respons�vel por remover um ve�culo da lista
	 * passando a posi��o da lista
	 * @param posicao
	 * @exception Exception
	 * */
	public void delete(int posicao) throws Exception{
		entities.remove(posicao);
	}
	
	/**
	 * M�todo respons�vel por listar todos os ve�culos armazenados
	 * */
	public List<Veiculo> getVeiculos(){
		return entities;
	}
	
	
}
