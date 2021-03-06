import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GestorFigurasTest {
	GestorFiguras g1;
	GestorFiguras g2;
	Figura f1;
	Figura f2;
	Figura f3;
	@Before
	public void setUp() throws Exception {
		g1=new GestorFiguras();
		g2=new GestorFiguras();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGestorFiguras() {
		assertNotNull(new GestorFiguras());
	}

	@Test
	public void testGuardar() {
		f1 = new Figura("SSSBBBDDDBBBIII","figura1");
		g1.guardar(f1);
		assertTrue(g1.Figuras.containsKey("figura1"));
	}

	@Test
	public void testRecuperar() {
		f1 = new Figura("SSSBBBDDDBBBIII","figura1");
		g1.guardar(f1);
		assertNotNull(g1.recuperar("figura1")==f1);
	}

	@Test
	public void testCambiar() {
	f1 = new Figura("SS","figura1");
	f2 = new Figura("S","figura1");
	g1.guardar(f1);
	g1.cambiar(f2);
		assertTrue(f2.equals(g1.recuperar("figura1")));
		assertFalse(f1.equals(g1.recuperar("figura1")));
	}

	@Test
	public void testExiste() {
		f1 = new Figura("SSSBBBDDDBBBIII","figura1");
		g1.guardar(f1);
		assertTrue(g1.existe("figura1"));
		assertFalse(g1.existe("figura2"));
	}

	@Test
	public void testRecuperarLista() {
		String [] nombres = {"figura1"};
		f1 = new Figura("SS","figura1");
		f2 = new Figura("II","figura2");
		g1.guardar(f1);
		g1.guardar(f2);
		assertNotNull(g1.recuperarLista(nombres));
	}

	@Test
	public void testRecuperarIguales() {
		f1 = new Figura("SS","figura1");
		f3 = new Figura("II","figura3");
		g1.guardar(f1);
		g1.guardar(f3);
		f2 = new Figura("SS","figura2");
		assertNotNull(g1.recuperarIguales(f2));
	}

	@Test
	public void testRecuperarSemejantes() {
		f1 = new Figura("SSSSBBBBDDDDBBBBIIII","figura1");
		f3 = new Figura("SS","figura3");
		g1.guardar(f1);
		g1.guardar(f3);
		f2 = new Figura("SSBBDDBBII","figura2");
		assertNotNull(g1.recuperarSemejantes(f2));
	}

}
