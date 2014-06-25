package grc.servicios;

import grc.dominio.Carrera;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class UniversidadTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public UniversidadTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( UniversidadTest.class );
    }

	public void testUniversidadGetCarrera()
	{
		UNGS uni = new UNGS();
		assertNotNull(uni.getCarreraFromAlumno("goku"));
	}
	
	public void testUniversidadGetCursos()
	{
		UNGS uni = new UNGS();
		assertNotNull(uni.getCursos());
	}
	
	public void testUniversidadGetPlanEstudioOk() throws Exception
	{
		UNGS uni = new UNGS();
		Carrera c = uni.getCarreraFromAlumno("Gohan");
		assertNotNull(uni.getPlanEstudioFromCarrera(c));
	}
	
	public void testUniversidadGetPlanEstudioFail() throws Exception
	{
		UNGS uni = new UNGS();
		Carrera CA = new Carrera("A1");
		CA.setId(100);
		assertNull(uni.getPlanEstudioFromCarrera(CA));
	}
	
}
