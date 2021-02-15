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
					
				case '2':
					System.out.println(teatro.verLocalidades());
				
				case '3':
					System.out.println(teatro.verLocalidadesOcupadas());
				
				case '4':
					numteclado = new Scanner(System.in);
					teclado = new Scanner(System.in);
					
				    int fil = 0;
				    int col = 0;
				    int eda = 0;
				    
				    double dto = 0;
				    double precdto = 0;
										
					System.out.println("Elija la fila en que prefiera sentarse (de 0 a " + teatro.getFilass());
					fil = numteclado.nextInt();
					System.out.println("Elija la butaca (de 0 a " + teatro.getColumnass());
					col = numteclado.nextInt();
					
					if (teatro.getLocalidades(fil, col).getEdad() >= 0) {
						System.out.println("Lo sentimos, esa butaca está ocupada.");
						
					} else {
						System.out.println("Indique su nombre:");
						String nombre = teclado.nextLine();
						System.out.println("Introduzca su telefono:");
						String telefono = teclado.nextLine();
						System.out.println("Ponga su edad:");
						eda = numteclado.nextInt();
						
						if (0 <= eda && eda < 13) {
							dto = 0.5;
						} else if (eda >= 13 && eda < 18) {
							dto = 0.2;
						} else if (eda >= 65) {
							dto = 0.66;
						} else {
							dto = 0;
						}
						
						precdto = teatro.getPrecio() * (1 - dto);
						
						teatro.setLocalidades(fil, col, nombre, telefono, eda);
						System.out.println("Se ha vendido la localidad "+ fil + "." + col + 
								" a " + nombre + " por " + precdto + " Euros");
					
					}
				
				case '5':
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