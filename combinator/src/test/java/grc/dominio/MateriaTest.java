package grc.dominio;

import java.sql.Timestamp;
import java.util.Date;

import grc.dominio.Materia;
import grc.dominio.MateriaAprobada;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MateriaTest extends TestCase
{
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public MateriaTest(String testName)
	{
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite(MateriaTest.class);
	}

	public void testMateria()
	{
		Materia m = new Materia();
		m.setId(1);
		m.setNombre("M");

		assertEquals("M", m.getNombre());
	}

	public void testMateriaEqual()
	{
		Materia m = new Materia();
		m.setId(1);
		m.setNombre("M");

		Materia M = new Materia("N");
		M.setId(1);
		assertFalse(m.equals(M));
	}

	public void testMateriaEqualConMismaMateria()
	{
		Materia m = new Materia();
		m.setId(1);
		m.setNombre("M");

		assertTrue(m.equals(m));
	}

	public void testMateriaEqualConNull()
	{
		Materia m = new Materia();
		m.setId(1);
		m.setNombre("M");

		Materia M = null;
		assertFalse(m.equals(M));
	}

	public void testMateriaEqualConDistintaClase()
	{
		Materia m = new Materia();
		m.setId(1);
		m.setNombre("M");
		Timestamp f = new Timestamp(new Date().getTime());
		MateriaAprobada M = new MateriaAprobada(m, 8, f);
		assertFalse(m.equals(M));
	}

	public void testMateriaEqualDistintoId()
	{
		Materia m = new Materia();
		m.setId(1);
		m.setNombre("M");

		Materia M = new Materia();
		M.setId(2);
		M.setNombre("M");
		assertFalse(m.equals(M));
	}

	public void testMateriaEqualNombreMateriaNull()
	{
		Materia m = new Materia();
		m.setId(1);
		m.setNombre("M");

		Materia M = new Materia();
		M.setId(1);
		assertFalse(m.equals(M));
	}

	public void testMateriaEqualNombreMateriaNullyNoNull()
	{
		Materia m = new Materia();
		m.setId(1);

		Materia M = new Materia();
		M.setId(1);
		M.setNombre("N");
		assertFalse(m.equals(M));
	}
	
	public void testMateriaEqualNombreMateriaNullConNull()
	{
		Materia m = new Materia();
		m.setId(1);

		Materia M = new Materia();
		M.setId(1);
		assertTrue(m.equals(M));
	}

	public void testMateriaHashCode()
	{
		Materia m = new Materia();
		m.setId(1);
		m.setNombre("M");

		Materia M = new Materia("M");
		M.setId(1);
		assertEquals(m.hashCode(), M.hashCode());
	}

	public void testMateriaHashCodeConNombreNull()
	{
		Materia m = new Materia();
		m.setId(1);
		Materia M = new Materia();
		M.setId(1);
		assertEquals(m.hashCode(), M.hashCode());
	}
}
