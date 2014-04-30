package grc.modelo;

import grc.modelo.Materia;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class PlanEstudioTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PlanEstudioTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PlanEstudioTest.class );
    }

    public void testPlanEstudioId(){
    	PlanEstudio pe = new PlanEstudio();
    	pe.setId(1);
    	assertEquals(1, pe.getId());
    }
    
}
