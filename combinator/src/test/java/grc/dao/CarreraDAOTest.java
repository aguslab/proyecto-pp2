package grc.dao;

import grc.dominio.Carrera;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CarreraDAOTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CarreraDAOTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CarreraDAOTest.class );
    }

    public void testAltaCarreraOk() throws Exception{
    	Carrera c = new Carrera("A");
    	int cantAntes = CarreraDAO.getInstancia().obtenerTodo().size();
    	CarreraDAO.getInstancia().alta(c);
    	int cantDespues = CarreraDAO.getInstancia().obtenerTodo().size();
    	assertEquals(cantAntes+1, cantDespues);
    }
    
    public void testAltaCarreraFail() {
    	Carrera C = new Carrera();
    	try {
			CarreraDAO.getInstancia().alta(C);
		} catch (Exception e) {
			assertTrue(true);
		}
    }
    
    public void testAltaCarrera() throws Exception
	{
    	Carrera c = new Carrera("J");
    	int cantAntes = CarreraDAO.getInstancia().obtenerTodo().size();
		c.setId(cantAntes+1);
		CarreraDAO.getInstancia().alta(c);
		int cantDespues = CarreraDAO.getInstancia().obtenerTodo().size();
		assertEquals(cantAntes + 1, cantDespues);
	}
}
