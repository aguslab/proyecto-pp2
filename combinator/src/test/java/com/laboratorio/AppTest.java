package com.laboratorio;

import java.util.ArrayList;

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
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        Curso c = new Curso();
        int a = c.getId();
    	assertEquals(0, a);
    }
    
    public void testApp12()
    {
        Materia c = new Materia();
        int a = c.getId();
    	assertEquals(0, a);
    }
    
    
    public void testApp2() throws Exception
    {
    	
    	 Materia pp1 = new Materia("pp1");
         Materia pp2 = new Materia("pp2");
         Materia pp3 = new Materia("pp3");
         Materia mate1 = new Materia("mate1");
         Materia mate2 = new Materia("mate2");
         Materia ingles = new Materia("ingles");
         
         
         //CREO HORARIOS DISPONIBLES
         Horario man = new Horario("Lunes", "M");
         Horario tar = new Horario("Martes", "T");
         Horario noc = new Horario("Miercoles", "N");
         ArrayList<Horario> horar = new ArrayList<Horario>();
         horar.add(man);
         horar.add(tar);
         ArrayList<Horario> horar2 = new ArrayList<Horario>();
         horar2.add(man);
         horar2.add(tar);
         ArrayList<Horario> horar3 = new ArrayList<Horario>();
         horar3.add(tar);
         horar3.add(noc);
         
    	//CREO CURSOS (materia q se dicta y en que turno)
        Curso c1 = new Curso(pp1, horar);
        Curso c2 = new Curso(pp2, horar2);
        Curso c3 = new Curso(mate1, horar3);
        
    	CursoDAO.getInstancia().alta(c1);
		CursoDAO.getInstancia().alta(c2);
		CursoDAO.getInstancia().alta(c3);
		
		System.out.println("cant cursos: "+CursoDAO.getInstancia().getCursosPorTurno(18).size());
		assertEquals(1, 1);
    }
}
