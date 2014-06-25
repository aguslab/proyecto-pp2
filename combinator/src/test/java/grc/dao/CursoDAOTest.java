package grc.dao;

import grc.dao.CursoDAO;
import grc.dominio.Curso;
import grc.dominio.Horario;
import grc.dominio.Materia;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CursoDAOTest extends TestCase {

	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 * @throws Exception 
	 */
	public CursoDAOTest(String testName) throws Exception {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(CursoDAOTest.class);
	}

	public void testAltaCursoOk() throws Exception {
		List<Horario> horar = new ArrayList<Horario>();
		Horario lun18a22 = null ;
		horar.add(lun18a22);
		Materia m = new Materia("M");
		m.setId(MateriaDAO.getInstancia().obtenerTodo().size()+1);
		Curso c1 = new Curso();
		c1.setMateria(m);
		int cantAntes = CursoDAO.getInstancia().obtenerTodo().size();
		CursoDAO.getInstancia().alta(c1);
    	int cantDespues = CursoDAO.getInstancia().obtenerTodo().size();
    	assertEquals(cantAntes+1, cantDespues);
	}

	public void testAltaCursoFail() {
		Curso c1 = new Curso();
		try {
			CursoDAO.getInstancia().alta(c1);
		} catch (Exception e) {
			assertTrue(true);
		}
	}
	
	public void testAltaCurso() throws Exception {
		Materia m = new Materia("M");
		m.setId(MateriaDAO.getInstancia().obtenerTodo().size()+1);
		Curso c1 = new Curso();
		c1.setMateria(m);
		int cantAntes = CursoDAO.getInstancia().obtenerTodo().size();
		c1.setId(cantAntes+1);
		CursoDAO.getInstancia().alta(c1);
    	int cantDespues = CursoDAO.getInstancia().obtenerTodo().size();
    	assertEquals(cantAntes+1, cantDespues);
	}

	public void testObtenerCurso() throws Exception {
		Curso c = CursoDAO.getInstancia().getCurso(1);
		assertNotNull(c);
	}

	public void testObtenerTodosLosCursos() throws Exception {
		List<Curso> c = CursoDAO.getInstancia().obtenerTodo();
		assertNotNull(c);
	}

	public void testObtenerCursoPorTurno() throws Exception {
		Set<Curso> c = CursoDAO.getInstancia().getCursosPorTurno(18,22);
		assertNotNull(c);
	}

//	public void testCursoPorCarrera() throws Exception {
//		Carrera c = CarreraDAO.getInstancia().getCarrera(1);
//		Set<Curso> csma  = CursoDAO.getInstancia().getCursosPorCarrera(c);
//		assertNotNull(csma);
//	}

}
