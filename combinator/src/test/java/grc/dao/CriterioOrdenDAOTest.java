package grc.dao;

import grc.dao.CriterioOrdenDAO;
import grc.servicios.CriterioOrden;
import grc.servicios.CriterioOrdenPorMaterias;
import grc.servicios.CriterioOrdenPorPoscorrelativas;

import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CriterioOrdenDAOTest extends TestCase {

	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 * @throws Exception 
	 */
	public CriterioOrdenDAOTest(String testName) throws Exception {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(CriterioOrdenDAOTest.class);
	}

	public void testAltaCriterioOrdenOk() throws Exception {
		CriterioOrden criterioOrden = new CriterioOrdenPorMaterias(true);
		criterioOrden.setId(CriterioOrdenDAO.getInstancia().obtenerTodo().size()+1);
		int cantAntes = CriterioOrdenDAO.getInstancia().obtenerTodo().size();
		CriterioOrdenDAO.getInstancia().alta(criterioOrden);
    	int cantDespues = CriterioOrdenDAO.getInstancia().obtenerTodo().size();
    	assertEquals(cantAntes+1, cantDespues);
	}

	public void testAltaCriterioOrdenFail() {
		CriterioOrden c1 = new CriterioOrdenPorPoscorrelativas();
		try {
			CriterioOrdenDAO.getInstancia().alta(c1);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	public void testObtenerCriterioOrden() throws Exception {
		CriterioOrden c = CriterioOrdenDAO.getInstancia().getCriterioOrden(1);
		assertNotNull(c);
	}

	public void testObtenerTodosLosCriterioOrdens() throws Exception {
		List<CriterioOrden> c = CriterioOrdenDAO.getInstancia().obtenerTodo();
		assertNotNull(c);
	}

}
