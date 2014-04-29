package grc.modelo;

import grc.modelo.Curso;
import grc.modelo.Horario;
import grc.modelo.Materia;

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

    public void testCurso(){
    	Materia m = new Materia("Algebra Lineal");
    	Horario h = new Horario("Martes", 18, 22);
    	Horario h2 = new Horario("Jueves", 18, 22);
    	ArrayList<Horario> horarios = new ArrayList<Horario>();
    	horarios.add(h);
    	horarios.add(h2);
    	Curso cu = new Curso();
    	
    	cu.setHorario(horarios);
    	cu.setMateria(m);
    	
    	assertEquals("Algebra Lineal", cu.getMateria().getNombre());
    }
}
