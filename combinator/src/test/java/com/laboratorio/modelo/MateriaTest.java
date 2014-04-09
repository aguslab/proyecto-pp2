package com.laboratorio.modelo;

import com.laboratorio.modelo.Materia;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MateriaTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MateriaTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MateriaTest.class );
    }

    public void testMateria(){
    	Materia m = new Materia();
    	m.setId(1);
    	m.setNombre("M");
    	
    	assertEquals("M", m.getNombre());
    }
    
    public void testMateriaEqual(){
    	Materia m = new Materia();
    	m.setId(1);
    	m.setNombre("M");
    	
    	Materia M = new Materia("N");
    	M.setId(1);
    	assertFalse(m.equals(M));
    }
    
    public void testMateriaHashCode(){
    	Materia m = new Materia();
    	m.setId(1);
    	m.setNombre("M");
    	
    	Materia M = new Materia("M");
    	M.setId(1);
    	assertEquals(m.hashCode(),M.hashCode());
    }
    
}
