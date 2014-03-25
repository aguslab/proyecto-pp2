package com.laboratorio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.laboratorio.modelo.Curso;

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
}
