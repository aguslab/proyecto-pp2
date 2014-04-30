package grc.dao;

import grc.dao.CursoDAO;
import grc.modelo.Curso;
import grc.modelo.Horario;
import grc.modelo.Materia;
import java.util.ArrayList;
import java.util.HashSet;
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

	public void testAltaCursoOk() {
		ArrayList<Horario> horar = new ArrayList<Horario>();
		horar.add(new Horario("lunes", 18, 22));

		Materia a = new Materia("A");
		Curso c1 = new Curso(a, horar);
		boolean sinError = true;
		try {
			CursoDAO.getInstancia().alta(c1);
		} catch (Exception e) {
			sinError = false;
		}
		assertTrue(sinError);
	}

	public void testAltaCursoFail() {
		Curso c1 = new Curso();
		try {
			CursoDAO.getInstancia().alta(c1);
		} catch (Exception e) {
			assertTrue(true);
		}

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
		Set<Curso> c = CursoDAO.getInstancia().getCursosPorTurno(18);
		assertNotNull(c);
	}

	public void testQuitarMateriasAprobadas() throws Exception {
		List<Curso> c = CursoDAO.getInstancia().obtenerTodo();
		Set<Curso> cursos = new HashSet<Curso>(c);
		Set<Curso> csma  = CursoDAO.getInstancia().quitarMateriasAprobadas(cursos);
		assertNotNull(csma);
	}

}
