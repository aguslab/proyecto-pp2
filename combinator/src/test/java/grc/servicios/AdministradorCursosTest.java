package grc.servicios;

import grc.app.Alta_mat_cur_matApr;
import grc.dao.CarreraDAO;
import grc.dao.PlanEstudioDAO;
import grc.dominio.Carrera;
import grc.dominio.Materia;
import grc.dominio.MateriaAprobada;
import grc.dominio.PlanEstudio;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AdministradorCursosTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AdministradorCursosTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AdministradorCursosTest.class );
    }

    public void testAdminCursosCorrelativasOk(){
    	Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
    	a.init();
    	PlanEstudio pe = a.getPlanEstudios();
    	Materia materiaACursar = new Materia("Introducción a la Programación");
    	List<Materia> materiasAprobadas = new ArrayList<Materia>();
    	for(int i=0; i<15;i++){
    		materiasAprobadas.add(new Materia("A"+i));	
    	}
    	
    	AdministradorCursos ac = new AdministradorCursos();
    	boolean puedeCursar = ac.tieneCorrelativas(pe, materiaACursar, materiasAprobadas);
    	assertTrue(puedeCursar);
    }
    
    public void testAdminCursosCorrelativasFail(){
    	Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
    	a.init();
    	PlanEstudio pe = a.getPlanEstudios();
    	Materia materiaACursar = new Materia("WTF");
    	List<Materia> materiasAprobadas = new ArrayList<Materia>();
    	for(int i=0; i<15;i++){
    		materiasAprobadas.add(new Materia("A"+i));	
    	}
    	
    	AdministradorCursos ac = new AdministradorCursos();
    	boolean puedeCursar = ac.tieneCorrelativas(pe, materiaACursar, materiasAprobadas);
    	assertFalse(puedeCursar);
    }
    
    public void testAdminCursosGetCursosDisponibles() throws Exception{
    	Carrera c = CarreraDAO.getInstancia().getCarrera(0);
    	PlanEstudio pe = PlanEstudioDAO.getInstancia().getPlanEstudioDeCarrera(c);
    	List<MateriaAprobada> lma = new ArrayList<MateriaAprobada>();
    	Materia m1 = new Materia("Programacion I");
    	m1.setId(1);
    	Materia m2 = new Materia("Calculo I");
    	MateriaAprobada ma1 = new MateriaAprobada();
    	ma1.setMateriaAprobada(m1);
    	MateriaAprobada ma2 = new MateriaAprobada();
    	ma2.setMateriaAprobada(m2);
    	lma.add(ma1);
    	lma.add(ma2);
    	
    	AdministradorCursos ac = new AdministradorCursos();
    	assertNotNull(ac.getCursosDisponibles(pe, lma));
    }

    
}
