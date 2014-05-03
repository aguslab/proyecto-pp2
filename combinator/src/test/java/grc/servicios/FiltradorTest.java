package grc.servicios;

import java.util.ArrayList;
import java.util.List;
import grc.dominio.Curso;
import grc.dominio.Horario;
import grc.servicios.Filtrador;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class FiltradorTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FiltradorTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FiltradorTest.class );
    }

    public void testFiltradorCursosDisponiblesSinCursos() throws Exception{
    	Filtrador fil = new Filtrador();
    	List<Curso> c = new ArrayList<Curso>();
    	List<Horario> h = new ArrayList<Horario>();
    	assertEquals(0, fil.getCursosDisponibles(c, h).size());
    }
    
    public void testFiltradorCursosDisponiblesConCursosSinHoras() throws Exception{
    	Filtrador fil = new Filtrador();
    	List<Curso> cursos = new ArrayList<Curso>();
    	Curso c1 = new Curso();
    	c1.setHorario(new ArrayList<Horario>());
    	cursos.add(c1);
    	List<Horario> h = new ArrayList<Horario>();
    	assertEquals(0, fil.getCursosDisponibles(cursos, h).size());
    }
    
    public void testFiltradorCursosDisponiblesConCursosConHorasNoche() throws Exception{
    	Filtrador fil = new Filtrador();
    	List<Curso> cursos = new ArrayList<Curso>();
    	Curso c1 = new Curso();
    	List<Horario> horas = new ArrayList<Horario>();
    	Horario h1 = new Horario(18, 20);
    	Horario h2 = new Horario(8, 12);
    	Horario h3 = new Horario(20, 22);
    	horas.add(h1);
    	horas.add(h2);
    	horas.add(h3);
    	c1.setHorario(horas);
    	cursos.add(c1);
    	List<Horario> h = new ArrayList<Horario>();
    	Horario hf = new Horario(18, 22);
    	h.add(hf);
    	assertEquals(1, fil.getCursosDisponibles(cursos, h).size());
    }
    
    public void testFiltradorCursosDisponiblesConCursosConHorasManana() throws Exception{
    	Filtrador fil = new Filtrador();
    	List<Curso> cursos = new ArrayList<Curso>();
    	Curso c1 = new Curso();
    	List<Horario> horas = new ArrayList<Horario>();
    	Horario h1 = new Horario(8, 12);
    	Horario h2 = new Horario(10, 13);
    	Horario h3 = new Horario(20, 22);
    	horas.add(h1);
    	horas.add(h2);
    	horas.add(h3);
    	c1.setHorario(horas);
    	cursos.add(c1);
    	List<Horario> h = new ArrayList<Horario>();
    	Horario hf = new Horario(8, 12);
    	h.add(hf);
    	assertEquals(1, fil.getCursosDisponibles(cursos, h).size());
    }
}
