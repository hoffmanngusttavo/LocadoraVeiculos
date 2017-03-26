package br.com.locadora.model;

public enum Combustivel {

	DIESEL("DIESEL"),
	GASOLINA("GASOLINA"),
	FLEX("FLEX"),
	ALCOOL("ALCOOL"),
	GAS_NATURAL("GÁS NATURAL");
	
	private String label;

	private Combustivel(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
