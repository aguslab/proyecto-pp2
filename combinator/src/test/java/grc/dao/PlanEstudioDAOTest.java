package grc.dao;

import grc.dao.MateriaDAO;
import grc.dao.PlanEstudioDAO;
import grc.dominio.Carrera;
import grc.dominio.Materia;
import grc.dominio.PlanEstudio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class PlanEstudioDAOTest extends TestCase
{
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public PlanEstudioDAOTest(String testName)
	{
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite(PlanEstudioDAOTest.class);
	}

	public void testAltaPlanEstudioOk() throws Exception
	{
		Materia M = new Materia("Programacion I");
		MateriaDAO.getInstancia().alta(M);
		Set<Materia> c = new HashSet<Materia>();
		HashMap<Materia, Set<Materia>> correl = new HashMap<Materia, Set<Materia>>();
		correl.put(M, c);
		Carrera ca = new Carrera("A");
		ca.setId(CarreraDAO.getInstancia().obtenerTodo().size() + 1);
		PlanEstudio p = new PlanEstudio(ca, correl);
		int cantAntes = PlanEstudioDAO.getInstancia().obtenerTodo().size();
		PlanEstudioDAO.getInstancia().alta(p);
		int cantDespues = PlanEstudioDAO.getInstancia().obtenerTodo().size();
		assertEquals(cantAntes + 1, cantDespues);
	}

	public void testAltaPlanEstudioFail()
	{
		PlanEstudio p = new PlanEstudio();

		try
		{
			PlanEstudioDAO.getInstancia().alta(p);
		} catch (Exception e)
		{
			assertTrue(true);
		}
	}

	public void testAltaPlanEstudio() throws Exception
	{
//		Materia M = new Materia("Pr");
//		MateriaDAO.getInstancia().alta(M);
//		Set<Materia> c = new HashSet<Materia>();
		HashMap<Materia, Set<Materia>> correl = new HashMap<Materia, Set<Materia>>();
//		correl.put(M, c);
		Carrera ca = new Carrera("B");
		ca.setId(CarreraDAO.getInstancia().obtenerTodo().size() + 1);
		PlanEstudio p = new PlanEstudio(ca, correl);
		int cantAntes = PlanEstudioDAO.getInstancia().obtenerTodo().size();
		p.setId(cantAntes+1);
		PlanEstudioDAO.getInstancia().alta(p);
		int cantDespues = PlanEstudioDAO.getInstancia().obtenerTodo().size();
		assertEquals(cantAntes + 1, cantDespues);
	}

	public void testObtenerTodoPlanEstudios() throws Exception
	{
		List<PlanEstudio> pes = PlanEstudioDAO.getInstancia().obtenerTodo();
		assertNotNull(pes);
	}

	public void testPlanEstudioDeCarrera() throws Exception
	{
		Carrera c = CarreraDAO.getInstancia().getCarrera(0);
		PlanEstudio pe = PlanEstudioDAO.getInstancia().getPlanEstudioDeCarrera(c);
		assertNotNull(pe);
	}

}
