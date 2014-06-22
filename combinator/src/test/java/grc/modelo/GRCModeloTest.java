package grc.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.Dia;
import grc.dominio.Horario;
import grc.dominio.Materia;
import grc.servicios.CriterioOrden;
import grc.servicios.CriterioOrdenPorMaterias;
import grc.servicios.FiltroHorarios;
import grc.servicios.IFiltro;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class GRCModeloTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GRCModeloTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GRCModeloTest.class );
    }

    public void testActualizarRecomendaciones() throws Exception{
    	Set<Curso> cursosDisp = new HashSet<Curso>();
    	Materia m = new Materia("M");
		Materia mn = new Materia("N");
		Materia mt = new Materia("T");
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario(Dia.LUNES, 18, 22));
		h.add(new Horario(Dia.MARTES, 18, 20));
		List<Horario> h2 = new ArrayList<Horario>();
		h2.add(new Horario(Dia.LUNES, 18, 20));
		h2.add(new Horario(Dia.MIERCOLES, 20, 22));
		List<Horario> h3 = new ArrayList<Horario>();
		h3.add(new Horario(Dia.MARTES, 20, 22));
		h3.add(new Horario(Dia.MIERCOLES, 20, 22));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		c.setId(0);
		Curso c1 = new Curso(c, mn, h, "01");
		Curso c2 = new Curso(c, m, h2, "01");
		Curso c3 = new Curso(c, mt, h3, "01");
		cursosDisp.add(c1);
		cursosDisp.add(c2);
		cursosDisp.add(c3);
		
		CriterioOrden com = new CriterioOrdenPorMaterias(false);
    	GRCModelo model = new GRCModelo(cursosDisp, com, 1000);
    	
    	List<Horario> lhor = new ArrayList<Horario>();
    	Horario lh1 = new Horario(8, 12);
    	Horario lh2 = new Horario(18, 22);
    	lhor.add(lh1);
    	lhor.add(lh2);
    	IFiltro f = new FiltroHorarios(lhor);
    	Set<Curso> cur = f.filtrar(new HashSet<Curso>(model.getCursosDisponibles()));
    	model.actualizarRecomendaciones(cur, true);
    	boolean ok = model.seCompletoLaGeneracionDeRecomendaciones();
    	assertEquals(4, model.getRecomendaciones().size());
    	assertTrue(ok);
    }
    
    public void testGRCModelOrdenarPorCriterio() throws Exception{
    	Set<Curso> cursosDisp = new HashSet<Curso>();
    	Materia m = new Materia("M");
		Materia mn = new Materia("N");
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario(Dia.LUNES, 18, 22));
		h.add(new Horario(Dia.MARTES, 18, 20));
		List<Horario> h2 = new ArrayList<Horario>();
		h2.add(new Horario(Dia.JUEVES, 18, 20));
		h2.add(new Horario(Dia.MIERCOLES, 20, 22));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		Curso c1 = new Curso(c, mn, h, "01");
		Curso c2 = new Curso(c, m, h2, "01");
		cursosDisp.add(c1);
		cursosDisp.add(c2);
		
		CriterioOrden com = new CriterioOrdenPorMaterias(true);
    	GRCModelo model = new GRCModelo(cursosDisp, com, 1000);
    	
    	List<Horario> lhor = new ArrayList<Horario>();
    	Horario lh1 = new Horario(8, 12);
    	Horario lh2 = new Horario(18, 22);
    	lhor.add(lh1);
    	lhor.add(lh2);
    	model.actualizarRecomendaciones(cursosDisp, true);
    	model.ordenarPorCriterio(com);
    	assertEquals(2, model.getRecomendaciones().get(0).getRecomendacion().size());
    }
    
//    public void testGRCModelArmarRecomendacionesVacio() throws Exception{
//    	Set<Curso> cursosDisp = new HashSet<Curso>();
//		CriterioOrden com = new CriterioOrdenPorMaterias(true);
//    	GRCModelo model = new GRCModelo(cursosDisp, com, 1000);
//    	model.actualizarRecomendaciones(cursosDisp, true);
//    	assertEquals(1, model.getListaRecomendacionesSugeridas().size());
//    }
    
    public void testGRCModelActualizarRecoActual() throws Exception{
    	Set<Curso> cursosDisp = new HashSet<Curso>();
		CriterioOrden com = new CriterioOrdenPorMaterias(true);
    	GRCModelo model = new GRCModelo(cursosDisp, com, 1000);
    	model.actualizarRecomendaciones(cursosDisp, true);
    	model.actualizarRecomendacionActual(0);
    	assertNull(model.getRecomendacionActual());
    }
    
    public void testGRCModelClone() throws Exception{
    	Set<Curso> cursosDisp = new HashSet<Curso>();
		CriterioOrden com = new CriterioOrdenPorMaterias(true);
    	GRCModelo model = new GRCModelo(cursosDisp, com, 1000);
    	assertNotSame(model, model.clone());
    }    
}
