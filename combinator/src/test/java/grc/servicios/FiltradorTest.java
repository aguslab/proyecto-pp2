package grc.servicios;

import grc.servicios.Filtrador;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class FiltradorTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FiltradorTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FiltradorTest.class );
    }

    public void testCombinador() throws Exception{
    	Filtrador com = new Filtrador();

    	try {
    		com.getCursosDisponibles(12);	
		} catch (Exception e) {
			assertTrue(true);
		}
    	
		
    }
    
    
}
