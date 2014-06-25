package grc.servicios;

import grc.dominio.Carrera;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FiltroCursoPorCarrerasTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FiltroCursoPorCarrerasTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FiltroCursoPorCarrerasTest.class );
    }
    
	public void testFiltroPorCarreras() throws Exception
	{
		IUniversidad uni = new UNGS();
		Carrera c = uni.getCarreraFromAlumno("Gohan");
		IFiltro f = new FiltroCursosPorCarrera(c);
		
		assertNotNull(f.filtrar(uni.getCursos()));
	}

	
}
