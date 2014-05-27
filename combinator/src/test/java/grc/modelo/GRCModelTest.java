package grc.modelo;

import java.util.ArrayList;
import java.util.List;

import grc.app.Alta_mat_cur_matApr;
import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.Dia;
import grc.dominio.Horario;
import grc.dominio.Materia;
import grc.dominio.PlanEstudio;
import grc.servicios.Filtro;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class GRCModelTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GRCModelTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GRCModelTest.class );
    }

    public void testActualizarRecomendaciones() throws Exception{
    	Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
    	a.init();
    	PlanEstudio pe = a.getPlanEstudios();
    	List<Curso> cursosDisp = new ArrayList<Curso>();
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
		h2.add(new Horario(Dia.MARTES, 20, 22));
		h2.add(new Horario(Dia.MIERCOLES, 20, 22));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		List<Carrera> ca = new ArrayList<Carrera>();
		ca.add(c);
		c.setId(0);
		Curso c1 = new Curso(ca, mn, h);
		Curso c2 = new Curso(ca, m, h2);
		Curso c3 = new Curso(ca, mt, h3);
		cursosDisp.add(c1);
		cursosDisp.add(c2);
		cursosDisp.add(c3);
    	GRCModel model = new GRCModel(cursosDisp, pe, 1000);
    	
    	List<Horario> lhor = new ArrayList<Horario>();
    	Horario lh1 = new Horario(8, 12);
    	Horario lh2 = new Horario(18, 22);
    	lhor.add(lh1);
    	lhor.add(lh2);
    	Filtro f = new Filtro();
    	List<Curso> cur = new ArrayList<Curso>(f.getCursosDisponibles(model.getCursosDisponibles(), lhor));
    	model.actualizarRecomendaciones(cur, true);
    	boolean ok = model.isFinishRecomendacionOK();
    	assertEquals(5, model.getRecomendaciones().size());
    	assertTrue(ok);
    }
    
}
