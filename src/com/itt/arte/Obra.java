package com.itt.arte;

public class Obra {
	private String titulo;
	private String genero;
	private int minutosDuracion;
	
	public Obra(String tit, String gen, int dur) {
		this.titulo = tit;
		this.genero = gen;
		this.minutosDuracion = dur;
	}

	// Falta perfilar el toString para el uso final
	@Override
	public String toString() {
		return "";
	}
	
	// getters y setters
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getGenero() {
		return this.genero;
	}
	
	public int setMinutosDuracion() {
		return this.minutosDuracion;
	}
	
	public void setTitulo(String tit) {
		this.titulo = tit;
	}
	
	public void setGenero(String gen) {
		this.genero = gen;
	}
	
	public void setDuracion(int dur) {
		this.minutosDuracion = dur;
	}
}
