package grc.dao;

import grc.dao.MateriaDAO;
import grc.dominio.Materia;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MateriaDAOTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MateriaDAOTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MateriaDAOTest.class );
    }

    public void testAltaMateriaOk() throws Exception{
    	Materia M = new Materia("Prog");
    	int cantAntes = MateriaDAO.getInstancia().obtenerTodo().size();
    	MateriaDAO.getInstancia().alta(M);
    	int cantDespues = MateriaDAO.getInstancia().obtenerTodo().size();
    	assertEquals(cantAntes+1, cantDespues);
    }
    
    public void testAltaMateriaFail() {
    	Materia M = new Materia();
    	try {
			MateriaDAO.getInstancia().alta(M);
		} catch (Exception e) {
			assertTrue(true);
		}
    }
    
    public void testAltaMateria() throws Exception
	{
		Materia M = new Materia("D");
		int cantAntes = MateriaDAO.getInstancia().obtenerTodo().size();
		M.setId(cantAntes+1);
		MateriaDAO.getInstancia().alta(M);
		int cantDespues = MateriaDAO.getInstancia().obtenerTodo().size();
		assertEquals(cantAntes + 1, cantDespues);
	}
    
    public void testObtenerMateria() throws Exception {
		Materia m = MateriaDAO.getInstancia().getMateria(1);
    	assertNotNull(m);
    }
    
    public void testObtenerTodasLasMaterias() throws Exception{
    	List<Materia> materias = MateriaDAO.getInstancia().obtenerTodo();
    	assertNotNull(materias);
    }
    
    public void testgetMateria() throws Exception{
    	Materia materia = MateriaDAO.getInstancia().getMateria("Ingles Lectocomprension I");
    	assertNotNull(materia);
    }
    
}
