package grc.controlador;

import grc.controlador.GRCController;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class GRCControllerTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GRCControllerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GRCControllerTest.class );
    }

    public void testGRCControllerMain() {
    	
		try {
			GRCController.main(null);
		} catch (Exception e) {
			assertTrue(false);
		}
		
		assertTrue(true);
    }
    
    public void testGRCControllerContructor(){
    	new GRCController();
    }
    
    
}
