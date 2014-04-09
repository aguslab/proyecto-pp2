package com.laboratorio.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.laboratorio.controlador.GRCController;
import com.laboratorio.dao.CursoDAO;
import com.laboratorio.modelo.Curso;
import com.laboratorio.modelo.Horario;
import com.laboratorio.modelo.Materia;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class RecomendacionTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RecomendacionTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( RecomendacionTest.class );
    }

    public void testCombinador() throws Exception{
    	Materia m = new Materia("M");
    	Materia mn = new Materia("N");
    	List<Horario> h = new ArrayList<Horario>();
    	h.add(new Horario("Lun", 18, 22));
    	Curso c1 = new Curso(mn, h);
    	Curso c2 = new Curso(m, h);
    	
    	ArrayList<Curso> cursos = new ArrayList<Curso>();
    	cursos.add(c1);
    	cursos.add(c2);
		Recomendacion reco = new Recomendacion();
		reco.backtracking(cursos);
    }
    
    
}
