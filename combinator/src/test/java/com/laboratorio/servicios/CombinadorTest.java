package com.laboratorio.servicios;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CombinadorTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CombinadorTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CombinadorTest.class );
    }

    public void testCombinador() throws Exception{
    	Combinador com = new Combinador();

    	try {
    		com.getCursosDisponibles(12);	
		} catch (Exception e) {
			assertTrue(true);
		}
    	
		
    }
    
    
}
