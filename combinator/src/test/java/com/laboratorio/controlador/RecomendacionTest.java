package com.laboratorio.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.laboratorio.controlador.GRCController;
import com.laboratorio.dao.CursoDAO;
import com.laboratorio.modelo.Curso;
import com.laboratorio.modelo.Horario;
import com.laboratorio.modelo.Materia;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class RecomendacionTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RecomendacionTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( RecomendacionTest.class );
    }

    public void testCombinador() {
    	
		try {
			GRCController.main(null);
		} catch (Exception e) {
			assertTrue(false);
		}
		
		assertTrue(true);
    }
    
    
}
