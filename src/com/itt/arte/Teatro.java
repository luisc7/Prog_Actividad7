package com.itt.arte;

public class Teatro extends Local implements Sala{
	private Obra obra;
	private double precio;
	private Espectador[][] localidades;
	
	private int filass;
	private int columnass;
	
	// private static double recaudacion = 0;
	
		
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
						".\nGénero: " + obra.getGenero() +
						".\nDuración: "+ obra.getMinutos() + " minutos. " +
						"\nEl teatro se ubica en " + super.getDomicilio() + " y tiene " +
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
				lista.append((i+1) + "." + (j+1) + " ");
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
					 ocupados.append((i+1) + "." + (j+1) + " ");
					 ocupados.append(localidades[i][j].getNombre()+", ");
					 ocupados.append("telf: "+ localidades[i][j].getTlf() + ", ");
					 ocupados.append("Tipo: "+ localidades[i][j].rangoEdad());
				 }
			}
		}
		return ocupados.toString();
	}
	public String venderLocalidad(int fila, int butaca, Espectador e) {
	    this.localidades[fila][butaca].setEspectador(e, precio);
	    double preciodto = 0;
	    if (e.rangoEdad() == "infantil") {
			preciodto = this.precio * (1 - 0.5);
		} else if (e.rangoEdad() == "menor") {
			preciodto = this.precio * (1 - 0.2);
		} else if ((e.rangoEdad() == "adulto")) {
			preciodto = this.precio * (1 - 0);
		} else if (e.rangoEdad() == "jubilado") {
			preciodto = this.precio * (1 - 0.66);
		} 
	    // recaudacion += preciodto;
	    return "Se ha vendido la localidad "+ (fila+1) + "." + (butaca+1) + 
				" a " + e.getNombre() + " por " + preciodto + " Euros";
	}
	public String cancelarLocalidad(int fila, int butaca) {
		String personaAnula = localidades[fila][butaca].getNombre();
		//recaudacion -= localidades[fila][butaca].getPreciobut();
		localidades[fila][butaca].setNombre(null);
		localidades[fila][butaca].setTlf(null);
		localidades[fila][butaca].setEdad(-1);
		localidades[fila][butaca].setPreciobut(0);
				
		return personaAnula + " ha cancelado su reserva";
	}
	public String consultarLocalidad(int fila, int butaca) {
		if (localidades[fila][butaca].getEdad() == -1) {
			return "La localidad está libre.";
		} else {
			return "La localidad " + fila + "." + butaca + " está ocupada por " + 
					localidades[fila][butaca].getNombre() + ".\nTelf: " + 
					localidades[fila][butaca].getTlf() + "\nRango de edad: " +
					localidades[fila][butaca].rangoEdad() + "\nPrecio: " +
					localidades[fila][butaca].getPreciobut();
		}
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
		localidades[f][c] = new Espectador(nom, tel, edd, precio);
	}
	
	public void setPrecio(Espectador e) {
		double dto = 0;
		
		int ed = e.getEdad();

		if (0 <= ed && ed < 13) {
			dto = 0.5;
		} else if (ed >= 13 && ed < 18) {
			dto = 0.2;
		} else if (ed >= 65) {
			dto = 0.66;
		} else {
			dto = 0;
		}
		
		e.setPreciobut(this.precio * (1 - dto));
		
	}
	

}
