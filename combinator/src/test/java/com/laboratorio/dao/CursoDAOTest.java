package com.laboratorio.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.mockito.InjectMocks;
import org.mockito.Mockito;

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
public class CursoDAOTest extends TestCase {

	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public CursoDAOTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(CursoDAOTest.class);
	}

	@InjectMocks
	private EntityManagerUtil emu = Mockito.mock(EntityManagerUtil.class);

	public void testAltaCursoOk() throws Exception {
		ArrayList<Horario> horar = new ArrayList<Horario>();
		horar.add(new Horario("lunes", 18, 22));

		Materia a = new Materia("A");
		Curso c1 = new Curso(a, horar);
		CursoDAO.getInstancia().alta(c1);
	}

	public void testAltaCursoFail() {
		ArrayList<Horario> horar = new ArrayList<Horario>();
		horar.add(new Horario());

		Materia a = new Materia("A");
		Curso c1 = new Curso(a, horar);
		try {
			Mockito.when(emu.getNewEM().merge(c1)).thenThrow(
					new RuntimeException());
			CursoDAO.getInstancia().alta(c1);
		} catch (Exception e) {
			assertTrue(true);
		}

	}

	public void testObtenerCurso() throws Exception {
		Curso c = CursoDAO.getInstancia().getCurso(1);
		assertNotNull(c);
	}

	public void testObtenerTodosLosCurso() throws Exception {
		List<Curso> c = CursoDAO.getInstancia().obtenerTodo();
		assertNotNull(c);
	}

	public void testObtenerCursoPorTurno() throws Exception {
		Set<Curso> c = CursoDAO.getInstancia().getCursosPorTurno(18);
		assertNotNull(c);
	}

	public void testQuitarMateriasAprobadas() throws Exception {
		ArrayList<Horario> horar = new ArrayList<Horario>();
		horar.add(new Horario("a", 18, 22));
		Materia a = new Materia("a");
		Curso c1 = new Curso(a, horar);

		Set<Curso> cursos = new HashSet<Curso>();
		cursos.add(c1);
		CursoDAO.getInstancia().quitarMateriasAprobadas(cursos);
		assertEquals(true, true);// TODO!
	}

}
