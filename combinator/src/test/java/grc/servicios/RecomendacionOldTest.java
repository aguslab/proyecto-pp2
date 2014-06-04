package grc.servicios;
//package grc.servicios;
//
//import grc.app.Alta_mat_cur_matApr;
//import grc.dominio.Carrera;
//import grc.dominio.Curso;
//import grc.dominio.Dia;
//import grc.dominio.Horario;
//import grc.dominio.Materia;
//import grc.dominio.PlanEstudio;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Set;
//
//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;
//
///**
// * Unit test for simple App.
// */
//public class RecomendacionTest extends TestCase
//{
//	/**
//	 * Create the test case
//	 * 
//	 * @param testName
//	 *            name of the test case
//	 */
//	public RecomendacionTest(String testName)
//	{
//		super(testName);
//	}
//
//	/**
//	 * @return the suite of tests being tested
//	 */
//	public static Test suite()
//	{
//		return new TestSuite(RecomendacionTest.class);
//	}
//
//	public void testRecomendacionLunesMartesMiercoles() throws Exception
//	{
//		Materia m = new Materia("M");
//		Materia mn = new Materia("N");
//		Materia mt = new Materia("T");
//		List<Horario> h = new ArrayList<Horario>();
//		h.add(new Horario(Dia.LUNES, 18, 22));
//		h.add(new Horario(Dia.MARTES, 18, 20));
//		List<Horario> h2 = new ArrayList<Horario>();
//		h2.add(new Horario(Dia.LUNES, 18, 20));
//		h2.add(new Horario(Dia.MIERCOLES, 20, 22));
//		List<Horario> h3 = new ArrayList<Horario>();
//		h2.add(new Horario(Dia.MARTES, 20, 22));
//		h2.add(new Horario(Dia.MIERCOLES, 20, 22));
//		Carrera c = new Carrera("Licenciatura en Sistemas");
//		List<Carrera> ca = new ArrayList<Carrera>();
//		ca.add(c);
//		c.setId(0);
//		Curso c1 = new Curso(ca, mn, h, "01");
//		Curso c2 = new Curso(ca, m, h2, "01");
//		Curso c3 = new Curso(ca, mt, h3, "01");
//
//		ArrayList<Curso> cursos = new ArrayList<Curso>();
//		cursos.add(c1);
//		cursos.add(c2);
//		cursos.add(c3);
//		Recomendacion reco = new Recomendacion(5000);
//		assertNotNull(reco.backtracking(cursos));
//	}
//
//	public void testRecomendacionLunesMartesMiercolesIGUALES() throws Exception
//	{
//		Materia m = new Materia("M");
//		Materia mn = new Materia("N");
//		Materia mt = new Materia("T");
//		List<Horario> h = new ArrayList<Horario>();
//		h.add(new Horario(Dia.LUNES, 18, 22));
//		h.add(new Horario(Dia.MARTES, 18, 22));
//		List<Horario> h2 = new ArrayList<Horario>();
//		h2.add(new Horario(Dia.LUNES, 18, 22));
//		h2.add(new Horario(Dia.MIERCOLES, 18, 22));
//		List<Horario> h3 = new ArrayList<Horario>();
//		h3.add(new Horario(Dia.MARTES, 18, 22));
//		h3.add(new Horario(Dia.MIERCOLES, 18, 22));
//		Carrera c = new Carrera("Licenciatura en Sistemas");
//		List<Carrera> ca = new ArrayList<Carrera>();
//		ca.add(c);
//		c.setId(0);
//		Curso c1 = new Curso(ca, mn, h, "01");
//		Curso c2 = new Curso(ca, m, h2, "01");
//		Curso c3 = new Curso(ca, mt, h3, "01");
//
//		ArrayList<Curso> cursos = new ArrayList<Curso>();
//		cursos.add(c1);
//		cursos.add(c2);
//		cursos.add(c3);
//		Recomendacion reco = new Recomendacion(5000);
//		assertNotNull(reco.backtracking(cursos));
//	}
//
//	public void testRecomendacionJuevesViernesSabado() throws Exception
//	{
//		Materia m = new Materia("M");
//		Materia mn = new Materia("N");
//		Materia mt = new Materia("T");
//		List<Horario> h = new ArrayList<Horario>();
//		h.add(new Horario(Dia.JUEVES, 18, 22));
//		List<Horario> h2 = new ArrayList<Horario>();
//		h2.add(new Horario(Dia.VIERNES, 18, 20));
//		h2.add(new Horario(Dia.SABADO, 8, 12));
//		List<Horario> h3 = new ArrayList<Horario>();
//		h2.add(new Horario(Dia.JUEVES, 20, 22));
//		h2.add(new Horario(Dia.VIERNES, 8, 12));
//		List<Horario> h4 = new ArrayList<Horario>();
//		h4.add(new Horario(Dia.SABADO, 10, 12));
//		Carrera c = new Carrera("Licenciatura en Sistemas");
//		List<Carrera> ca = new ArrayList<Carrera>();
//		ca.add(c);
//		c.setId(0);
//		Curso c1 = new Curso(ca, mn, h, "01");
//		Curso c2 = new Curso(ca, m, h2, "01");
//		Curso c3 = new Curso(ca, mt, h3, "01");
//		Curso c4 = new Curso(ca, mt, h4, "01");
//
//		ArrayList<Curso> cursos = new ArrayList<Curso>();
//		cursos.add(c1);
//		cursos.add(c2);
//		cursos.add(c3);
//		cursos.add(c4);
//		Recomendacion reco = new Recomendacion(5000);
//		reco.backtracking(cursos);
//		assertNotNull(reco.getRecomendacion());
//	}
//
//	public void testRecomendacionJuevesViernesSabadoIguales() throws Exception
//	{
//		Materia m = new Materia("M");
//		Materia mn = new Materia("N");
//		Materia mt = new Materia("T");
//		List<Horario> h = new ArrayList<Horario>();
//		h.add(new Horario(Dia.JUEVES, 20, 22));
//		List<Horario> h2 = new ArrayList<Horario>();
//		h2.add(new Horario(Dia.VIERNES, 18, 22));
//		h2.add(new Horario(Dia.SABADO, 8, 12));
//		List<Horario> h3 = new ArrayList<Horario>();
//		h3.add(new Horario(Dia.JUEVES, 20, 22));
//		h3.add(new Horario(Dia.VIERNES, 18, 22));
//		List<Horario> h4 = new ArrayList<Horario>();
//		h4.add(new Horario(Dia.SABADO, 8, 10));
//		Carrera c = new Carrera("Licenciatura en Sistemas");
//		List<Carrera> ca = new ArrayList<Carrera>();
//		ca.add(c);
//		c.setId(0);
//		Curso c1 = new Curso(ca, mn, h, "01");
//		Curso c2 = new Curso(ca, m, h2, "01");
//		Curso c3 = new Curso(ca, mt, h3, "01");
//		Curso c4 = new Curso(ca, mt, h4, "01");
//
//		ArrayList<Curso> cursos = new ArrayList<Curso>();
//		cursos.add(c1);
//		cursos.add(c2);
//		cursos.add(c3);
//		cursos.add(c4);
//		Recomendacion reco = new Recomendacion(5000);
//		reco.backtracking(cursos);
//		assertNotNull(reco.getRecomendacion());
//	}
//
//	public void testRecomendacionDiaInexistente() throws Exception
//	{
//		Materia m = new Materia("M");
//		List<Horario> h = new ArrayList<Horario>();
//		h.add(new Horario(Dia.valueOf("asd"), 18, 22));
//		Carrera c = new Carrera("Licenciatura en Sistemas");
//		List<Carrera> ca = new ArrayList<Carrera>();
//		ca.add(c);
//		c.setId(0);
//		Curso c1 = new Curso(ca, m, h, "01");
//
//		ArrayList<Curso> cursos = new ArrayList<Curso>();
//		cursos.add(c1);
//		Recomendacion reco = new Recomendacion(5000);
//		reco.backtracking(cursos);
//		assertEquals(0, reco.getRecomendacion().size());
//	}
//
//	public void testcantMateriasCero()
//	{
//		Recomendacion reco = new Recomendacion(5000);
//		List<Recomendacion> lre = new ArrayList<Recomendacion>();
//		assertEquals(0, reco.cantMaterias(lre).size());
//	}
//
//	public void testRecomendacionNoFinishOkGeneracionRecos() throws Exception
//	{
//		Materia m = new Materia("M");
//		List<Horario> h = new ArrayList<Horario>();
//		h.add(new Horario(Dia.JUEVES, 18, 22));
//		Carrera c = new Carrera("Licenciatura en Sistemas");
//		List<Carrera> ca = new ArrayList<Carrera>();
//		ca.add(c);
//		c.setId(0);
//		Curso c1 = new Curso(ca, m, h, "01");
//
//		ArrayList<Curso> cursos = new ArrayList<Curso>();
//		cursos.add(c1);
//		Recomendacion recom = new Recomendacion(1000);
//		recom.backtracking(cursos);
//		assertTrue(recom.seCompletoLaGeneracionDeRecomendaciones());
//	}
//
//	public void testRecomendacionFinishOkGeneracionRecos() throws Exception
//	{
//		Materia m = new Materia("M");
//		Materia mn = new Materia("N");
//		Materia mt = new Materia("T");
//		Materia ma = new Materia("E");
//		List<Horario> h = new ArrayList<Horario>();
//		h.add(new Horario(Dia.JUEVES, 18, 22));
//		h.add(new Horario(Dia.SABADO, 8, 12));
//		List<Horario> h2 = new ArrayList<Horario>();
//		h2.add(new Horario(Dia.VIERNES, 18, 20));
//		h2.add(new Horario(Dia.SABADO, 8, 12));
//		h2.add(new Horario(Dia.LUNES, 8, 12));
//		h2.add(new Horario(Dia.MARTES, 18, 20));
//		List<Horario> h3 = new ArrayList<Horario>();
//		h3.add(new Horario(Dia.JUEVES, 20, 22));
//		h3.add(new Horario(Dia.VIERNES, 8, 12));
//		h3.add(new Horario(Dia.SABADO, 8, 12));
//		List<Horario> h4 = new ArrayList<Horario>();
//		h4.add(new Horario(Dia.SABADO, 10, 12));
//		Carrera c = new Carrera("Licenciatura en Sistemas");
//		List<Carrera> ca = new ArrayList<Carrera>();
//		ca.add(c);
//		c.setId(0);
//		Curso c1 = new Curso(ca, mn, h, "01");
//		Curso c2 = new Curso(ca, m, h2, "01");
//		Curso c3 = new Curso(ca, mt, h3, "01");
//		Curso c4 = new Curso(ca, ma, h4, "01");
//
//		ArrayList<Curso> cursos = new ArrayList<Curso>();
//		cursos.add(c1);
//		cursos.add(c2);
//		cursos.add(c3);
//		cursos.add(c4);
//		Recomendacion recom = new Recomendacion(-1);
//		recom.backtracking(cursos);
//		assertFalse(recom.seCompletoLaGeneracionDeRecomendaciones());
//	}
//
//	public void testCantPosCorrelativasSinRecomendaciones()
//	{
//		List<Recomendacion> recos = new ArrayList<Recomendacion>();
//		Recomendacion r = new Recomendacion(1000);
//		Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
//		a.init();
//		int cant = 0;
//		for (Integer i : r.cantPosCorrelativas(recos, a.getPlanEstudios()))
//		{
//			cant += i;
//		}
//		assertEquals(0, cant);
//	}
//
//	public void testCantPosCorrelativasRecomendacionSinCursos()
//	{
//		List<Recomendacion> recos = new ArrayList<Recomendacion>();
//		Recomendacion r = new Recomendacion(1000);
//		recos.add(r);
//		Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
//		a.init();
//		int cant = 0;
//		for (Integer i : r.cantPosCorrelativas(recos, a.getPlanEstudios()))
//		{
//			cant += i;
//		}
//		assertEquals(0, cant);
//	}
//
//	public void testCantPosCorrelativasPlanEstudiosSinCorrelativas() throws Exception
//	{
//		Materia m = new Materia("Ingles Lectocomprension I");
//		Carrera c = new Carrera("Licenciatura en Sistemas");
//		List<Horario> h = new ArrayList<Horario>();
//		h.add(new Horario(Dia.JUEVES, 18, 22));
//		List<Carrera> ca = new ArrayList<Carrera>();
//		ca.add(c);
//		Curso c1 = new Curso(ca, m, h, "01");
//		ArrayList<Curso> cursos = new ArrayList<Curso>();
//		cursos.add(c1);
//		Recomendacion recom = new Recomendacion(1000);
//		List<Recomendacion> recos = recom.backtracking(cursos);
//		recos.add(recom);
//		HashMap<Materia, Set<Materia>> correlativas = new HashMap<Materia, Set<Materia>>();
//		PlanEstudio pe = new PlanEstudio(c, correlativas);
//		int cant = 0;
//		for (Integer i : recom.cantPosCorrelativas(recos, pe))
//		{
//			cant += i;
//		}
//		assertEquals(0, cant);
//	}
//
//	public void testCantPosCorrelativasVacio() throws Exception
//	{
//		Materia m = new Materia("Ingles Lectocomprension III");
//		Carrera c = new Carrera("Licenciatura en Sistemas");
//		List<Horario> h = new ArrayList<Horario>();
//		h.add(new Horario(Dia.JUEVES, 18, 22));
//		List<Carrera> ca = new ArrayList<Carrera>();
//		ca.add(c);
//		Curso c1 = new Curso(ca, m, h, "01");
//		ArrayList<Curso> cursos = new ArrayList<Curso>();
//		cursos.add(c1);
//		Recomendacion recom = new Recomendacion(1000);
//		List<Recomendacion> recos = recom.backtracking(cursos);
//		recos.add(recom);
//		Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
//		a.init();
//		PlanEstudio pe = a.getPlanEstudios();
//		int cant = 0;
//		for (Integer i : recom.cantPosCorrelativas(recos, pe))
//		{
//			cant += i;
//		}
//		assertEquals(0, cant);
//	}
//
//	public void testCantPosCorrelativasPositivo() throws Exception
//	{
//		Materia m = new Materia("Ingles Lectocomprension I");
//		List<Horario> h = new ArrayList<Horario>();
//		h.add(new Horario(Dia.JUEVES, 18, 22));
//		Carrera c = new Carrera("Licenciatura en Sistemas");
//		List<Carrera> ca = new ArrayList<Carrera>();
//		ca.add(c);
//		c.setId(0);
//		Curso c1 = new Curso(ca, m, h, "01");
//
//		ArrayList<Curso> cursos = new ArrayList<Curso>();
//		cursos.add(c1);
//		Recomendacion recom = new Recomendacion(1000);
//		List<Recomendacion> recos = recom.backtracking(cursos);
//		recos.add(recom);
//		Alta_mat_cur_matApr a = new Alta_mat_cur_matApr();
//		a.init();
//		int cant = 0;
//		for (Integer i : recom.cantPosCorrelativas(recos, a.getPlanEstudios()))
//		{
//			cant += i;
//		}
//		assertEquals(1, cant);
//	}
//
//	public void testOrdenarRecomendacionesSinRecomendacion()
//	{
//		Recomendacion reco = new Recomendacion(5000);
//		List<Recomendacion> recomendaciones = new ArrayList<Recomendacion>();
//		ArrayList<Integer> cantMaterias = reco.cantMaterias(recomendaciones);
//		reco.ordenarRecomendaciones(recomendaciones, cantMaterias);
//		assertNotNull(recomendaciones);
//	}
//
//	public void testOrdenarRecomendacionesConUnaRecomendacion()
//	{
//		Recomendacion reco = new Recomendacion(5000);
//		List<Recomendacion> recomendaciones = new ArrayList<Recomendacion>();
//		ArrayList<Integer> cantMaterias = reco.cantMaterias(recomendaciones);
//		reco.ordenarRecomendaciones(recomendaciones, cantMaterias);
//		assertNotNull(recomendaciones);
//	}
//
//	public void testOrdenarRecomendacionesMenorAMayor()
//	{
//		Materia m = new Materia("Ingles Lectocomprension I");
//		List<Horario> h = new ArrayList<Horario>();
//		h.add(new Horario(Dia.JUEVES, 18, 22));
//		Carrera c = new Carrera("Licenciatura en Sistemas");
//		List<Carrera> ca = new ArrayList<Carrera>();
//		ca.add(c);
//		Curso c1 = new Curso(ca, m, h, "01");
//		ArrayList<Curso> cursos = new ArrayList<Curso>();
//		cursos.add(c1);
//		Recomendacion recom = new Recomendacion(5000);
//		recom.setRecomendacion(cursos);
//
//		Materia m2 = new Materia("Ingles Lectocomprension II");
//		List<Horario> h2 = new ArrayList<Horario>();
//		h.add(new Horario(Dia.VIERNES, 18, 22));
//		Curso c2 = new Curso(ca, m2, h2, "01");
//		List<Curso> cursos2 = new ArrayList<Curso>();
//		cursos2.add(c1);
//		cursos2.add(c2);
//		Recomendacion reco2 = new Recomendacion(5000);
//		reco2.setRecomendacion(cursos2);
//		List<Recomendacion> recomendaciones = new ArrayList<Recomendacion>();
//		recomendaciones.add(recom);
//		recomendaciones.add(reco2);
//		ArrayList<Integer> cantMaterias = recom.cantMaterias(recomendaciones);
//		recom.ordenarRecomendaciones(recomendaciones, cantMaterias);
//		
//		boolean ordenado = true;
//		int anterior = cantMaterias.get(0);
//		for(int actual : cantMaterias){
//			if(actual > anterior)
//				ordenado = false;
//			anterior = actual;
//		}
//		assertTrue(ordenado);
//	}
//	
//	public void testOrdenarRecomendacionesMayorAMenor()
//	{
//		Materia m = new Materia("Ingles Lectocomprension I");
//		List<Horario> h = new ArrayList<Horario>();
//		h.add(new Horario(Dia.JUEVES, 18, 22));
//		Carrera c = new Carrera("Licenciatura en Sistemas");
//		List<Carrera> ca = new ArrayList<Carrera>();
//		ca.add(c);
//		Curso c1 = new Curso(ca, m, h, "01");
//		ArrayList<Curso> cursos = new ArrayList<Curso>();
//		cursos.add(c1);
//		Recomendacion recom = new Recomendacion(5000);
//		recom.setRecomendacion(cursos);
//
//		Materia m2 = new Materia("Ingles Lectocomprension II");
//		List<Horario> h2 = new ArrayList<Horario>();
//		h.add(new Horario(Dia.VIERNES, 18, 22));
//		Curso c2 = new Curso(ca, m2, h2, "01");
//		List<Curso> cursos2 = new ArrayList<Curso>();
//		cursos2.add(c1);
//		cursos2.add(c2);
//		Recomendacion reco2 = new Recomendacion(5000);
//		reco2.setRecomendacion(cursos2);
//		List<Recomendacion> recomendaciones = new ArrayList<Recomendacion>();
//		recomendaciones.add(reco2);
//		recomendaciones.add(recom);
//		ArrayList<Integer> cantMaterias = recom.cantMaterias(recomendaciones);
//		recom.ordenarRecomendaciones(recomendaciones, cantMaterias);
//		
//		boolean ordenado = true;
//		int anterior = cantMaterias.get(0);
//		for(int actual : cantMaterias){
//			if(actual > anterior)
//				ordenado = false;
//			anterior = actual;
//		}
//		assertTrue(ordenado);
//	}
//
//}
