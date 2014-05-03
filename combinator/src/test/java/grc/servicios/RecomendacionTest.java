package grc.servicios;

import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.Horario;
import grc.dominio.Materia;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class RecomendacionTest extends TestCase
{
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public RecomendacionTest(String testName)
	{
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite(RecomendacionTest.class);
	}

	public void testRecomendacionLunesMartesMiercoles() throws Exception
	{
		Materia m = new Materia("M");
		Materia mn = new Materia("N");
		Materia mt = new Materia("T");
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario("LUNES", 18, 22));
		h.add(new Horario("MARTES", 18, 20));
		List<Horario> h2 = new ArrayList<Horario>();
		h2.add(new Horario("LUNES", 18, 20));
		h2.add(new Horario("MIERCOLES", 20, 22));
		List<Horario> h3 = new ArrayList<Horario>();
		h2.add(new Horario("MARTES", 20, 22));
		h2.add(new Horario("MIERCOLES", 20, 22));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		List<Carrera> ca = new ArrayList<Carrera>();
		ca.add(c);
		c.setId(0);
		Curso c1 = new Curso(ca, mn, h);
		Curso c2 = new Curso(ca, m, h2);
		Curso c3 = new Curso(ca, mt, h3);

		ArrayList<Curso> cursos = new ArrayList<Curso>();
		cursos.add(c1);
		cursos.add(c2);
		cursos.add(c3);
		Recomendacion reco = new Recomendacion();
		assertNotNull(reco.backtracking(cursos));
	}

	public void testRecomendacionJuevesViernesSabado() throws Exception
	{
		Materia m = new Materia("M");
		Materia mn = new Materia("N");
		Materia mt = new Materia("T");
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario("JUEVES", 18, 22));
		List<Horario> h2 = new ArrayList<Horario>();
		h2.add(new Horario("VIERNES", 18, 20));
		h2.add(new Horario("SABADO", 8, 12));
		List<Horario> h3 = new ArrayList<Horario>();
		h2.add(new Horario("JUEVES", 20, 22));
		h2.add(new Horario("VIERNES", 8, 12));
		List<Horario> h4 = new ArrayList<Horario>();
		h4.add(new Horario("SABADO", 10, 12));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		List<Carrera> ca = new ArrayList<Carrera>();
		ca.add(c);
		c.setId(0);
		Curso c1 = new Curso(ca, mn, h);
		Curso c2 = new Curso(ca, m, h2);
		Curso c3 = new Curso(ca, mt, h3);
		Curso c4 = new Curso(ca, mt, h4);

		ArrayList<Curso> cursos = new ArrayList<Curso>();
		cursos.add(c1);
		cursos.add(c2);
		cursos.add(c3);
		cursos.add(c4);
		Recomendacion reco = new Recomendacion();
		reco.backtracking(cursos);
		assertNotNull(reco.getRecomendacion());
	}

	public void testRecomendacionFinishOkGeneracionRecos() throws Exception
	{
		Materia m = new Materia("M");
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario("JUEVES", 18, 22));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		List<Carrera> ca = new ArrayList<Carrera>();
		ca.add(c);
		c.setId(0);
		Curso c1 = new Curso(ca, m, h);

		ArrayList<Curso> cursos = new ArrayList<Curso>();
		cursos.add(c1);
		Recomendacion reco = new Recomendacion();
		reco.backtracking(cursos);
		assertTrue(reco.isFinishRecoOK());
	}

	public void testRecomendacionDiaInexistente() throws Exception
	{
		Materia m = new Materia("M");
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario("wtf", 18, 22));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		List<Carrera> ca = new ArrayList<Carrera>();
		ca.add(c);
		c.setId(0);
		Curso c1 = new Curso(ca, m, h);

		ArrayList<Curso> cursos = new ArrayList<Curso>();
		cursos.add(c1);
		Recomendacion reco = new Recomendacion();
		reco.backtracking(cursos);
		assertEquals(0, reco.getRecomendacion().size());
	}
}
