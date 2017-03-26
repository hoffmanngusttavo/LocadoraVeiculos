package br.com.locadora.model;

public enum TipoVeiculo {

	CARRO("CARRO"),
	CAMINHAO("CAMINHÃO"),
	MOTOCICLETA("MOTOCICLETA");
	
	private String label;

	private TipoVeiculo(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
}
