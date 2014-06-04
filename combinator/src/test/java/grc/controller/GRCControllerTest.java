package grc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

import grc.app.Alta_mat_cur_matApr;
import grc.controlador.GRCControlador;
import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.Dia;
import grc.dominio.Horario;
import grc.dominio.Materia;
import grc.dominio.PlanEstudio;
import grc.modelo.EstadoFiltros;
import grc.modelo.GRCModelo;
import grc.servicios.CriterioOrden;
import grc.servicios.CriterioOrdenPorMaterias;
import grc.servicios.CriterioOrdenPorPoscorrelativas;
import grc.servicios.CriterioOrdenSecuenciales;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class GRCControllerTest extends TestCase
{
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public GRCControllerTest(String testName)
	{
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite()
	{
		return new TestSuite(GRCControllerTest.class);
	}

	private Map<String, CriterioOrden> getCriterioMap() throws Exception
	{
		CriterioOrden criterioOrdenPorMaterias = new CriterioOrdenPorMaterias(true);
		CriterioOrden criterioOrdenPorPoscorrelativas = new CriterioOrdenPorPoscorrelativas(
				getPlanEstudio());
		List<CriterioOrden> co = new ArrayList<CriterioOrden>();
		co.add(criterioOrdenPorPoscorrelativas);
		co.add(criterioOrdenPorMaterias);
		CriterioOrden criterioOrdenSecuenciales = new CriterioOrdenSecuenciales(co);

		Map<String, CriterioOrden> criterios = new HashMap<String, CriterioOrden>();
		criterios.put("Materias", criterioOrdenPorMaterias);
		criterios.put("Poscorrelativas", criterioOrdenPorPoscorrelativas);
		criterios.put("Ambos", criterioOrdenSecuenciales);
		return criterios;
	}

	private PlanEstudio getPlanEstudio()
	{
		Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
		a.init();
		return a.getPlanEstudios();
	}
	
	private EstadoFiltros getEstadoFiltro(){
		return new EstadoFiltros(true, true, true, true);
	}

	public void testfiltrarTurnos() throws Exception
	{
		Set<Curso> cursosDisp = new HashSet<Curso>();
		Materia m = new Materia("M");
		Materia mn = new Materia("PP2");
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario(Dia.LUNES, 18, 22));
		List<Horario> h2 = new ArrayList<Horario>();
		h2.add(new Horario(Dia.VIERNES, 18, 22));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		List<Carrera> ca = new ArrayList<Carrera>();
		ca.add(c);
		c.setId(0);
		Curso c1 = new Curso(ca, mn, h, "01");
		Curso c2 = new Curso(ca, m, h2, "01");
		cursosDisp.add(c1);
		cursosDisp.add(c2);
		CriterioOrden co = new CriterioOrdenPorMaterias(true);

		GRCModelo model = new GRCModelo(cursosDisp, co, 0);

		GRCControlador controller = new GRCControlador(model, getCriterioMap(), getEstadoFiltro());
		controller.filtrarNoche(true);
		assertNotNull(model.getRecomendaciones());
	}

	public void testfiltrarTurnosDistintasHoras() throws Exception
	{
		Set<Curso> cursosDisp = new HashSet<Curso>();
		Materia m = new Materia("M");
		Materia mn = new Materia("PP2");
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario(Dia.LUNES, 18, 22));
		h.add(new Horario(Dia.MARTES, 18, 22));
		h.add(new Horario(Dia.MIERCOLES, 18, 22));
		List<Horario> h2 = new ArrayList<Horario>();
		h2.add(new Horario(Dia.JUEVES, 18, 22));
		h2.add(new Horario(Dia.VIERNES, 18, 22));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		List<Carrera> ca = new ArrayList<Carrera>();
		ca.add(c);
		c.setId(0);
		Curso c1 = new Curso(ca, mn, h, "01");
		Curso c2 = new Curso(ca, m, h2, "01");
		cursosDisp.add(c1);
		cursosDisp.add(c2);
		CriterioOrden co = new CriterioOrdenPorMaterias(true);

		GRCModelo model = new GRCModelo(cursosDisp, co, 0);

		GRCControlador controller = new GRCControlador(model, getCriterioMap(), getEstadoFiltro());
		controller.filtrarNoche(true);
		assertNotNull(model.getRecomendaciones());
	}
	
	public void testCambiarTablaDias() throws Exception
	{
		Set<Curso> cursosDisp = new HashSet<Curso>();
		Materia m = new Materia("M");
		Materia mn = new Materia("PP2");
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario(Dia.LUNES, 18, 22));
		List<Horario> h2 = new ArrayList<Horario>();
		h2.add(new Horario(Dia.VIERNES, 18, 22));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		List<Carrera> ca = new ArrayList<Carrera>();
		ca.add(c);
		c.setId(0);
		Curso c1 = new Curso(ca, mn, h, "01");
		Curso c2 = new Curso(ca, m, h2, "01");
		cursosDisp.add(c1);
		cursosDisp.add(c2);
		CriterioOrden co = new CriterioOrdenPorMaterias(true);

		GRCModelo model = new GRCModelo(cursosDisp, co, 0);
		GRCControlador controller = new GRCControlador(model, getCriterioMap(), getEstadoFiltro());
		controller.filtrarNoche(true);
		controller.seleccionActualRecomendacion(0);
		DefaultTableModel grilla = controller.cambiarTablaDias(model.getRecomendacionActual());
		assertNotNull(grilla);
	}
	
	public void testCambiarTablaDiasSinRecomendaciones() throws Exception
	{
		Set<Curso> cursosDisp = new HashSet<Curso>();
		CriterioOrden co = new CriterioOrdenPorMaterias(true);

		GRCModelo model = new GRCModelo(cursosDisp, co, 0);
		GRCControlador controller = new GRCControlador(model, getCriterioMap(), getEstadoFiltro());
		controller.filtrarTurnos();
		controller.seleccionActualRecomendacion(0);
		controller.cambiarTablaDias(model.getRecomendacionActual());
		assertEquals(0, model.getRecomendaciones().size());
	}
	
	public void testfiltrarTurnosOrdenandoPorPoscorrelativas() throws Exception
	{
		Set<Curso> cursosDisp = new HashSet<Curso>();
		Materia calculo1 = new Materia("Calculo I");
		Materia psec = new Materia("Problemas Socioeconómicos contemporáneos");
		Materia lecto = new Materia("Taller de Lectoescritura");
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario(Dia.LUNES, 18, 20));
		h.add(new Horario(Dia.MIERCOLES, 18, 20));
		List<Horario> h2 = new ArrayList<Horario>();
		h2.add(new Horario(Dia.LUNES, 18, 20));
		List<Horario> h3 = new ArrayList<Horario>();
		h3.add(new Horario(Dia.MIERCOLES, 18, 20));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		List<Carrera> ca = new ArrayList<Carrera>();
		ca.add(c);
		Curso c1 = new Curso(ca, calculo1, h, "01");
		Curso c2 = new Curso(ca, psec, h2, "01");
		Curso c3 = new Curso(ca, lecto, h3, "01");
		cursosDisp.add(c1);
		cursosDisp.add(c2);
		cursosDisp.add(c3);
		CriterioOrden co = new CriterioOrdenPorPoscorrelativas(getPlanEstudio());

		GRCModelo model = new GRCModelo(cursosDisp, co, 0);

		GRCControlador controller = new GRCControlador(model, getCriterioMap(), getEstadoFiltro());
		controller.filtrarNoche(true);
		controller.setCriterioOrdenamiento("Poscorrelativas");
		assertEquals(1, model.getRecomendaciones().get(0).getRecomendacion().size());
	}
	
	public void testfiltrarTurnosOrdenandoPorSecuenciales() throws Exception
	{
		Set<Curso> cursosDisp = new HashSet<Curso>();
		Materia calculo1 = new Materia("Calculo I");
		Materia ingles1 = new Materia("Ingles Lectocomprension I");
		Materia lecto = new Materia("Taller de Lectoescritura");
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario(Dia.LUNES, 18, 20));
		List<Horario> h2 = new ArrayList<Horario>();
		h2.add(new Horario(Dia.MARTES, 18, 20));
		List<Horario> h3 = new ArrayList<Horario>();
		h3.add(new Horario(Dia.MIERCOLES, 18, 20));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		List<Carrera> ca = new ArrayList<Carrera>();
		ca.add(c);
		Curso c1 = new Curso(ca, calculo1, h, "01");
		Curso c2 = new Curso(ca, ingles1, h2, "01");
		Curso c3 = new Curso(ca, lecto, h3, "01");
		cursosDisp.add(c1);
		cursosDisp.add(c2);
		cursosDisp.add(c3);
		CriterioOrden co1 = new CriterioOrdenPorPoscorrelativas(getPlanEstudio());

		GRCModelo model = new GRCModelo(cursosDisp, co1, 0);

		GRCControlador controller = new GRCControlador(model, getCriterioMap(), getEstadoFiltro());
		controller.filtrarNoche(true);
		controller.setCriterioOrdenamiento("Ambos");
		assertEquals(3, model.getRecomendaciones().get(0).getRecomendacion().size());
	}
	
	public void testfiltrarTurnosOrdenandoPorSecuenciales2() throws Exception
	{
		Set<Curso> cursosDisp = new HashSet<Curso>();
		Materia calculo1 = new Materia("Calculo I");
		Materia ingles1 = new Materia("Ingles Lectocomprension I");
		Materia lecto = new Materia("Taller de Lectoescritura");
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario(Dia.LUNES, 18, 22));
		List<Horario> h2 = new ArrayList<Horario>();
		h2.add(new Horario(Dia.LUNES, 18, 20));
		List<Horario> h3 = new ArrayList<Horario>();
		h3.add(new Horario(Dia.LUNES, 20, 22));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		List<Carrera> ca = new ArrayList<Carrera>();
		ca.add(c);
		Curso c1 = new Curso(ca, calculo1, h, "01");
		Curso c2 = new Curso(ca, ingles1, h2, "01");
		Curso c3 = new Curso(ca, lecto, h3, "01");
		cursosDisp.add(c1);
		cursosDisp.add(c2);
		cursosDisp.add(c3);
		CriterioOrden co1 = new CriterioOrdenPorMaterias(true);

		GRCModelo model = new GRCModelo(cursosDisp, co1, 0);

		CriterioOrden criterioOrdenPorMaterias = new CriterioOrdenPorMaterias(true);
		CriterioOrden criterioOrdenPorPoscorrelativas = new CriterioOrdenPorPoscorrelativas(
				getPlanEstudio());
		List<CriterioOrden> co = new ArrayList<CriterioOrden>();
		co.add(criterioOrdenPorMaterias);
		co.add(criterioOrdenPorPoscorrelativas);
		CriterioOrden criterioOrdenSecuenciales = new CriterioOrdenSecuenciales(co);

		Map<String, CriterioOrden> criterios = new HashMap<String, CriterioOrden>();
		criterios.put("Materias", criterioOrdenPorMaterias);
		criterios.put("Poscorrelativas", criterioOrdenPorPoscorrelativas);
		criterios.put("Ambos", criterioOrdenSecuenciales);
		GRCControlador controller = new GRCControlador(model, criterios, getEstadoFiltro());
		controller.filtrarNoche(true);
		controller.setCriterioOrdenamiento("Ambos");
		assertEquals(2, model.getRecomendaciones().get(0).getRecomendacion().size());
	}
}
