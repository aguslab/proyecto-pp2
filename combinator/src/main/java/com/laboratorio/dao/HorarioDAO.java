package com.laboratorio.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

}
