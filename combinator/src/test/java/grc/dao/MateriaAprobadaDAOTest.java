package grc.dao;

import grc.dao.MateriaAprobadaDAO;
import grc.dominio.Materia;
import grc.dominio.MateriaAprobada;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MateriaAprobadaDAOTest extends TestCase
{
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public MateriaAprobadaDAOTest(String testName)
	{
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite(MateriaAprobadaDAOTest.class);
	}

	public void testAltaMateriaAprobadaOk() throws Exception
	{
		Materia M = new Materia("C");
		Timestamp f = new Timestamp(new Date().getTime());
		MateriaAprobada MA = new MateriaAprobada(M, 7, f);
		int cantAntes = MateriaAprobadaDAO.getInstancia().obtenerTodo().size();
		M.setId(MateriaDAO.getInstancia().obtenerTodo().size() + 1);
		MateriaAprobadaDAO.getInstancia().alta(MA);
		int cantDespues = MateriaAprobadaDAO.getInstancia().obtenerTodo().size();
		assertEquals(cantAntes + 1, cantDespues);
	}

	public void testAltaMateriaAprobadaFail()
	{
		MateriaAprobada M = new MateriaAprobada();
		try
		{
			MateriaAprobadaDAO.getInstancia().alta(M);
		} catch (Exception e)
		{
			assertTrue(true);
		}
	}

	public void testAltaMateriaAprobada() throws Exception
	{
		Materia M = new Materia("D");
		Timestamp f = new Timestamp(new Date().getTime());
		MateriaAprobada MA = new MateriaAprobada(M, 7, f);
		int cantAntes = MateriaAprobadaDAO.getInstancia().obtenerTodo().size();
		MA.setId(cantAntes+1);
		M.setId(MateriaDAO.getInstancia().obtenerTodo().size() + 1);
		MateriaAprobadaDAO.getInstancia().alta(MA);
		int cantDespues = MateriaAprobadaDAO.getInstancia().obtenerTodo().size();
		assertEquals(cantAntes + 1, cantDespues);
	}

	public void testObtenerTodasLasMateriasAprobadas() throws Exception
	{
		List<MateriaAprobada> materias = MateriaAprobadaDAO.getInstancia().obtenerTodo();
		assertNotNull(materias);
	}

}
