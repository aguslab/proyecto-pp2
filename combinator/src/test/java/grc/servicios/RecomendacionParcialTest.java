package grc.servicios;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class RecomendacionParcialTest extends TestCase
{
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public RecomendacionParcialTest(String testName)
	{
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite(RecomendacionParcialTest.class);
	}

//	public void testRecomendacionParcialAgregarCursoFail() throws Exception
//	{
//		Materia mn = new Materia("N");
//		List<Horario> h = new ArrayList<Horario>();
//		h.add(new Horario(Dia.LUNES, 18, 22));
//		h.add(new Horario(Dia.MARTES, 18, 20));
//		Carrera c = new Carrera("Licenciatura en Sistemas");
//		List<Carrera> ca = new ArrayList<Carrera>();
//		ca.add(c);
//		Curso c1 = new Curso(ca, mn, h, "01");
//
//		RecomendacionParcial rp = new RecomendacionParcial();
//		rp.agregarCurso(c1);
//		rp.agregarCurso(c1);
//		assertEquals(1, rp.getRecomendacion().size());
//	}
}
