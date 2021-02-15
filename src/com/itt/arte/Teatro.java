package com.itt.arte;
//import java.lang.Object;

public class Teatro extends Local implements Sala{
	private Obra obra;
	private double precio;
	private Espectador[][] localidades;
	
	private static final int FILAS = 5;
	private static final int COLUMNAS = 10;
	
	// Constructores
	public Teatro(String domi, int metr, int acce, Obra ob, double pre) {
		super(domi, metr, acce);
		this.obra = ob;
		//this.localidades = new Espectador[FILAS][COLUMNAS];
		this.localidades = new Espectador[FILAS][COLUMNAS];
		for (int i=0; i<FILAS; i++) {
			for (int j=0; j<COLUMNAS; j++) {
				 localidades[i][j] = new Espectador();
			}
		}
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
		StringBuilder lista = new StringBuilder("");
		for (int i=0; i<FILAS; i++) {
			lista.append("\n");
			for (int j=0; j<COLUMNAS; j++) {
				lista.append(i + "." + j + " ");
				if (localidades[i][j].getEdad() == -1) {
					lista.append("Libre\t");
				} else {
					lista.append("Ocupado\t");
				}
			}
		}
		return lista.toString();
	}
	
	public String verLocalidadesOcupadas() {
		StringBuilder ocupados = new StringBuilder("");
		for (int i=0; i<FILAS; i++) {
			for (int j=0; j<COLUMNAS; j++) {
				 if ((localidades[i][j].getEdad()) != (-1)) {
					 ocupados.append("\n");
					 ocupados.append(i + "." + j + " ");
					 ocupados.append(localidades[i][j].getNombre()+", ");
					 ocupados.append("telf: "+ localidades[i][j].getTlf() + ", ");
					 ocupados.append("Tipo: "+ localidades[i][j].rangoEdad());
				 }
			}
		}
		return ocupados.toString();
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
