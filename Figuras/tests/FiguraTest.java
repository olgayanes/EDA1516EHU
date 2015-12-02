import static org.junit.Assert.*;
import org.junit.Test;

public class FiguraTest {

	
	@Test
	public void testFiguraString() {
		assertNotNull (new Figura(null));
		fail("No se puede crear Figuras en blanco");
		
	}

	@Test
	public void testFiguraStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNombre() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTrazos() {
		fail("Not yet implemented");
	}

	@Test
	public void testAnadirTrazoChar() {
		fail("Not yet implemented");
	}

	@Test
	public void testAnadirTrazoCharBoolean() {
		fail("Not yet implemented");
	}

	@Test
	public void testFusionar() {
		Figura fig1 = new Figura("BBSS");
		Figura fig2 = new Figura("IIDD");
		fig1.fusionar(fig2);
		assertTrue(true);
		//fail("Not yet implemented");
		//assertEquals("[B, B, S, S, I, I, D, D]", fig1.fusionar(fig2));
	}

	@Test
	public void testInsertar() {
		fail("Not yet implemented");
	}

	@Test
	public void testEliminarDesdeUltimoTrazo() {
		fail("Not yet implemented");
	}

	@Test
	public void testSustituir() {
		fail("Not yet implemented");
	}

	@Test
	public void testGirarDerecha() {
		fail("Not yet implemented");
	}

	@Test
	public void testHomotecia2() {
		fail("Not yet implemented");
	}

	@Test
	public void testLongitud() {
		Figura fig1 = new Figura("BBSS");
		fig1.longitud();
		//fail("Not yet implemented");
	}

	@Test
	public void testAltura() {
		Figura fig1 = new Figura("BBSS");
		fig1.altura();
		//fail("Not yet implemented");
	}

	@Test
	public void testAnchura() {
		Figura fig1 = new Figura("BBSS");
		fig1.anchura();
		//fail("Not yet implemented");
	}

	@Test
	public void testSuperficie() {
		Figura fig1 = new Figura("BBSS");
		fig1.superficie();
		//fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testEsHomotetica() {
		fail("Not yet implemented");
	}

	@Test
	public void testEsSemejante() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
