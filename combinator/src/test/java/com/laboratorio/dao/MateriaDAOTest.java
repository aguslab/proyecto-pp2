package com.laboratorio.dao;

import java.util.List;

import com.laboratorio.modelo.Materia;

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

    public void testAltaMateria() throws Exception{
    	Materia M = new Materia("Programacion I");
    	MateriaDAO.getInstancia().alta(M);
    	
    	assertEquals(true, true);
    }
    
    public void testObtenerMateria() throws Exception{
    	Materia M = MateriaDAO.getInstancia().getMateria(1);
    	
    	assertNotNull(M);
    }
    
    public void testObtenerTodasLasMaterias() throws Exception{
    	List<Materia> materias = MateriaDAO.getInstancia().obtenerTodo();
    	
    	assertNotNull(materias);
    }
    
}
