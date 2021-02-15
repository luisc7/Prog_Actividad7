package com.itt.arte;

public class Teatro extends Local implements Sala{
	private Obra obra;
	private double precio;
	private Espectador[][] localidades;
	
	private final int FILAS = 5;
	private final int COLUMNAS = 10;
	
	// Constructores
	public Teatro(String domi, int metr, int acce, Obra ob, double pre) {
		super(domi, metr, acce);
		this.obra = ob;
		this.localidades = new Espectador[FILAS][COLUMNAS];
		this.precio = pre;
	}
	
	public String verProgramacion() {
		String actual = "Hoy representamos " + obra.getTitulo() +
						". Género: " + obra.getGenero() +
						". Duración: "+ obra.getMinutos() + " minutos. " +
						"El teatro se ubica en " + super.getDomicilio() + " y tiene " +
						super.getMetros() + " metros cuadrados de superficie. Cuenta con " +
						super.getAccesos() + " accesos.\n" +
						"Precio: " + this.precio + " Euros.";
		return actual;
	}
	public String verLocalidades() {
		String lista = "";
		for (int i=0; i<FILAS; i++) {
			lista.concat("\n");
			for (int j=0; j<COLUMNAS; j++) {
				 lista.concat(i + "." + j + " ");
				 if (localidades[i][j].getEdad() == -1) {
					 lista.concat("Libre\t");
				 } else {
					 lista.concat("Ocupado\t");
				 }
			}
		}
		return lista;
	}
	
	public String verLocalidadesOcupadas() {
		String ocupados = "";
		for (int i=0; i<FILAS; i++) {
			for (int j=0; j<COLUMNAS; j++) {
				 if (localidades[i][j].getEdad() != (-1)) {
					 ocupados.concat("\n");
					 ocupados.concat(i + "." + j + " ");
					 ocupados.concat(localidades[i][j].getNombre()+", ");
					 ocupados.concat("telf: "+ localidades[i][j].getTlf() + ", ");
					 ocupados.concat("Tipo: "+ localidades[i][j].rangoEdad());
				 }
			}
		}
		return ocupados;
	}
	public String venderLocalidad(int fila, int butaca, Espectador e) {
		return "";
	}
	public String cancelarLocalidad(int fila, int butaca) {
		return "";
	}
	public String consultarLocalidad(int fila, int butaca) {
		return "";
	}
	public double calcularRecaudacion() {
		return 0;
	}
	

}
