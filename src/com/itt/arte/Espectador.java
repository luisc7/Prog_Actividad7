package com.itt.arte;

public class Espectador {
	
	private String nombre;
	private String tlf;
	private int edad;
	
	public Espectador () {
		this.nombre = "";
		this.tlf = "";
		this.edad = -1;
	}
	
	public Espectador (String nom, String tlf, int eda) {
		this.nombre = nom;
		this.tlf = tlf;
		this.edad = eda;
	}
	
	public String rangoEdad() {
		if (0 <= this.edad && this.edad < 18) {
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
	
	public void setNombre(String nom) {
		this.nombre = nom;
	}
	
	public void setTlf(String tel) {
		this.tlf = tel;
	}
		
	public void setNombre(int eda) {
		this.edad = eda;
	}
	

}
