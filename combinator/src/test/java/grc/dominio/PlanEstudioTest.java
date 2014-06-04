package grc.dominio;

import grc.app.Alta_mat_cur_matApr;
import grc.dominio.PlanEstudio;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class PlanEstudioTest extends TestCase
{
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public PlanEstudioTest(String testName)
	{
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite(PlanEstudioTest.class);
	}

	public void testPlanEstudioId()
	{
		PlanEstudio pe = new PlanEstudio();
		pe.setId(1);
		assertEquals(1, pe.getId());
	}

	public void testPlanEstudioCarrera()
	{
		Carrera c = new Carrera("G");
		PlanEstudio pe = new PlanEstudio(c, null);
		pe.setId(1);
		assertEquals("G", pe.getCarrera().getNombre());
	}
	
	public void testPlanEstudioCantPoscorrelativasCero()
	{
		Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
		a.init();
		PlanEstudio pe = a.getPlanEstudios();
		Materia lecto = new Materia("Taller de Lectoescritura");
		int actual = pe.getCantidadPoscorrelativas(lecto);
		assertEquals(0, actual);
	}
	
	public void testPlanEstudioCantPoscorrelativasPositivo()
	{
		Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
		a.init();
		PlanEstudio pe = a.getPlanEstudios();
		Materia ingles1 = new Materia("Ingles Lectocomprension I");
		int actual = pe.getCantidadPoscorrelativas(ingles1);
		assertEquals(1, actual);
	}
	
	public void testPlanEstudioCorrelativasOk()
	{
		Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
		a.init();
		PlanEstudio pe = a.getPlanEstudios();
		Materia ingles1 = new Materia("Ingles Lectocomprension I");
		assertNotNull(pe.getCorrelativas(ingles1));
	}
	
//	public void testPlanEstudioCorrelativasFail()
//	{
//		Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
//		a.init();
//		PlanEstudio pe = a.getPlanEstudios();
//		Materia abc = new Materia("ABC");
//		pe.getCorrelativas(abc);
//	}
}
