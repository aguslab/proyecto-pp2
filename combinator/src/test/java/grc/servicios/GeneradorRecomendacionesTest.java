package grc.servicios;

import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.Dia;
import grc.dominio.Horario;
import grc.dominio.Materia;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GeneradorRecomendacionesTest extends TestCase
{
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public GeneradorRecomendacionesTest(String testName)
	{
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite(GeneradorRecomendacionesTest.class);
	}
	
	public void testgenerarRecomendaciones() throws Exception
	{
		Set<Curso> cursosDisp = new HashSet<Curso>();
		Materia calculo1 = new Materia("Calculo I");
		Materia psec = new Materia("Problemas Socioeconómicos contemporáneos");
		Materia lecto = new Materia("Taller de Lectoescritura");
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario(Dia.LUNES, 18., 20.));
		h.add(new Horario(Dia.MIERCOLES, 18., 20.));
		List<Horario> h2 = new ArrayList<Horario>();
		h2.add(new Horario(Dia.LUNES, 18., 20.));
		List<Horario> h3 = new ArrayList<Horario>();
		h3.add(new Horario(Dia.MIERCOLES, 18., 20.));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		Curso c1 = new Curso(c, calculo1, h, "01");
		Curso c2 = new Curso(c, psec, h2, "01");
		Curso c3 = new Curso(c, lecto, h3, "01");
		cursosDisp.add(c1);
		cursosDisp.add(c2);
		cursosDisp.add(c3);

		List<Curso> cursosFiltrados = new ArrayList<Curso>(cursosDisp);
		
		GeneradorRecomendaciones gr = new GeneradorRecomendaciones(5,true);
		List<Recomendacion> recomendaciones = gr.generarRecomendaciones(cursosFiltrados);
		
		assertNotNull(recomendaciones);
	}
	
	public void testGeneracionCompletada() throws Exception
	{
		Set<Curso> cursosDisp = new HashSet<Curso>();
		Materia calculo1 = new Materia("Calculo I");
		Materia psec = new Materia("Problemas Socioeconómicos contemporáneos");
		Materia lecto = new Materia("Taller de Lectoescritura");
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario(Dia.LUNES, 18., 20.));
		h.add(new Horario(Dia.MIERCOLES, 18., 20.));
		List<Horario> h2 = new ArrayList<Horario>();
		h2.add(new Horario(Dia.LUNES, 18., 20.));
		List<Horario> h3 = new ArrayList<Horario>();
		h3.add(new Horario(Dia.MIERCOLES, 18., 20.));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		Curso c1 = new Curso(c, calculo1, h, "01");
		Curso c2 = new Curso(c, psec, h2, "01");
		Curso c3 = new Curso(c, lecto, h3, "01");
		cursosDisp.add(c1);
		cursosDisp.add(c2);
		cursosDisp.add(c3);

		List<Curso> cursosFiltrados = new ArrayList<Curso>(cursosDisp);
		
		GeneradorRecomendaciones gr = new GeneradorRecomendaciones(5,true);
		List<Recomendacion> recomendaciones = gr.generarRecomendaciones(cursosFiltrados);
		
		assertTrue(gr.generacionRecomendacionesCompletada());
	}
}
