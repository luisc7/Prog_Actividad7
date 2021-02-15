package com.itt.arte;

public class Teatro extends Local implements Sala{
	private Obra obra;
	private double precio;
	private Espectador[][] localidades;
	
	private int filass;
	private int columnass;
	
		
	// Constructores
	public Teatro(String domi, int metr, int acce, Obra ob, double pre) {
		super(domi, metr, acce);
		this.obra = ob;
		
		final int FILAS = 5;
		final int COLUMNAS = 10;
		
		this.filass = FILAS;
		this.columnass = COLUMNAS;
		
		this.localidades = new Espectador[filass][columnass];
		for (int i=0; i<filass; i++) {
			for (int j=0; j<columnass; j++) {
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
		for (int i=0; i<filass; i++) {
			lista.append("\n");
			for (int j=0; j<columnass; j++) {
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
		for (int i=0; i<filass; i++) {
			for (int j=0; j<columnass; j++) {
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
	
	//getters y setters
	public int getFilass() {
		return this.filass;
	}
	
	public int getColumnass() {
		return this.columnass;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public Espectador getLocalidades(int f, int c){
		return this.localidades[f][c];
	}
	
	public void setLocalidades(int f, int c, String nom, String tel, int edd){
		localidades[f][c] = new Espectador(nom, tel, edd);
	}
	

}
