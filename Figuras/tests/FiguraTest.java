import static org.junit.Assert.*;

import org.junit.*;

public class FiguraTest {

	Figura f1;
	Figura f2;
	Figura f3;
	Figura f4;
	Figura f5;
	Figura f6;
	Figura f7;
	Figura f8;
	Figura f9;
	Figura f10;
	Figura f11;
	Figura f12;
	
	@Before
	public void setUp() throws Exception {
		f1 = new Figura("SSSBBBDDDBBBIII","figura1");
		f2 = new Figura("SB","figura2");
		f3 = new Figura("ID","figura3");
		f4 = new Figura("IDISS","figura4");
		f5 = new Figura("SDBI","figura5");
		f6 = new Figura("SSDDBBII","figura6");
		f7 = new Figura("BBBSSSIIISSSDDD","figura7");
		f8 = new Figura("DDDIIBS");
		f9 = new Figura("IIIISSDD");
		f10 = new Figura("II");
		f11 = new Figura("II");
		
	}
	
	@Test
	public void testFiguraString() {
		assertNotNull(new Figura("SIB"));		
	}

	@Test
	public void testFiguraStringString() {
		assertNotNull (new Figura("SBD","nombre"));
	}

	@Test
	public void testGetNombre() {
		assertTrue(f1.getNombre()=="figura1");
		assertTrue(f2.getNombre()=="figura2");
		assertTrue(f3.getNombre()=="figura3");
	}

	@Test
	public void testGetTrazos() {
		assertTrue(f2.getTrazos().get(0).getOrientacion() == 'S');
		assertTrue(f2.getTrazos().get(1).getOrientacion() == 'B');
	}

	@Test
	public void testAnadirTrazoChar() {
		assertFalse(f2.getTrazos().get(f2.getTrazos().size()-1).getOrientacion() == 'I');
		f2.anadirTrazo('I');
		assertTrue(f2.getTrazos().get(f2.getTrazos().size()-1).getOrientacion() == 'I');
	}

	@Test
	public void testAnadirTrazoCharBoolean() {
		assertFalse(f2.getTrazos().get(f2.getTrazos().size()-1).getOrientacion() == 'I');
		f2.anadirTrazo('I',false);
		assertTrue(f2.getTrazos().get(f2.getTrazos().size()-1).getOrientacion() == 'I');
		
		assertFalse(f2.getTrazos().get(0).getOrientacion() == 'I');
		f2.anadirTrazo('I',true);
		assertTrue(f2.getTrazos().get(0).getOrientacion() == 'I');
	}

	@Test
	public void testFusionar() {
		f2.fusionar(f3);
		assertTrue(f2.getTrazos().get(0).getOrientacion() == 'S');
		assertTrue(f2.getTrazos().get(1).getOrientacion() == 'B');
		assertTrue(f2.getTrazos().get(2).getOrientacion() == 'I');
		assertTrue(f2.getTrazos().get(3).getOrientacion() == 'D');
	}

	@Test
	public void testInsertar() {
		f2.insertar(0,f3);
		assertTrue(f2.getTrazos().get(0).getOrientacion() == 'I');
		assertTrue(f2.getTrazos().get(1).getOrientacion() == 'D');
		assertTrue(f2.getTrazos().get(2).getOrientacion() == 'S');
		assertTrue(f2.getTrazos().get(3).getOrientacion() == 'B');
	}

	@Test
	public void testEliminarDesdeUltimoTrazo() {
		f4.eliminarDesdeUltimoTrazo('I');
		assertTrue(f4.getTrazos().size() == 3);
		f2.eliminarDesdeUltimoTrazo('I');
		assertTrue(f2.getTrazos().size() == 2);		
	}

	@Test
	public void testSustituir() {
		
		f2.sustituir('B', "ID");
		assertTrue(f2.getTrazos().get(0).getOrientacion() == 'S');
		assertTrue(f2.getTrazos().get(1).getOrientacion() == 'I');
		assertTrue(f2.getTrazos().get(2).getOrientacion() == 'D');
	}

	@Test
	public void testGirarDerecha() {
		
		Figura f = new Figura("SDBI");
		f.girarDerecha();
		assertTrue(f.getTrazos().get(0).getOrientacion() == 'D');
		assertTrue(f.getTrazos().get(1).getOrientacion() == 'B');
		assertTrue(f.getTrazos().get(2).getOrientacion() == 'I');
		assertTrue(f.getTrazos().get(3).getOrientacion() == 'S');
	}

	@Test
	public void testHomotecia2() {
		Figura f = new Figura("SDBI");
		f.homotecia2();
		assertTrue(f.getTrazos().get(0).getOrientacion() == 'S');
		assertTrue(f.getTrazos().get(1).getOrientacion() == 'S');
		assertTrue(f.getTrazos().get(2).getOrientacion() == 'D');
		assertTrue(f.getTrazos().get(3).getOrientacion() == 'D');
		assertTrue(f.getTrazos().get(4).getOrientacion() == 'B');
		assertTrue(f.getTrazos().get(5).getOrientacion() == 'B');
		assertTrue(f.getTrazos().get(6).getOrientacion() == 'I');
		assertTrue(f.getTrazos().get(7).getOrientacion() == 'I');
	}

	@Test
	public void testLongitud() {
		assertTrue(f4.longitud() == f4.getTrazos().size());
		assertTrue(f7.longitud() == f7.getTrazos().size());
		assertTrue(f5.longitud() == f5.getTrazos().size());
	}

	@Test
	public void testAltura() {
		assertTrue((f1.altura() == 6));
		assertTrue((f2.altura() == 1));
		assertTrue((f3.altura() == 0));
		assertTrue((f7.altura() == 6));
	}

	@Test
	public void testAnchura() {
		assertTrue((f1.anchura() == 3));
		assertTrue((f2.anchura() == 0));
		assertTrue((f3.anchura() == 1));
		assertTrue((f7.anchura() == 3));
		assertTrue((f8.anchura() == 3));
		assertTrue((f9.anchura() == 4));
	}

	@Test
	public void testSuperficie() {
		assertTrue(f1.altura()*f1.anchura() == f1.superficie());
		assertTrue(f2.altura()*f2.anchura() == f2.superficie());
		assertTrue(f3.altura()*f3.anchura() == f3.superficie());
	}

	@Test
	public void testEqualsObject() {
		assertTrue(f1.equals(f1));
		assertTrue(f10.equals(f11));
		assertFalse(f1.equals(f2));
		assertFalse(f2.equals(f3));
		assertFalse(f4.equals('a'));
	}

	@Test
	public void testEsHomotetica() {
		assertTrue(f10.esHomotetica(f11));
		assertTrue(f1.esHomotetica(f1));
		assertTrue(f5.esHomotetica(f6));
		assertTrue(f6.esHomotetica(f5));
		assertFalse(f1.esHomotetica(f2));
		assertFalse(f2.esHomotetica(f1));
		assertFalse(f5.esHomotetica(f3));
	}

	@Test
	public void testEsSemejante() {
		f5.girarDerecha();
		assertTrue(f5.esSemejante(f6));
		assertFalse(f1.esSemejante(f2));
	}

	@Test
	public void testClone() {
		try {
			f1 = (Figura) f5.clone();
			assertTrue(f5.equals(f5.clone()));
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testToString() {
		assertTrue(f1.toString().compareTo("SSSBBBDDDBBBIII") == 0);
	}

}
