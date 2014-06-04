package grc.servicios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import grc.dominio.Curso;
import grc.dominio.Horario;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class FiltroHorarioTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FiltroHorarioTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FiltroHorarioTest.class );
    }

	public void testFiltroHorarioSinCursos() throws Exception
	{

		Set<Curso> c = new HashSet<Curso>();
		List<Horario> h = new ArrayList<Horario>();
		IFiltro f = new FiltroHorarios(h);
		assertEquals(0, f.filtrar(c).size());
	}
    
//    public void testFiltroHorarioConCursosSinHoras() throws Exception{
//    	FiltroCursos fil = new FiltroCursos();
//    	List<Curso> cursos = new ArrayList<Curso>();
//    	Curso c1 = new Curso();
//    	c1.setHorario(new ArrayList<Horario>());
//    	cursos.add(c1);
//    	List<Horario> h = new ArrayList<Horario>();
//    	assertEquals(0, fil.filtrarPorHorario(cursos, h).size());
//    }
//    
//    public void testFiltroCursosDisponiblesConCursosConHorasNoche() throws Exception{
//    	FiltroCursos fil = new FiltroCursos();
//    	List<Curso> cursos = new ArrayList<Curso>();
//    	Curso c1 = new Curso();
//    	List<Horario> horas = new ArrayList<Horario>();
//    	Horario h1 = new Horario(18, 20);
////    	Horario h2 = new Horario(8, 12);
//    	Horario h3 = new Horario(20, 22);
//    	horas.add(h1);
////    	horas.add(h2);
//    	horas.add(h3);
//    	c1.setHorario(horas);
//    	cursos.add(c1);
//    	List<Horario> h = new ArrayList<Horario>();
//    	Horario hf = new Horario(18, 22);
//    	h.add(hf);
//    	assertEquals(1, fil.filtrarPorHorario(cursos, h).size());
//    }
    
//    public void testFiltroCursosDisponiblesConCursosConHorasManana() throws Exception{
//    	FiltroCursos fil = new FiltroCursos();
//    	List<Curso> cursos = new ArrayList<Curso>();
//    	Curso c1 = new Curso();
//    	List<Horario> horas = new ArrayList<Horario>();
//    	Horario h1 = new Horario(8, 12);
//    	horas.add(h1);
//    	c1.setHorario(horas);
//    	cursos.add(c1);
//    	List<Horario> h = new ArrayList<Horario>();
//    	Horario hf = new Horario(8, 12);
//    	h.add(hf);
//    	assertEquals(1, fil.filtrarPorHorario(cursos, h).size());
//    }
//    
//    public void testFiltroCorrelativasOk(){
//    	Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
//    	a.init();
//    	PlanEstudio pe = a.getPlanEstudios();
//    	Materia materiaACursar = new Materia("Introducción a la Programación");
//    	List<Materia> materiasAprobadas = new ArrayList<Materia>();
//    	for(int i=0; i<15;i++){
//    		materiasAprobadas.add(new Materia("A"+i));	
//    	}
//    	
//    	FiltroCursos ac = new FiltroCursos();
//    	boolean puedeCursar = ac.tieneCorrelativas(pe, materiaACursar, materiasAprobadas);
//    	assertTrue(puedeCursar);
//    }
//    
//    public void testFiltroCorrelativasFail(){
//    	Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
//    	a.init();
//    	PlanEstudio pe = a.getPlanEstudios();
//    	Materia materiaACursar = new Materia("WTF");
//    	List<Materia> materiasAprobadas = new ArrayList<Materia>();
//    	for(int i=0; i<15;i++){
//    		materiasAprobadas.add(new Materia("A"+i));	
//    	}
//    	
//    	FiltroCursos ac = new FiltroCursos();
//    	boolean puedeCursar = ac.tieneCorrelativas(pe, materiaACursar, materiasAprobadas);
//    	assertFalse(puedeCursar);
//    }
//    
//    public void testFiltroGetCursosDisponibles() throws Exception{
//    	Carrera c = CarreraDAO.getInstancia().getCarrera(0);
//    	PlanEstudio pe = PlanEstudioDAO.getInstancia().getPlanEstudioDeCarrera(c);
//    	List<MateriaAprobada> lma = new ArrayList<MateriaAprobada>();
//    	Materia m1 = new Materia("Programacion I");
//    	m1.setId(1);
//    	Materia m2 = new Materia("Calculo I");
//    	MateriaAprobada ma1 = new MateriaAprobada();
//    	ma1.setMateriaAprobada(m1);
//    	MateriaAprobada ma2 = new MateriaAprobada();
//    	ma2.setMateriaAprobada(m2);
//    	lma.add(ma1);
//    	lma.add(ma2);
//    	
//    	FiltroCursos ac = new FiltroCursos();
//    	assertNotNull(ac.filtrarCorrelativas(pe, lma));
//    }
}
