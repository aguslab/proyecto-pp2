package grc.dao;

import grc.dao.HorarioDAO;
import grc.dominio.Dia;
import grc.dominio.Horario;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class HorarioDAOTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	 public HorarioDAOTest( String testName )
	 {
	 super( testName );
	 }

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(HorarioDAOTest.class);
	}


	public void testAltaHorarioFail() {
		Horario h = null;
		try {
			HorarioDAO.getInstancia().alta(h);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	public void testAltaHorarioOk() {

		Horario h = new Horario(Dia.LUNES, 18, 22);
		try
		{
			HorarioDAO.getInstancia().alta(h);
		} catch (Exception e)
		{
			assertFalse(true);
		}
		assertTrue(true);
	}
	
	public void testGetHorario() throws Exception{
		assertNotNull(HorarioDAO.getInstancia().getHorario(1));
	}

}
