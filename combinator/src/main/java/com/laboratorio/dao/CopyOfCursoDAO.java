package com.laboratorio.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.laboratorio.modelo.Curso;
import com.laboratorio.modelo.Horario;
import com.laboratorio.modelo.Recomendacion;

public class CopyOfCursoDAO 
{
	private static CopyOfCursoDAO instancia = null;
	@PersistenceContext(unitName = "PU")
	private static EntityManager em = null;
	ArrayList<Recomendacion> recomendaciones = new ArrayList<Recomendacion>();
	
	public static CopyOfCursoDAO getInstancia() throws Exception 
	{
		if (instancia == null) 
		{
			instancia = new CopyOfCursoDAO();
		}
		em = com.laboratorio.dao.EntityManagerUtil.getNewEM();
		return instancia;
	}
	
	
	public void alta(Curso C) throws Exception 
	{
		try 
		{
			em.getTransaction().begin();
			em.merge(C);
			em.flush();
			em.getTransaction().commit();
		} 
		catch (Exception e) 
		{
			em.getTransaction().rollback();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Curso> obtenerTodo() 
	{
		List<Curso> a = null;
		Query query = em.createQuery("from Curso");
		a = query.getResultList();
		return a;
	}

	public Curso getCurso(int id) 
	{
		Curso S = em.find(Curso.class, id);
		return S;
	}
	
	@SuppressWarnings("unchecked")
	public Set<Curso> getCursosPorTurno(Integer horaInicio)
	{
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Curso> cq = builder.createQuery(Curso.class);
		Root<Curso> cur = cq.from(Curso.class);
		cq.select(cur);
		//TODO: agregar metaclases!
		Join<Curso,Horario> jo = cur.join("horario");
		Predicate conjuncion = builder.conjunction();
		
		conjuncion.getExpressions().add(builder.greaterThanOrEqualTo(jo.get("horaInicio").as(Integer.class), horaInicio));
		
		cq.where(conjuncion);
		TypedQuery<?> q = em.createQuery(cq);
		
		List<Curso> cursos =(List<Curso>) q.getResultList();
		Set<Curso> curs = new HashSet<Curso>();
		for(Curso c : cursos){
			curs.add(c);
		}
		
		return curs;
	}
	
	//Cuenta la cantidad de veces que aparece cada materia en la tabla de
		//materias_aprobadas. cantAprobada = 0 no está aprobada, cantAprobada>0 esta aprobada
		public Set<Curso> quitarMateriasAprobadas(Set<Curso> cursos) 
		{
			int materia_id;
			Set<Curso> cursosCopia = new HashSet<Curso>(cursos);
			for(Curso c : cursosCopia)
			{
				materia_id = c.getMateria().getId();
				String a = new String("0");
//				System.out.println("id materia:" + materia_id );
				Query query = em.createQuery("SELECT COUNT(*) FROM MateriaAprobada WHERE materia.id = " +  materia_id);
//				System.out.println("query " + query.getResultList().get(0).toString());
				
				if(!query.getResultList().get(0).toString().equals(a))
				{
//					System.out.println("borro " + materia_id);
					cursos.remove(c);
				}
			}
			return cursos;
		}
		
//		public List<Curso> quitarCorrelativasNoCursables(List<Curso> cursos) 
//		{
//			System.out.println("entra");
//			Integer materia_id; //"SELECT materias FROM PlanEstudio INNER JOIN Curso ON correlativas_id = materia_id"
//			Query query = em.createQuery("SELECT pe.materias FROM PlanEstudio pe INNER JOIN Curso c ON pe.correlativas.id = c.materia.id");
//			System.out.println("sale query");
//			for(int i= 0; i < query.getResultList().size(); i++)
//			{
//				materia_id = cursos.get(i).getMateria().getId();
//				if(!query.getResultList().get(i).toString().equals(materia_id.toString()))
//				{
//					System.out.println("borro " + materia_id.toString());
//					cursos.remove(i);
//				}
//			}
//			System.out.println("return");
//			return cursos;
//		}
		
		@SuppressWarnings("null")
		public ArrayList<Recomendacion> combinaciones(Set<Curso> cursos) 
		{
			Recomendacion recomendacion = new Recomendacion(); //Voy guardando la combinacion posible en la misma recomendacion hasta que terminemos de recorrer todos los cursos. Tendria que ir como atributo de CursoDAO?
			Set<Curso> cursosSinUsar = new HashSet<Curso>();
			for(Curso curso : cursos)
			{
				recomendacion = revisarHorarioNoche(curso, recomendacion); //pasamos horario y nombre para ubicar en la semana
				if(!recomendacion.isMateriaAsignada(curso)) //Si la materia del curso no se guardó en una recomendacion entonces la guardo para crear otra
					cursosSinUsar.add(curso);
			}
			recomendaciones.add(recomendacion);  //Una vez que los cursos estan ubicados en la semana, guardamos la recomendación
			if(cursosSinUsar.size() != 0)
				combinaciones(cursosSinUsar);
			return recomendaciones; //Se necesitaria un ciclo mas para hacer la combinacion de las materias y asi ir guardando en una lista todas las recomendaciones
		}
		
		public Recomendacion revisarHorarioNoche(Curso curso, Recomendacion recomendacion)
		{
			List<Horario> curso_horarios =  curso.getHorario();
			String nombreMateria = curso.getMateria().getNombre();
			int i = 0;
			while (i < curso_horarios.size())
			{
				if(curso_horarios.get(i).getHoraInicio() == 18 && curso_horarios.get(i).getHoraFin() == 22)
				{
					 if(curso_horarios.get(i).getDia().equals("Lunes") && recomendacion.getLunes()[0] == null && recomendacion.getLunes()[2] == null) //Si es una materia que se dicta los Lunes 4 horas se guardará en dias[0] siempre que no haya una materia los lunes de 2 horas ocupando dias[0] y/o dias[1] 
					 {
						 //los indices 0 y 1 guardan nombre y horario
						 recomendacion.getLunes()[0] = nombreMateria;
						 recomendacion.getLunes()[1] = "18 a 22"; // no pido de nuevo el horario al curso pq ya se que es de 18 a 22
					 }
					 else if(curso_horarios.get(i).getDia().equals("Martes")  && recomendacion.getMartes()[0] == null && recomendacion.getMartes()[2] == null)
					 {
						 recomendacion.getMartes()[0] = nombreMateria;
						 recomendacion.getMartes()[1] = "18 a 22";
					 }
					 else if(curso_horarios.get(i).getDia().equals("Miercoles")  && recomendacion.getMiercoles()[0] == null && recomendacion.getMiercoles()[2] == null)
					 {
						 recomendacion.getMiercoles()[0] = nombreMateria;
						 recomendacion.getMiercoles()[1] = "18 a 22";
					 }
					 else if(curso_horarios.get(i).getDia().equals("Jueves")  && recomendacion.getJueves()[0] == null && recomendacion.getJueves()[2] == null)
					 {
						 recomendacion.getJueves()[0] = nombreMateria;
						 recomendacion.getJueves()[1] = "18 a 22";
					 }
					 else if(curso_horarios.get(i).getDia().equals("Viernes")  && recomendacion.getViernes()[0] == null && recomendacion.getViernes()[2] == null)
					 {
						 recomendacion.getViernes()[0] = nombreMateria;
						 recomendacion.getViernes()[1] = "18 a 22";
					 }
					 else if(curso_horarios.get(i).getDia().equals("Sabado")  && recomendacion.getSabado()[0] == null && recomendacion.getSabado()[2] == null)
					 {
						 recomendacion.getSabado()[0] = nombreMateria;
						 recomendacion.getSabado()[1] = "18 a 22";
					 }
				}
				else if(curso_horarios.get(i).getHoraInicio() == 18 && curso_horarios.get(i).getHoraFin() == 20)
				{
					if(curso_horarios.get(i).getDia().equals("Lunes")  && recomendacion.getLunes()[0] == null)
					 {
						 recomendacion.getLunes()[0] = nombreMateria;
						 recomendacion.getLunes()[1] = "18 a 20";
					 }
					else if(curso_horarios.get(i).getDia().equals("Martes")  && recomendacion.getMartes()[0] == null)
					 {
						 recomendacion.getMartes()[0] = nombreMateria;
						 recomendacion.getMartes()[1] = "18 a 20";
					 }
					else if(curso_horarios.get(i).getDia().equals("Miercoles")  && recomendacion.getMiercoles()[0] == null)
					 {
						 recomendacion.getMiercoles()[0] = nombreMateria;
						 recomendacion.getMiercoles()[1] = "18 a 20";
					 }
					else if(curso_horarios.get(i).getDia().equals("Jueves")  && recomendacion.getJueves()[0] == null)
					 {
						 recomendacion.getJueves()[0] = nombreMateria;
						 recomendacion.getJueves()[1] = "18 a 20";
					 }
					else if(curso_horarios.get(i).getDia().equals("Viernes")  && recomendacion.getViernes()[0] == null)
					 {
						 recomendacion.getViernes()[0] = nombreMateria;
						 recomendacion.getViernes()[1] = "18 a 20";
					 }
					else if(curso_horarios.get(i).getDia().equals("Sabado")  && recomendacion.getSabado()[0] == null)
					 {
						 recomendacion.getSabado()[0] = nombreMateria;
						 recomendacion.getSabado()[1] = "18 a 20";
					 }
				}
				else
				{
					// Si uno de los horarios es lunes pero no es de 18 a 22 y no hay una materia guardada en el horario de 20 a 22 entonces entra al if
					if(curso_horarios.get(i).getDia().equals("Lunes")  && recomendacion.getLunes()[1] != "18 a 22" && recomendacion.getLunes()[2] == null)
					 {
						 recomendacion.getLunes()[2] = nombreMateria;
						 recomendacion.getLunes()[3] = "20 a 22";
					 }
					else if(curso_horarios.get(i).getDia().equals("Martes")  && recomendacion.getMartes()[1] != "18 a 22" && recomendacion.getMartes()[2] == null)
					 {
						 recomendacion.getMartes()[2] = nombreMateria;
						 recomendacion.getMartes()[3] = "20 a 22";
					 }
					else if(curso_horarios.get(i).getDia().equals("Miercoles")  && recomendacion.getMiercoles()[1] != "18 a 22" && recomendacion.getMiercoles()[2] == null)
					 {
						 recomendacion.getMiercoles()[2] = nombreMateria;
						 recomendacion.getMiercoles()[3] = "20 a 22";
					 }
					else if(curso_horarios.get(i).getDia().equals("Jueves")  && recomendacion.getJueves()[1] != "18 a 22" && recomendacion.getJueves()[2] == null)
					 {
						 recomendacion.getJueves()[2] = nombreMateria;
						 recomendacion.getJueves()[3] = "20 a 22";
					 }
					else if(curso_horarios.get(i).getDia().equals("Viernes")  && recomendacion.getViernes()[1] != "18 a 22" && recomendacion.getViernes()[2] == null)
					 {
						 recomendacion.getViernes()[2] = nombreMateria;
						 recomendacion.getViernes()[3] = "20 a 22";
					 }
					else if(curso_horarios.get(i).getDia().equals("Sabado")  && recomendacion.getSabado()[1] != "18 a 22" && recomendacion.getSabado()[2] == null)
					 {
						 recomendacion.getSabado()[2] = nombreMateria;
						 recomendacion.getSabado()[3] = "20 a 22";
					 }
				}
				i++;
			}
			return recomendacion;
		}
}
