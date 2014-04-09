package com.laboratorio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.laboratorio.modelo.PlanEstudio;

public class PlanEstudioDAO 
{
	private static PlanEstudioDAO instancia = null;

	@PersistenceContext(unitName = "PU")
	private static EntityManager em = null;

	public static PlanEstudioDAO getInstancia() throws Exception 
	{
		if (instancia == null)
		{
			instancia = new PlanEstudioDAO();
		}
		em = com.laboratorio.dao.EntityManagerUtil.getNewEM();
		return instancia;
	}
	
	
	public void alta(PlanEstudio PE) throws Exception 
	{
		try 
		{
			em.getTransaction().begin();
			em.merge(PE);
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
	public List<PlanEstudio> obtenerTodo() 
	{
		List<PlanEstudio> a = null;
		Query query = em.createQuery("from PlanEstudio");
		a = query.getResultList();
		return a;
	}

}
