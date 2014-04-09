package com.laboratorio.dao;

import java.util.List;

import com.laboratorio.modelo.Materia;
import com.laboratorio.modelo.MateriaAprobada;

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
    	Materia M = new Materia("Programacion I");
    	MateriaAprobada MA = new MateriaAprobada(M,9);
    	
    	MateriaAprobadaDAO.getInstancia().alta(MA);
    	
    	assertEquals(true, true);
    }
    
    public void testObtenerTodasLasMateriasAprobadas() throws Exception{
    	List<MateriaAprobada> materias = MateriaAprobadaDAO.getInstancia().obtenerTodo();
    	
    	assertNotNull(materias);
    }
    
}
