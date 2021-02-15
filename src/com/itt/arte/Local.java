package com.itt.arte;

public class Local {
	
	private String domicilio;
	private int metros;
	private int accesos;
	
	public Local() {
		this.domicilio = "";
		this.metros = 0;
		this.accesos = 0;
	}
	
	public Local(String dom, int met, int acc) {
		this.domicilio = dom;
		this.metros = met;
		this.accesos = acc;
	}
	
	
	// Falta perfilar el toString apra el uso final
	@Override
	public String toString() {
		return "";
	}
	
	// getters y setters
	public String getDomicilio() {
		return this.domicilio;
	}
	
	public int getMetros() {
		return this.metros;
	}

	public int getAccesos() {
		return this.accesos;
	}
	
	public void setDomicilio(String dom) {
		this.domicilio = dom;
	}
	
	public void setMetros(int met) {
		this.metros = met;
	}

	public void setAccesos(int acc) {
		this.accesos = acc;
	}

}
