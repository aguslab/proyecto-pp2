package grc.dominio;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class DiaTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DiaTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DiaTest.class );
    }

    public void testDiaLunes(){
    	Dia lunes = Dia.LUNES;
    	assertEquals("LUNES", lunes.name());
    }
    
}
