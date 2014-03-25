package com.laboratorio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.laboratorio.modelo.Turno;


public class TurnoDAO 
{
	private static TurnoDAO instancia = null;

	@PersistenceContext(unitName = "PU")
	private static EntityManager em = null;

	public static TurnoDAO getInstancia() throws Exception 
	{
		if (instancia == null)
		{
			instancia = new TurnoDAO();
		}
		em = com.laboratorio.dao.EntityManagerUtil.getNewEM();
		return instancia;
	}
	
	
	public void alta(Turno T) throws Exception 
	{
		try 
		{
			em.getTransaction().begin();
			em.merge(T);
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
	public List<Turno> obtenerTodo() 
	{
		List<Turno> a = null;
		Query query = em.createQuery("from Turnos");
		a = query.getResultList();
		return a;
	}

	public Turno getTurno(int id)
	{
		Turno S = em.find(Turno.class, id);
		return S;
	}
}
