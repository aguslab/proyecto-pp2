package com.laboratorio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.laboratorio.modelo.MateriaAprobada;


public class MateriaAprobadaDAO 
{
	private static MateriaAprobadaDAO instancia = null;

	@PersistenceContext(unitName = "PU")
	private static EntityManager em = null;

	public static MateriaAprobadaDAO getInstancia() throws Exception 
	{
		if (instancia == null)
		{
			instancia = new MateriaAprobadaDAO();
		}
		em = com.laboratorio.dao.EntityManagerUtil.getNewEM();
		return instancia;
	}
	
	
	public void alta(MateriaAprobada MA) throws Exception 
	{
		try 
		{
			em.getTransaction().begin();
			em.merge(MA);
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
	public List<MateriaAprobada> obtenerTodo() 
	{
		List<MateriaAprobada> a = null;
		Query query = em.createQuery("from MateriaAprobada");
		a = query.getResultList();
		return a;
	}

	public MateriaAprobada getMateria(int id)
	{
		MateriaAprobada S = em.find(MateriaAprobada.class, id);
		return S;
	}
}
