package grc.servicios;

import grc.app.Persistor;
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

public class FiltroCorrelativasTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FiltroCorrelativasTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FiltroCorrelativasTest.class );
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
		Persistor a = new Persistor();
		a.init();
		return a.getPlanEstudios();
	}
	
	private EstadoFiltros getEstadoFiltro(){
		return new EstadoFiltros(true, true, true, true);
	}
    
	public void testFiltroCorrelativas() throws Exception
	{
		Set<Curso> cursosDisp = new HashSet<Curso>();
		Materia prog1 = new Materia("Programación I", "P1");
		Materia prog2 = new Materia("Programación II", "P2");
		Materia ip = new Materia("Introducción a la Programación", "Intro. Programación");

		Set<Materia> materiasAprobadas = new HashSet<Materia>();
		materiasAprobadas.add(ip);
		
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario(Dia.LUNES, 18., 22.));
		List<Horario> h2 = new ArrayList<Horario>();
		h2.add(new Horario(Dia.VIERNES, 18., 22.));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		c.setId(0);
		
		Curso c1 = new Curso(c, prog1, h, "01");
		Curso c2 = new Curso(c, prog2, h2, "01");
		Curso c3 = new Curso(c, ip, h2, "01");
		
		cursosDisp.add(c1);
		cursosDisp.add(c2);
		cursosDisp.add(c3);
		CriterioOrden co = new CriterioOrdenPorMaterias(true);

		GRCModelo model = new GRCModelo(cursosDisp, co, 0);

//		GRCControlador controller = new GRCControlador(model, getCriterioMap(), getEstadoFiltro());
		
		IFiltro filtro = new FiltroMateriasAprobadas(materiasAprobadas);
		cursosDisp = filtro.filtrar(cursosDisp);
		filtro = new FiltroCorrelativas(materiasAprobadas, getPlanEstudio());
		cursosDisp = filtro.filtrar(cursosDisp);
    	assertEquals(1,cursosDisp.size());
	}
    
	public void testFiltroCorrelativasSinCursos() throws Exception
	{
		Set<Curso> c = new HashSet<Curso>();
		Materia introProg = new Materia("Intro. Prog.");
		Set<Materia> materiasAprobadas = new HashSet<Materia>();
		materiasAprobadas.add(introProg);
		IFiltro f = new FiltroCorrelativas(materiasAprobadas, getPlanEstudio());
		assertTrue(f.filtrar(c).isEmpty());
	}
	
	public void testFiltroCorrelativasSinCorrelativas() throws Exception
	{
		Set<Curso> cursosDisp = new HashSet<Curso>();
		Materia ingles1 = new Materia("Ingles Lectocomprension I", "Inglés 1");
		Materia psec = new Materia("Problemas Socioeconómicos contemporáneos", "PSEC");
		Materia ip = new Materia("Introducción a la Programación", "Intro. Programación");

		Set<Materia> materiasAprobadas = new HashSet<Materia>();
		materiasAprobadas.add(ip);
		
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario(Dia.LUNES, 18., 22.));
		List<Horario> h2 = new ArrayList<Horario>();
		h2.add(new Horario(Dia.VIERNES, 18., 22.));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		c.setId(0);
		
		Curso c1 = new Curso(c, ingles1, h, "01");
		Curso c2 = new Curso(c, psec, h2, "01");
		Curso c3 = new Curso(c, ip, h2, "01");
		
		cursosDisp.add(c1);
		cursosDisp.add(c2);
		cursosDisp.add(c3);
		CriterioOrden co = new CriterioOrdenPorMaterias(true);
		
		IFiltro filtro = new FiltroMateriasAprobadas(materiasAprobadas);
		cursosDisp = filtro.filtrar(cursosDisp);
		filtro = new FiltroCorrelativas(materiasAprobadas, getPlanEstudio());
		cursosDisp = filtro.filtrar(cursosDisp);
    	assertEquals(2,cursosDisp.size());
	}
}
