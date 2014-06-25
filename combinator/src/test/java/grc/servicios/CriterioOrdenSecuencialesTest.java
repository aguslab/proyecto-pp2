package grc.servicios;

import grc.app.Persistor;
import grc.controlador.GRCControlador;
import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.Dia;
import grc.dominio.Horario;
import grc.dominio.Materia;
import grc.dominio.PlanEstudio;
import grc.modelo.EstadoFiltros;
import grc.modelo.GRCModelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CriterioOrdenSecuencialesTest extends TestCase
{
	public CriterioOrdenSecuencialesTest(String testName)
	{
		super(testName);
	}
	
	public static Test suite()
	{
		return new TestSuite(CriterioOrdenSecuencialesTest.class);
	}
	
	private PlanEstudio getPlanEstudio()
	{
		Persistor a = new Persistor();
		a.init();
		return a.getPlanEstudios();
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
	
	private EstadoFiltros getEstadoFiltro()
	{
		return new EstadoFiltros(true, true, true, true);
	}
	
	public void testCriterioSecuencialCompare() throws Exception
	{
		Set<Curso> cursosDisp = new HashSet<Curso>();
		Materia calculo1 = new Materia("Calculo I");
		Materia ingles1 = new Materia("Ingles Lectocomprension I");
		Materia lecto = new Materia("Taller de Lectoescritura");
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario(Dia.LUNES, 18., 20.));
		List<Horario> h2 = new ArrayList<Horario>();
		h2.add(new Horario(Dia.MARTES, 18., 20.));
		List<Horario> h3 = new ArrayList<Horario>();
		h3.add(new Horario(Dia.MIERCOLES, 18., 20.));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		Curso c1 = new Curso(c, calculo1, h, "01");
		Curso c2 = new Curso(c, ingles1, h2, "01");
		Curso c3 = new Curso(c, lecto, h3, "01");
		cursosDisp.add(c1);
		cursosDisp.add(c2);
		cursosDisp.add(c3);
		CriterioOrden co1 = new CriterioOrdenPorPoscorrelativas(getPlanEstudio());

		GRCModelo model = new GRCModelo(cursosDisp, co1, 0);

		GRCControlador controller = new GRCControlador(model, getCriterioMap(), getEstadoFiltro());
		controller.filtrarNoche(true);
		controller.setCriterioOrdenamiento("Ambos");
		
		Recomendacion r = model.getRecomendaciones().get(0);
		Recomendacion r2 = model.getRecomendaciones().get(1);
		assertEquals(0,co1.compare(r, r2));
	}
	
	public void testCriterioSecuencialCompare2() throws Exception
	{
		Set<Curso> cursosDisp = new HashSet<Curso>();
		Materia ingles1 = new Materia("Ingles Lectocomprension I");
		Materia lecto = new Materia("Taller de Lectoescritura");
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario(Dia.LUNES, 18., 20.));
		List<Horario> h2 = new ArrayList<Horario>();
		h.add(new Horario(Dia.MARTES, 18., 20.));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		Curso c1 = new Curso(c, ingles1, h, "01");
		Curso c2 = new Curso(c, lecto, h2, "01");
		cursosDisp.add(c1);
		cursosDisp.add(c2);
		CriterioOrden co1 = new CriterioOrdenPorPoscorrelativas(getPlanEstudio());

		GRCModelo model = new GRCModelo(cursosDisp, co1, 0);

		GRCControlador controller = new GRCControlador(model, getCriterioMap(), getEstadoFiltro());
		controller.filtrarNoche(true);
		controller.setCriterioOrdenamiento("Ambos");
		
		Recomendacion r = model.getRecomendaciones().get(0);
		Recomendacion r2 = model.getRecomendaciones().get(1);
		assertEquals(0,co1.compare(r, r2));
	}
}
