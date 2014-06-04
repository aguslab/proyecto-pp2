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
		Universidad uni = new Universidad();
		assertNotNull(uni.getCarrerraFromAlumno("goku"));
	}
	
	public void testUniversidadGetCursos()
	{
		Universidad uni = new Universidad();
		Carrera c = new Carrera("ABC");
		assertNotNull(uni.getCursosFromCarrera(c));
	}
	
	public void testUniversidadGetCursosFail()
	{
		Universidad uni = new Universidad();
		assertNull(uni.getCursosFromCarrera(null));
	}
	
	public void testUniversidadGetPlanEstudio() throws Exception
	{
		Universidad uni = new Universidad();
		Carrera c = new Carrera("A1");
		assertNotNull(uni.getPlanEstudioFromCarrera(c));
	}
	
	public void testUniversidadGetPlanEstudioFail() throws Exception
	{
		Universidad uni = new Universidad();
		assertNull(uni.getPlanEstudioFromCarrera(null));
	}
	
	public void testUniversidadGetMateriasAprobadas() throws Exception
	{
		Universidad uni = new Universidad();
		assertNotNull(uni.getMateriasAprobadasFromAlumno("Gohan"));
	}
}
