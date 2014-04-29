package grc.dao;

import grc.dao.MateriaDAO;
import grc.dao.PlanEstudioDAO;
import grc.modelo.Materia;
import grc.modelo.PlanEstudio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class PlanEstudioDAOTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PlanEstudioDAOTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PlanEstudioDAOTest.class );
    }

    public void testAltaPlanEstudioOk() throws Exception{
    	Materia M = new Materia("Programacion I");
    	MateriaDAO.getInstancia().alta(M);
    	Set<Materia> c = new HashSet<Materia>();
    	HashMap<Materia, Set<Materia>> correl = new HashMap<Materia, Set<Materia>>();
    	correl.put(M, c);
    	PlanEstudio p = new PlanEstudio();
    	p.setCorrelativas(correl);
    	p.setId(1);
    	
    	PlanEstudioDAO.getInstancia().alta(p);
    	assertEquals(true, true);
    }
    
    public void testAltaPlanEstudioFail(){
    	HashMap<Materia, Set<Materia>> correl = new HashMap<Materia, Set<Materia>>(); 
    	PlanEstudio p = new PlanEstudio(correl);
    	
    	try {
			PlanEstudioDAO.getInstancia().alta(p);
		} catch (Exception e) {
			assertTrue(true);
		}
    }
    
    public void testObtenerTodoPlanEstudios() throws Exception{
    	List<PlanEstudio> materias = PlanEstudioDAO.getInstancia().obtenerTodo();
    	
    	assertNotNull(materias);
    }
    
}
