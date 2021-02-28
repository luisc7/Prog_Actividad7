package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.itt.arte.Espectador;

import static org.junit.Assert.assertEquals;

class TestEspectador {

	@Test
	void testRangoEdad() {
		
		Espectador esp1 = new Espectador("A", "B", 15, 3.3);
		assertEquals(15, esp1.getEdad());


	}

}
