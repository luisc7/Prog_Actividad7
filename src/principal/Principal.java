package principal;

import java.util.Scanner;
import com.itt.arte.*;

public class Principal {
	private static Scanner lector;
	private static Scanner numteclado;
	private static Scanner teclado;
	
	private static Obra obra = new Obra("La cena de los idiotas", "Comedia", 95);
	private static Teatro teatro = new Teatro("C/ Sol, 45", 300, 2, obra, 30);
	
	public static void main(String[] args) {
		lector = new Scanner(System.in);
		char opc;
		int fil = 0;
		int col = 0;
		
		
		
		do {
			opc = mostrarMenu();
			
			switch (opc) {
			
				case '1':
					System.out.println(teatro.verProgramacion());
					break;
					
				case '2':
					System.out.println(teatro.verLocalidades());
					break;
				
				case '3':
					String ocupadas = teatro.verLocalidadesOcupadas();
					if (ocupadas == "") {
						System.out.println("Todas las butacas están libres.");
					} else {
						System.out.println(ocupadas);
					}
					break;
				
				case '4':
					numteclado = new Scanner(System.in);
					teclado = new Scanner(System.in);
								    				    
					System.out.println("Elija la fila en que prefiera sentarse (de 1 a " + teatro.getFilass() + ")");
					fil = numteclado.nextInt();
					fil--;
					System.out.println("Elija la butaca (de 1 a " + teatro.getColumnass() + ")");
					col = numteclado.nextInt();
					col--;
					
					if (teatro.getLocalidades(fil, col).getEdad() >= 0) {
						System.out.println("Lo sentimos, esa butaca está ocupada.");
						
					} else {
						System.out.println("Indique su nombre:");
						String nombre = teclado.nextLine();
						System.out.println("Introduzca su telefono:");
						String telefono = teclado.nextLine();
						System.out.println("Ponga su edad:");
						String edaStr = teclado.nextLine();
						int eda = Integer.parseInt(edaStr);
						Espectador esp = new Espectador(nombre, telefono, eda, teatro.getPrecio());			
						System.out.println(teatro.venderLocalidad(fil, col, esp));
					}
					break;
				
				case '5':
					teclado = new Scanner(System.in);
					System.out.println("¿En qué fila está la reserva que desea anular? (de 1 a " + teatro.getFilass() + ")");
					fil = numteclado.nextInt();
					fil--;
					System.out.println("¿Y qué butaca de la fila anterior es? (de 1 a " + teatro.getColumnass() + ")");
					col = numteclado.nextInt();
					col--;
					if (teatro.getLocalidades(fil, col).getEdad() == -1) {
						System.out.println("No se ha anulado ninguna reserva: La butaca ya estaba libre.");
						
					} else {					
						System.out.println(teatro.cancelarLocalidad(fil, col));
					}
					break;
					
				case '6':
					teclado = new Scanner(System.in);
					System.out.println("¿Qué fila desea consultar? (de 1 a " + teatro.getFilass() + ")");
					fil = numteclado.nextInt();
					fil--;
					System.out.println("¿Y qué butaca de la fila anterior es? (de 1 a " + teatro.getColumnass() + ")");
					col = numteclado.nextInt();
					col--;
					System.out.println(teatro.consultarLocalidad(fil, col));
					break;
				case '7':
					// Se ha optado por ir almacenando los precios en una variable 
					// de cada Espectador según se venden o anulan, y recalcularlo 
					// cada vez que se consulta barriendo todo el teatro.
					double ventaEntradas = 0;
					for (int i=0; i<teatro.getFilass(); i++) {
						for (int j=0; j<teatro.getColumnass(); j++) {
							if (teatro.getLocalidades(i, j).getEdad() >= 0)
								ventaEntradas += teatro.getLocalidades(i, j).getPreciobut() ;
						}
					}
					System.out.println("La reacudación en este momento es de: " + ventaEntradas);
					break;
				case '8':
					System.out.println("Hasta pronto");
					System.exit(1);
				default:
					System.out.println("Opcion no válida.");
					break;
			}
		} while (opc!='8');
		lector.close();
	}
	
	public static char mostrarMenu() {
		String opcion;
		System.out.println ("\nTEATRO LA BOMBILLA DE DON BLAS");
		System.out.println ("------------------------------");
		System.out.println ("1. Ver la programación actual");
		System.out.println ("2. Mostrar todas las localidades");
		System.out.println ("3. Mostrar localidades ocupadas");
		System.out.println ("4. Vender localidad");
		System.out.println ("5. Cancelar localidad");
		System.out.println ("6. Consultar localidad");
		System.out.println ("7. Calcular recaudación");
		System.out.println ("8. Terminar programa");
		System.out.println ("------------------------------");
		System.out.println ("¿Qué opción deseas?");
		opcion = lector.nextLine();
		return opcion.charAt(0); // Devuelvo el primer caracter tecleado.
	}
}