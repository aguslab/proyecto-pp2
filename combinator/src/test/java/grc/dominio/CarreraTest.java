package grc.dominio;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CarreraTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CarreraTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CarreraTest.class );
    }

    public void testCarreraNombre(){
    	Carrera c = new Carrera();
    	c.setNombre("Lic");
    	
    	assertEquals("Lic", c.getNombre());
    }
    
}
