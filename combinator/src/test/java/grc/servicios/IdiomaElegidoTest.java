package grc.servicios;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class IdiomaElegidoTest extends TestCase
{
	public IdiomaElegidoTest(String testName)
	{
		super(testName);
	}
	
	public static Test suite()
	{
		return new TestSuite(IdiomaElegidoTest.class);
	}
	
	public void testIdiomaElegidoCambiarIdioma()
	{
		IdiomaElegido ie = new IdiomaElegido();
		ie.cambiarIdiomaMsjs();
	}
	
	public void testIdiomaElegidoObtenerIdiomaEn()
	{
		IdiomaElegido ie = new IdiomaElegido();
		IdiomaElegido ie2 = new IdiomaElegido();
		ie2.cambiarIdiomaMsjs();
		assertNotSame(ie, ie2);
	}
	
	public void testIdiomaElegidoObtenerIdiomaEsp()
	{
		IdiomaElegido ie = new IdiomaElegido();
		IdiomaElegido ie2 = new IdiomaElegido();
		ie2.cambiarIdiomaMsjs();;
		ie2.cambiarIdiomaMsjs();;
		assertSame(ie.getIdiomaMsjs(), ie2.getIdiomaMsjs());
	}
	
}
