package br.com.locadora.model;

import java.io.Serializable;

/**
 * Classe responsável por armazenar os valores dos atributos do veículo
 * @author Gustavo Hoffmann
 * */
public class Veiculo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Campo obrigatorio unico
	 * */
	private Long id;
	/**
	 * Campo obrigatorio
	 * */
	private String marca;
	/**
	 * Campo obrigatorio
	 * */
	private String modelo;
	/**
	 * Campo obrigatorio
	 * */
	private String placa;
	/**
	 * Campo obrigatorio
	 * */
	private String cor;
	
	private int quilometragem;
	/**
	 * Campo obrigatorio
	 * */
	private int anoFabricacao;
	/**
	 * Campo obrigatorio
	 * */
	private TipoVeiculo tipoVeiculo;
	/**
	 * Campo obrigatorio
	 * */
	private Cambio cambio;
	/**
	 * Campo obrigatorio
	 * */
	private Combustivel combustivel;
	
	
	private boolean airbag = false;
	private boolean alarme = false;
	private boolean arCondicionado = false;
	private boolean arQuente = false;
	private boolean bancoCouro = false;
	private boolean direcaoHidraulica = false;
	private boolean abs = false;
	private boolean travaEletrica = false;
	private boolean rodaLigaLeve = false;
	private boolean tetoSolar = false;
	
	
	
	public TipoVeiculo getTipoVeiculo() {
		return tipoVeiculo;
	}
	public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public int getQuilometragem() {
		return quilometragem;
	}
	public void setQuilometragem(int quilometragem) {
		this.quilometragem = quilometragem;
	}
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public Cambio getCambio() {
		return cambio;
	}
	public void setCambio(Cambio cambio) {
		this.cambio = cambio;
	}
	public Combustivel getCombustivel() {
		return combustivel;
	}
	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}
	public boolean isAirbag() {
		return airbag;
	}
	public void setAirbag(boolean airbag) {
		this.airbag = airbag;
	}
	public boolean isAlarme() {
		return alarme;
	}
	public void setAlarme(boolean alarme) {
		this.alarme = alarme;
	}
	public boolean isArCondicionado() {
		return arCondicionado;
	}
	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}
	public boolean isArQuente() {
		return arQuente;
	}
	public void setArQuente(boolean arQuente) {
		this.arQuente = arQuente;
	}
	public boolean isBancoCouro() {
		return bancoCouro;
	}
	public void setBancoCouro(boolean bancoCouro) {
		this.bancoCouro = bancoCouro;
	}
	public boolean isDirecaoHidraulica() {
		return direcaoHidraulica;
	}
	public void setDirecaoHidraulica(boolean direcaoHidraulica) {
		this.direcaoHidraulica = direcaoHidraulica;
	}
	public boolean isAbs() {
		return abs;
	}
	public void setAbs(boolean abs) {
		this.abs = abs;
	}
	public boolean isTravaEletrica() {
		return travaEletrica;
	}
	public void setTravaEletrica(boolean travaEletrica) {
		this.travaEletrica = travaEletrica;
	}
	public boolean isRodaLigaLeve() {
		return rodaLigaLeve;
	}
	public void setRodaLigaLeve(boolean rodaLigaLeve) {
		this.rodaLigaLeve = rodaLigaLeve;
	}
	public boolean isTetoSolar() {
		return tetoSolar;
	}
	public void setTetoSolar(boolean tetoSolar) {
		this.tetoSolar = tetoSolar;
	}
	
	
	
}
