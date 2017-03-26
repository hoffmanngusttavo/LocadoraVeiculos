package br.com.locadora.model;

public enum Cambio {

	MANUAL("MANUAL"),
	AUTOMATICO("AUTOMÁTICO"),
	CVT("CVT");
	
	private String label;

	private Cambio(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
