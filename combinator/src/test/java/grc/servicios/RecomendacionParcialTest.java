package grc.servicios;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import grc.dominio.Carrera;
import grc.dominio.Curso;
import grc.dominio.Dia;
import grc.dominio.Horario;
import grc.dominio.Materia;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class RecomendacionParcialTest extends TestCase
	{
		public RecomendacionParcialTest(String testName)
		{
			super(testName);
		}
		
		public static Test suite()
		{
			return new TestSuite(RecomendacionParcialTest.class);
		}
		
		public void testAgregarCurso()
		{
			Materia orga1 = new Materia("Organización del computador I");
			List<Horario> h = new ArrayList<Horario>();
			h.add(new Horario(Dia.LUNES, 18., 20.));
			h.add(new Horario(Dia.MARTES, 18., 20.));
			Carrera c = new Carrera("Licenciatura en Sistemas");
			Curso c1 = new Curso(c, orga1, h, "01");
			RecomendacionParcial rp = new RecomendacionParcial();
			rp.agregarCurso(c1);
			assertEquals(1,rp.getRecomendacion().size());
		}
		
		public void testEliminarCurso()
		{
			Materia orga1 = new Materia("Organización del computador I");
			List<Horario> h = new ArrayList<Horario>();
			h.add(new Horario(Dia.LUNES, 18., 20.));
			h.add(new Horario(Dia.MARTES, 18., 20.));
			Carrera c = new Carrera("Licenciatura en Sistemas");
			Curso c1 = new Curso(c, orga1, h, "01");
			RecomendacionParcial rp = new RecomendacionParcial();
			rp.agregarCurso(c1);
			rp.eliminarCurso(c1);
			assertTrue(rp.getRecomendacion().isEmpty());
		}
		
		public void testPuedeAgregarCurso()
		{
			Materia psec = new Materia("PSEC");
			Materia mate = new Materia("Matemática Discreta");
			List<Horario> h = new ArrayList<Horario>();
			h.add(new Horario(Dia.LUNES, 18., 20.));
			h.add(new Horario(Dia.JUEVES, 18., 22.));
			List<Horario> h2 = new ArrayList<Horario>();
			h2.add(new Horario(Dia.MARTES, 18., 20.));
			h2.add(new Horario(Dia.VIERNES, 18., 22.));
			Carrera c = new Carrera("Licenciatura en Sistemas");
			Curso c1 = new Curso(c, psec, h, "01");
			Curso c2 = new Curso(c, mate, h2, "01");
			RecomendacionParcial rp = new RecomendacionParcial();
			rp.agregarCurso(c1);
			assertTrue(rp.puedeAgregarCurso(c2));
		}
		
		public void testCopiarCursos()
		{
			Materia psec = new Materia("PSEC");
			Materia mate = new Materia("Matemática Discreta");
			List<Horario> h = new ArrayList<Horario>();
			h.add(new Horario(Dia.LUNES, 18., 20.));
			h.add(new Horario(Dia.JUEVES, 18., 22.));
			List<Horario> h2 = new ArrayList<Horario>();
			h2.add(new Horario(Dia.MARTES, 18., 20.));
			h2.add(new Horario(Dia.VIERNES, 18., 22.));
			Carrera c = new Carrera("Licenciatura en Sistemas");
			Curso c1 = new Curso(c, psec, h, "01");
			Curso c2 = new Curso(c, mate, h2, "01");
			RecomendacionParcial rp = new RecomendacionParcial();
			rp.agregarCurso(c1);
			rp.agregarCurso(c2);
			Set<Curso> copia = rp.getCopiaCursosDeRecomendacion();
			assertNotNull(copia);
			assertEquals(2,copia.size());
		}
}
