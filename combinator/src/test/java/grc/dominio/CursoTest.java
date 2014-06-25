package grc.dominio;

import grc.dominio.Curso;
import grc.dominio.Horario;
import grc.dominio.Materia;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CursoTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CursoTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CursoTest.class );
    }

    public void testCursoId()
    {
    	Materia m = new Materia("Algebra Lineal");
    	Horario h = new Horario(Dia.MARTES, 18., 22.);
    	Horario h2 = new Horario(Dia.JUEVES, 18., 22.);
    	ArrayList<Horario> horarios = new ArrayList<Horario>();
    	horarios.add(h);
    	horarios.add(h2);
    	Curso cu = new Curso();
    	
    	cu.setHorario(horarios);
    	cu.setMateria(m);
    	cu.setId(0);
    	assertEquals(cu.getId(), 0);
    }
    
    public void testCursoMateria()
    {
    	Materia m = new Materia("Algebra Lineal");
    	Horario h = new Horario(Dia.MARTES, 18., 22.);
    	Horario h2 = new Horario(Dia.JUEVES, 18., 22.);
    	ArrayList<Horario> horarios = new ArrayList<Horario>();
    	horarios.add(h);
    	horarios.add(h2);
    	Curso cu = new Curso();
    	
    	cu.setHorario(horarios);
    	cu.setMateria(m);
    	assertEquals("Algebra Lineal", cu.getMateria().getNombre());
    }
    
    public void testCursoNombreCurso()
    {
    	Materia m = new Materia("ABC","A");
    	Horario h = new Horario(Dia.MARTES, 18., 22.);
    	ArrayList<Horario> horarios = new ArrayList<Horario>();
    	horarios.add(h);
    	Curso cu = new Curso();
    	
    	cu.setHorario(horarios);
    	cu.setMateria(m);
    	cu.setComision("01");
    	assertEquals("ABC com-01", cu.getNombreCurso());
    }
    
    public void testCursoNombreCortoCurso()
    {
    	Materia m = new Materia("Materia","Mate");
    	Horario h = new Horario(Dia.LUNES, 18., 22.);
    	ArrayList<Horario> horarios = new ArrayList<Horario>();
    	horarios.add(h);
    	Curso cu = new Curso();
    	
    	cu.setHorario(horarios);
    	cu.setMateria(m);
    	cu.setComision("01");
    	assertEquals("Mate com-01", cu.getNombreCortoCurso());
    }
    
    public void testCursoComision()
    {
    	Materia m = new Materia("A","A");
    	Curso cu = new Curso();
    	
    	cu.setMateria(m);
    	cu.setComision("01");
    	assertEquals("01", cu.getComision());
    }
}
