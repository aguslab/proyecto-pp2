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

public class CursoDAO 
{
	private static CursoDAO instancia = null;

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
		Query query = em.createQuery("from Cursos");
		a = query.getResultList();
		return a;
	}

	public Curso getCurso(int id) 
	{
		Curso S = em.find(Curso.class, id);
		return S;
	}
	
	public ArrayList<Curso> getCursosPorTurno(Integer horaInicio){
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Curso> cq = builder.createQuery(Curso.class);
		Root<Curso> cur = cq.from(Curso.class);
		cq.select(cur);
		
		Join<Curso,Horario> jo = cur.join("horario");
		Predicate conjuncion = builder.conjunction();
		
		conjuncion.getExpressions().add(builder.greaterThanOrEqualTo(jo.get("horaInicio").as(Integer.class), horaInicio));
		
		Join<Curso,Materia> joMat = cur.join("materia");
		
		cq.where(conjuncion);
		TypedQuery<?> q = em.createQuery(cq);
		
		return (ArrayList<Curso>) q.getResultList();
	}
	
	//Cuenta la cantidad de veces que aparece cada materia en la tabla de
		//materias_aprobadas. cantAprobada = 0 no está aprobada, cantAprobada>0 esta aprobada
		public ArrayList<Curso> quitarAprobadas(ArrayList<Curso> cursos) 
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
}
