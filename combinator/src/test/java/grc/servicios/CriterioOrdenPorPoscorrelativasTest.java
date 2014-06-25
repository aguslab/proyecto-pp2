package grc.servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CriterioOrdenPorPoscorrelativasTest  extends TestCase
{
	public CriterioOrdenPorPoscorrelativasTest(String testName)
	{
		super(testName);
	}
	
	public static Test suite()
	{
		return new TestSuite(CriterioOrdenPorPoscorrelativasTest.class);
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
	
	public void testCriterioEqual()
	{
		CriterioOrden co = new CriterioOrdenPorPoscorrelativas(getPlanEstudio());
		co.setId(1);

		CriterioOrden co2 = new CriterioOrdenPorPoscorrelativas(getPlanEstudio());
		co2.setId(1);
		assertFalse(co.equals(co2));
	}
	
	public void testCriterioPoscorrelativasCompare() throws Exception
	{
		Set<Curso> cursosDisp = new HashSet<Curso>();
		Materia calculo1 = new Materia("Calculo I");
		Materia ingles1 = new Materia("Ingles Lectocomprension I");
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario(Dia.LUNES, 18., 22.));
		List<Horario> h2 = new ArrayList<Horario>();
		h2.add(new Horario(Dia.VIERNES, 18., 22.));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		Curso c1 = new Curso(c, calculo1, h, "01");
		Curso c2 = new Curso(c, ingles1, h2, "01");
		cursosDisp.add(c1);
		cursosDisp.add(c2);
		CriterioOrden co = new CriterioOrdenPorPoscorrelativas(getPlanEstudio());

		GRCModelo model = new GRCModelo(cursosDisp, co, 0);
		GRCControlador controller = new GRCControlador(model,  getCriterioMap(), getEstadoFiltro());
		controller.filtrarNoche(true);
		controller.setCriterioOrdenamiento("Poscorrelativas");
		
		Recomendacion r = model.getRecomendaciones().get(0);
		Recomendacion r2 = model.getRecomendaciones().get(1);
		assertEquals(-1,co.compare(r, r2));
	}

}
