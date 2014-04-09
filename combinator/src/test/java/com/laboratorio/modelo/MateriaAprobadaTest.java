package com.laboratorio.modelo;

import com.laboratorio.modelo.Materia;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MateriaAprobadaTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MateriaAprobadaTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MateriaAprobadaTest.class );
    }

    public void testMateriaAprobada(){
    	MateriaAprobada m = new MateriaAprobada();
    	m.setId(1);
    	m.setNota(7.5);
    	
    	assertEquals(1, m.getId());
    }
    
    public void testMateriaAprobadasetMateria(){
    	Materia m = new Materia("M");
    	MateriaAprobada ma = new MateriaAprobada(m, 8.0);
    	
    	assertEquals("M", ma.getMateriaAprobada().getNombre());
    }
    
}
