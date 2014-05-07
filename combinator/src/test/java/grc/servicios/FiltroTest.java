package grc.servicios;

import java.util.ArrayList;
import java.util.List;

import grc.app.Alta_mat_cur_matApr;
import grc.dao.CarreraDAO;
import grc.dao.PlanEstudioDAO;
import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.Horario;
import grc.dominio.Materia;
import grc.dominio.MateriaAprobada;
import grc.dominio.PlanEstudio;
import grc.servicios.Filtro;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class FiltroTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FiltroTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FiltroTest.class );
    }

    public void testFiltroCursosDisponiblesSinCursos() throws Exception{
    	Filtro fil = new Filtro();
    	List<Curso> c = new ArrayList<Curso>();
    	List<Horario> h = new ArrayList<Horario>();
    	assertEquals(0, fil.getCursosDisponibles(c, h).size());
    }
    
    public void testFiltroCursosDisponiblesConCursosSinHoras() throws Exception{
    	Filtro fil = new Filtro();
    	List<Curso> cursos = new ArrayList<Curso>();
    	Curso c1 = new Curso();
    	c1.setHorario(new ArrayList<Horario>());
    	cursos.add(c1);
    	List<Horario> h = new ArrayList<Horario>();
    	assertEquals(0, fil.getCursosDisponibles(cursos, h).size());
    }
    
    public void testFiltroCursosDisponiblesConCursosConHorasNoche() throws Exception{
    	Filtro fil = new Filtro();
    	List<Curso> cursos = new ArrayList<Curso>();
    	Curso c1 = new Curso();
    	List<Horario> horas = new ArrayList<Horario>();
    	Horario h1 = new Horario(18, 20);
//    	Horario h2 = new Horario(8, 12);
    	Horario h3 = new Horario(20, 22);
    	horas.add(h1);
//    	horas.add(h2);
    	horas.add(h3);
    	c1.setHorario(horas);
    	cursos.add(c1);
    	List<Horario> h = new ArrayList<Horario>();
    	Horario hf = new Horario(18, 22);
    	h.add(hf);
    	assertEquals(1, fil.getCursosDisponibles(cursos, h).size());
    }
    
    public void testFiltroCursosDisponiblesConCursosConHorasManana() throws Exception{
    	Filtro fil = new Filtro();
    	List<Curso> cursos = new ArrayList<Curso>();
    	Curso c1 = new Curso();
    	List<Horario> horas = new ArrayList<Horario>();
    	Horario h1 = new Horario(8, 12);
    	horas.add(h1);
    	c1.setHorario(horas);
    	cursos.add(c1);
    	List<Horario> h = new ArrayList<Horario>();
    	Horario hf = new Horario(8, 12);
    	h.add(hf);
    	assertEquals(1, fil.getCursosDisponibles(cursos, h).size());
    }
    
    public void testFiltroCorrelativasOk(){
    	Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
    	a.init();
    	PlanEstudio pe = a.getPlanEstudios();
    	Materia materiaACursar = new Materia("Introducción a la Programación");
    	List<Materia> materiasAprobadas = new ArrayList<Materia>();
    	for(int i=0; i<15;i++){
    		materiasAprobadas.add(new Materia("A"+i));	
    	}
    	
    	Filtro ac = new Filtro();
    	boolean puedeCursar = ac.tieneCorrelativas(pe, materiaACursar, materiasAprobadas);
    	assertTrue(puedeCursar);
    }
    
    public void testFiltroCorrelativasFail(){
    	Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
    	a.init();
    	PlanEstudio pe = a.getPlanEstudios();
    	Materia materiaACursar = new Materia("WTF");
    	List<Materia> materiasAprobadas = new ArrayList<Materia>();
    	for(int i=0; i<15;i++){
    		materiasAprobadas.add(new Materia("A"+i));	
    	}
    	
    	Filtro ac = new Filtro();
    	boolean puedeCursar = ac.tieneCorrelativas(pe, materiaACursar, materiasAprobadas);
    	assertFalse(puedeCursar);
    }
    
    public void testFiltroGetCursosDisponibles() throws Exception{
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
    	
    	Filtro ac = new Filtro();
    	assertNotNull(ac.getCursosDisponibles(pe, lma));
    }
}
