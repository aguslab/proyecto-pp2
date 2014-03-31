package com.laboratorio.dao;

import java.util.ArrayList;
import java.util.List;

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
import com.laboratorio.modelo.Materia;
import com.laboratorio.modelo.PlanEstudio;
import com.laboratorio.modelo.Recomendacion;

public class CursoDAO 
{
	private static CursoDAO instancia = null;

	String[] dias = new String[12];
	String[] horariosOcupados = new String[12];
	int cantidadDeseada = 3; //Cantidad de materias que el alumno quiere cursar. No va declarado aca.
	
	@PersistenceContext(unitName = "PU")
	private static EntityManager em = null;

	public static CursoDAO getInstancia() throws Exception 
	{
		if (instancia == null) 
		{
			instancia = new CursoDAO();
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
	
	public List<Curso> getCursosPorTurno(Integer horaInicio)
	{
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Curso> cq = builder.createQuery(Curso.class);
		Root<Curso> cur = cq.from(Curso.class);
		cq.select(cur);

		Join<Curso, Horario> jo = cur.join("horario");
		Predicate conjuncion = builder.conjunction();

		conjuncion.getExpressions().add(
				builder.greaterThanOrEqualTo(
						jo.get("horaInicio").as(Integer.class), horaInicio));

		// TODO!! revisar!
		Join<Curso, Materia> joMat = cur.join("materia");

		cq.where(conjuncion);
		TypedQuery<?> q = em.createQuery(cq);

		return (List<Curso>) q.getResultList();
	}
	
	//Cuenta la cantidad de veces que aparece cada materia en la tabla de
		//materias_aprobadas. cantAprobada = 0 no está aprobada, cantAprobada>0 esta aprobada
		public ArrayList<Curso> quitarMateriasAprobadas(ArrayList<Curso> cursos) 
		{
			Integer materia_id;
			for(int i= 0; i < cursos.size(); i++)
			{
				materia_id = cursos.get(i).getMateria().getId();
				String a = new String("0");
				System.out.println("id materia:" + materia_id );
				Query query = em.createQuery("SELECT COUNT(*) FROM MateriaAprobada WHERE materia.id = " +  materia_id);
				System.out.println("query " + query.getResultList().get(0).toString());
				
				if(!query.getResultList().get(0).toString().equals(a))
				{
					System.out.println("borro " + materia_id);
					cursos.remove(i);
				}
			}
			return cursos;
		}
		
		public ArrayList<Curso> quitarCorrelativasNoCursables(ArrayList<Curso> cursos) 
		{
			System.out.println("entra");
			Integer materia_id; //"SELECT materias FROM PlanEstudio INNER JOIN Curso ON correlativas_id = materia_id"
			Query query = em.createQuery("SELECT pe.materias FROM PlanEstudio pe INNER JOIN Curso c ON pe.correlativas.id = c.materia.id");
			System.out.println("sale query");
			for(int i= 0; i < query.getResultList().size(); i++)
			{
				materia_id = cursos.get(i).getMateria().getId();
				if(!query.getResultList().get(i).toString().equals(materia_id.toString()))
				{
					System.out.println("borro " + materia_id.toString());
					cursos.remove(i);
				}
			}
			System.out.println("return");
			return cursos;
		}
		
		public Recomendacion combinaciones(ArrayList<Curso> cursos) 
		{
			Integer curso_id; 
			int i = 0;
			while(i < cursos.size() && this.cantidadDeseada != 0)
			{
				curso_id = cursos.get(i).getMateria().getId();
				/*Query query = em.createQuery("SELECT h.dia, h.horaInicio, h.horaFin FROM Horario h INNER JOIN cursos_horario ch"
						+ " ON  h.id_horario = ch.horario_id_horario WHERE ch.Cursos_id =" + curso_id); *///devuelve el horario del curso
				Query query = em.createQuery("SELECT h.dia, h.horaInicio, h.horaFin FROM Horario h INNER JOIN cursos_horario ch"
						+ " ON  h.id_horario = ch.horario_id_horario WHERE ch.Cursos_id =" + curso_id); //devuelve el horario del curso
				@SuppressWarnings("unchecked")
				List<Horario> resultados = query.getResultList();
				
				Query query2 = em.createQuery("SELECT m.nombre FROM materias m INNER JOIN cursos c ON  m.id = c.materia_id "
						+ "WHERE c.id = " + curso_id); //devuelve el nombre del curso
				String nombreMateria = query2.getResultList().get(0).toString();
				revisarHorarioNoche(resultados.get(i), nombreMateria); //pasamos horario y nombre para ubicar en la semana
				i++;
			}
			Recomendacion recomendacion = new Recomendacion(dias,horariosOcupados); //Una vez que los cursos estan ubicados en la semana, guardamos la recomendación
			return recomendacion; //Se necesitaria un ciclo mas para hacer la combinacion de las materias y asi ir guardando en una lista todas las recomendaciones
		}
		
		public void revisarHorarioNoche(Horario horario, String nombreMateria)
		{
			Boolean materiaUsada = false; //Indicador para saber si la materia logró ubicarse en algún día
			if(horario.getHoraInicio() == 18 && horario.getHoraFin() == 22)
			{
				 if(horario.getDia().equals("Lunes") && dias[0] == null && dias[1] == null) //Si es una materia que se dicta los Lunes 4 horas se guardará en dias[0] siempre que no haya una materia los lunes de 2 horas ocupando dias[0] y/o dias[1] 
				 {
					 dias[0] = nombreMateria;
					 this.horariosOcupados[0] = "18 a 22";
					 materiaUsada = true;
				 }
				 if(horario.getDia().equals("Martes") && dias[2] == null && dias[3] == null)
				 {
					 dias[2] = nombreMateria;
					 this.horariosOcupados[2] = "18 a 22";
					 materiaUsada = true;
				 }
				 if(horario.getDia().equals("Miercoles") && dias[4] == null && dias[5] == null)
				 {
					 dias[4] = nombreMateria;
					 this.horariosOcupados[4] = "18 a 22";
					 materiaUsada = true;
				 }
				 if(horario.getDia().equals("Jueves") && dias[6] == null && dias[7] == null)
				 {
					 dias[6] = nombreMateria;
					 this.horariosOcupados[6] = "18 a 22";
					 materiaUsada = true;
				 }
				 if(horario.getDia().equals("Viernes") && dias[8] == null && dias[9] == null)
				 {
					 dias[8] = nombreMateria;
					 this.horariosOcupados[8] = "18 a 22";
					 materiaUsada = true;
				 }
				 if(horario.getDia().equals("Sabado") && dias[10] == null && dias[11] == null)
				 {
					 dias[10] = nombreMateria;
					 this.horariosOcupados[10] = "18 a 22";
					 materiaUsada = true;
				 }
			}
			else if(horario.getHoraInicio() == 18 && horario.getHoraFin() == 20)
			{
				if(horario.getDia().equals("Lunes") && dias[0] == null)
				 {
					dias[0] = nombreMateria;
					this.horariosOcupados[0] = "18 a 20";
					materiaUsada = true;
				 }
				 if(horario.getDia().equals("Martes") && dias[2] == null)
				 {
					dias[2] = nombreMateria;
					this.horariosOcupados[2] = "18 a 20";
					materiaUsada = true;
				 }
				 if(horario.getDia().equals("Miercoles") && dias[4] == null)
				 {
					dias[4] = nombreMateria;
					this.horariosOcupados[4] = "18 a 20";
					materiaUsada = true;
				 }
				 if(horario.getDia().equals("Jueves") && dias[6] == null)
				 {
					dias[6] = nombreMateria;
					this.horariosOcupados[6] = "18 a 20";
					materiaUsada = true;
				 }
				 if(horario.getDia().equals("Viernes") && dias[8] == null)
				 {
					dias[8] = nombreMateria;
					this.horariosOcupados[8] = "18 a 20";
					materiaUsada = true;
				 }
				 if(horario.getDia().equals("Sabado") && dias[10] == null)
				 {
					dias[10] = nombreMateria;
					this.horariosOcupados[10] = "18 a 20";
					materiaUsada = true;
				 }
			}
			else
			{
				if(horario.getDia().equals("Lunes") && dias[1] == null)
				 {
					dias[1] = nombreMateria;
					this.horariosOcupados[1] = "20 a 22";
					materiaUsada = true;
				 }
				 if(horario.getDia().equals("Martes") && dias[3] == null)
				 {
					dias[3] = nombreMateria;
					this.horariosOcupados[3] = "20 a 22";
					materiaUsada = true;
				 }
				 if(horario.getDia().equals("Miercoles") && dias[5] == null)
				 {
					dias[5] = nombreMateria;
					this.horariosOcupados[5] = "20 a 22";
					materiaUsada = true;
				 }
				 if(horario.getDia().equals("Jueves") && dias[7] == null)
				 {
					dias[7] = nombreMateria;
					this.horariosOcupados[7] = "20 a 22";
					materiaUsada = true;
				 }
				 if(horario.getDia().equals("Viernes") && dias[9] == null)
				 {
					dias[9] = nombreMateria;
					this.horariosOcupados[9] = "20 a 22";
					materiaUsada = true;
				 }
				 if(horario.getDia().equals("Sabado") && dias[11] == null)
				 {
					dias[11] = nombreMateria;
					this.horariosOcupados[11] = "20 a 22";
					materiaUsada = true;
				 }
			}

			if (materiaUsada) //Si se usó la materia entonces la descontamos de cantidadDeseada
			{
				cantidadDeseada--;
			}
		}
		
}
