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
					System.out.println(teatro.verLocalidadesOcupadas());
					break;
				
				case '4':
					numteclado = new Scanner(System.in);
					teclado = new Scanner(System.in);
								    				    
					System.out.println("Elija la fila en que prefiera sentarse (de 1 a " + teatro.getFilass() + ")");
					int fil = numteclado.nextInt();
					fil--;
					System.out.println("Elija la butaca (de 1 a " + teatro.getColumnass() + ")");
					int col = numteclado.nextInt();
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
						Espectador esp = new Espectador(nombre, telefono, eda);			
						System.out.println(teatro.venderLocalidad(fil, col, esp));
						
					
					}
					break;
				
				case '5':
					teclado = new Scanner(System.in);
					System.out.println("¿En qué fila está la reserva que desea anular? (de 1 a " + teatro.getFilass() + ")");
					int fil2 = numteclado.nextInt();
					fil2--;
					System.out.println("¿Y qué butaca de la fila anterior es? (de 1 a " + teatro.getColumnass() + ")");
					int col2 = numteclado.nextInt();
					col2--;
					System.out.println(teatro.cancelarLocalidad(fil2, col2));
					break;
					
				case '6':
				case '7':
				case '8':
				default:
			}
		} while (opc!='8');
		lector.close();
	}
	
	public static char mostrarMenu() {
		String opcion;
		System.out.println ("TEATRO LA BOMBILLA DE DON BLAS");
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