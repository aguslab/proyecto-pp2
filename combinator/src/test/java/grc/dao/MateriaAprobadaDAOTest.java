package grc.dao;

import grc.dao.MateriaAprobadaDAO;
import grc.modelo.Materia;
import grc.modelo.MateriaAprobada;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MateriaAprobadaDAOTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MateriaAprobadaDAOTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MateriaAprobadaDAOTest.class );
    }

    public void testAltaMateriaAprobadaOk() throws Exception{
    	Materia M = new Materia("C");
    	MateriaAprobada MA = new MateriaAprobada(M,9);
    	int cantAntes = MateriaAprobadaDAO.getInstancia().obtenerTodo().size();
    	M.setId(cantAntes+1);
    	MateriaAprobadaDAO.getInstancia().alta(MA);
    	int cantDespues = MateriaAprobadaDAO.getInstancia().obtenerTodo().size();
    	assertEquals(cantAntes+1, cantDespues);
    }
    
    public void testObtenerTodasLasMateriasAprobadas() throws Exception{
    	List<MateriaAprobada> materias = MateriaAprobadaDAO.getInstancia().obtenerTodo();
    	assertNotNull(materias);
    }
    
}
