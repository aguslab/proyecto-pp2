package grc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import grc.app.Alta_mat_cur_matApr;
import grc.controlador.GRCController;
import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.Horario;
import grc.dominio.Materia;
import grc.dominio.PlanEstudio;
import grc.modelo.GRCModel;
import grc.servicios.Filtro;
import grc.vista.GRCView;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class GRCControllerTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GRCControllerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GRCControllerTest.class );
    }

    public void testCambioFiltros() throws Exception{
    	Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
    	a.init();
    	PlanEstudio pe = a.getPlanEstudios();
    	List<Curso> cursosDisp = new ArrayList<Curso>();
    	Materia m = new Materia("M");
		Materia mn = new Materia("PP2");
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario("LUNES", 18, 22));
		List<Horario> h2 = new ArrayList<Horario>();
		h2.add(new Horario("VIERNES", 18, 22));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		List<Carrera> ca = new ArrayList<Carrera>();
		ca.add(c);
		c.setId(0);
		Curso c1 = new Curso(ca, mn, h);
		Curso c2 = new Curso(ca, m, h2);
		cursosDisp.add(c1);
		cursosDisp.add(c2);
    	GRCModel model = new GRCModel(cursosDisp, pe, 1000);
    	List<Horario> lhor = new ArrayList<Horario>();
    	Horario lh1 = new Horario(8, 12);
    	Horario lh2 = new Horario(18, 22);
    	lhor.add(lh1);
    	lhor.add(lh2);
    	Filtro f = new Filtro();
    	List<Curso> cur = new ArrayList<Curso>(f.getCursosDisponibles(model.getCursosDisponibles(), lhor));
    	
    	GRCController controller = new GRCController();
    	GRCView vista = new GRCView(model, controller);
    	model.actualizarRecomendaciones(cur, true);
    	DefaultTableModel tablaDias = vista.getTablaDias();
    	controller.cambiarTablaDias(tablaDias, 0);
    	String materia = (String) tablaDias.getValueAt(10,1);
    	assertEquals("PP2", materia);
    }
    
    public void testBorrarTablaDias() throws Exception{
    	GRCController controller = new GRCController();
    	GRCView vista = new GRCView(null, controller);
    	DefaultTableModel tablaDias = vista.getTablaDias();
    	controller.borrarValores(tablaDias);
    	assertEquals("8 a 9", tablaDias.getValueAt(0, 0));
    }
    
    public void testCambiarTablaDias() throws Exception{
    	Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
    	a.init();
    	PlanEstudio pe = a.getPlanEstudios();
    	List<Curso> cursosDisp = new ArrayList<Curso>();
    	Materia m = new Materia("M");
		Materia mn = new Materia("PP2");
		List<Horario> h = new ArrayList<Horario>();
		h.add(new Horario("LUNES", 18, 22));
		List<Horario> h2 = new ArrayList<Horario>();
		h2.add(new Horario("VIERNES", 8, 12));
		Carrera c = new Carrera("Licenciatura en Sistemas");
		List<Carrera> ca = new ArrayList<Carrera>();
		ca.add(c);
		c.setId(0);
		Curso c1 = new Curso(ca, mn, h);
		Curso c2 = new Curso(ca, m, h2);
		cursosDisp.add(c1);
		cursosDisp.add(c2);
    	GRCModel model = new GRCModel(cursosDisp, pe, 1000);
    	List<Horario> lhor = new ArrayList<Horario>();
    	Horario lh1 = new Horario(8, 12);
    	Horario lh2 = new Horario(18, 22);
    	lhor.add(lh1);
    	lhor.add(lh2);
    	Filtro f = new Filtro();
    	List<Curso> cur = new ArrayList<Curso>(f.getCursosDisponibles(model.getCursosDisponibles(), lhor));
    	
    	GRCController controller = new GRCController();
    	GRCView vista = new GRCView(model, controller);
    	model.actualizarRecomendaciones(cur, true);
    	controller.cambioFiltros();
    	int recos = controller.getRecomendaciones().size();
    	assertEquals(3, recos);
    }
}
