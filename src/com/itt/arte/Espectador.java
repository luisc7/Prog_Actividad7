package com.itt.arte;

public class Espectador {
	
	private String nombre;
	private String tlf;
	private int edad;
	private double preciobut;
	
	public Espectador () {
		this.nombre = null;
		this.tlf = null;
		this.edad = -1;
		this.preciobut = 0;
	}
	
	public Espectador (String nom, String tlf, int eda, double but) {
		this.nombre = nom;
		this.tlf = tlf;
		this.edad = eda;
		this.preciobut = but * this.calcularDto();
	}
	
	public String rangoEdad() {
		if (0 <= this.edad && this.edad < 13) {
			return "infantil";
		} else if (this.edad >= 13 && this.edad < 18) {
			return "menor";
		} else if (this.edad >= 18 && this.edad < 65) {
			return "adulto";
		} else if (this.edad >= 65) {
			return "jubilado";
		} else {
			return "no definido";
		}
	}
	
	// Falta perfilar el toString para el uso final
	@Override
	public String toString() {
		return "";
	}
	
	//getters y setters
	public String getNombre() {
		return this.nombre;
	}
	
	public String getTlf() {
		return this.tlf;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public double getPreciobut() {
		return this.preciobut;
	}
	
	public void setNombre(String nom) {
		this.nombre = nom;
	}
	
	public void setTlf(String tel) {
		this.tlf = tel;
	}
		
	public void setEdad(int eda) {
		this.edad = eda;
	}
	
	public void setPreciobut(double pre) {
		this.preciobut = pre;
	}
	
	public void setEspectador(Espectador esp, double pre) {
		this.nombre = esp.getNombre();
		this.tlf = esp.getTlf();
		this.edad = esp.getEdad();
		this.preciobut = esp.calcularDto() * pre;
	}
	
	public double calcularDto() {
		String tipo = this.rangoEdad();
		if (tipo == "infantil") {
			return (1 - 0.5);
		} else if (tipo == "menor") {
			return (1 - 0.2);
		} else if (tipo == "adulto") {
			return (1 - 0);
		} else if (tipo == "jubilado") {
			return (1 - 0.66);
		} else {
			return 0;
		}
	}
	

}
