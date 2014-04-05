package com.laboratorio.dao;

import java.util.ArrayList;
import java.util.List;

import com.laboratorio.dao.CursoDAO;
import com.laboratorio.dao.HorarioDAO;
import com.laboratorio.modelo.Curso;
import com.laboratorio.modelo.Horario;
import com.laboratorio.modelo.Materia;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CursoDAOTest 
    extends TestCase
{
	   
    //CREO MATERIAS NUEVAS
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
      
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CursoDAOTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CursoDAOTest.class );
    }

    public void testAltaCursoManiana() throws Exception{
    	ArrayList<Horario> horar = new ArrayList<Horario>();
        horar.add(man);

        Curso c1 = new Curso(pp1, horar);
    	CursoDAO.getInstancia().alta(c1);
    	
    	assertEquals(true, true);
    }
    
    public void testAltaCursoTarde() throws Exception{
    	ArrayList<Horario> horar = new ArrayList<Horario>();
        horar.add(tar);
    	
        Curso c1 = new Curso(pp1, horar);
    	CursoDAO.getInstancia().alta(c1);
    	
    	assertEquals(true, true);
    }
    
    public void testAltaCursoNoche() throws Exception{
    	ArrayList<Horario> horar = new ArrayList<Horario>();
        horar.add(noc);

        Curso c1 = new Curso(pp1, horar);
    	CursoDAO.getInstancia().alta(c1);
    	
    	assertEquals(true, true);
    }
    
    public void testAltaHorario() throws Exception{
    	HorarioDAO.getInstancia().alta(noc);
    	
    	assertEquals(true, true);
    }
    
    public void testObtenerCurso() throws Exception{
    	Curso c = CursoDAO.getInstancia().getCurso(1);
    	assertNotNull(c);
    }
    
    public void testObtenerTodosLosCurso() throws Exception{
    	List<Curso> c = CursoDAO.getInstancia().obtenerTodo();
    	assertNotNull(c);
    }
    
    public void testObtenerCursoPorTurnoManiana() throws Exception{
    	List<Curso> c = CursoDAO.getInstancia().getCursosPorTurno(8);
    	assertNotNull(c);
    }
    
    
    public void testObtenerCursoPorTurnoTarde() throws Exception{
    	List<Curso> c = CursoDAO.getInstancia().getCursosPorTurno(13);
    	assertNotNull(c);
    }
    
    
    public void testObtenerCursoPorTurnoNoche() throws Exception{
    	List<Curso> c = CursoDAO.getInstancia().getCursosPorTurno(18);
    	assertNotNull(c);
    }
    
    public void testQuitarMateriasAprobadas() throws Exception{
    	ArrayList<Horario> horar = new ArrayList<Horario>();
    	horar.add(man);
    	horar.add(noc);

        Curso c1 = new Curso(pp1, horar);
        Curso c2 = new Curso(pp2, horar);
        Curso c3 = new Curso(mate1, horar);
        Curso c4 = new Curso(ingles, horar);
    	
    	List<Curso> cursos = new ArrayList<Curso>();
    	cursos.add(c1);
    	cursos.add(c2);
    	cursos.add(c3);
    	cursos.add(c4);
    	CursoDAO.getInstancia().quitarMateriasAprobadas(cursos);
    	assertEquals(true, true);//TODO!
    }
    
}
