package com.laboratorio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.laboratorio.modelo.Horario;


public class HorarioDAO 
{
	private static HorarioDAO instancia = null;

	@PersistenceContext(unitName = "PU")
	private static EntityManager em = null;

	public static HorarioDAO getInstancia() throws Exception 
	{
		if (instancia == null)
		{
			instancia = new HorarioDAO();
		}
		em = com.laboratorio.dao.EntityManagerUtil.getNewEM();
		return instancia;
	}
	
	
	public void alta(Horario H) throws Exception 
	{
		try 
		{
			em.getTransaction().begin();
			em.merge(H);
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
	public List<Horario> obtenerTodo() 
	{
		List<Horario> a = null;
		Query query = em.createQuery("from Turnos");
		a = query.getResultList();
		return a;
	}

	public Horario getTurno(int id)
	{
		Horario S = em.find(Horario.class, id);
		return S;
	}
}
