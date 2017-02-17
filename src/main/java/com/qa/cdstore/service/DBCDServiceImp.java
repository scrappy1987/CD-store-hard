package com.qa.cdstore.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

@Stateless
@Default
public class DBCDServiceImp implements CDService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	JSONUtil util;
	
	@Override
	@SuppressWarnings("unchecked")
	public String getAllCds()
	{
		Query query = em.createQuery("SELECT c FROM CD c");
		List<CD> cds = (ArrayList<CD>) query.getResultList();
		if(cds.isEmpty())
		{
			return "No CD's";
		}else
		{
			return util.objectToJSON(cds);
		}
	}
	
	@Override
	public String getSingleCD(int id)
	{
		try
		{
			CD cd = em.find(CD.class, id);
			return util.objectToJSON(cd);
		}catch(Exception e)
		{
			return "CD not found";
		}
		
	}
	
	@Override
	public String deleteCD(int id)
	{
		try
		{
			CD cd = em.find(CD.class, id);
			em.remove(cd);
			return "CD Removed";
		}catch(Exception e)
		{
			return "CD not found";
		}
	}
	
	@Override
	public String addCD(String objJSON)
	{
		CD cd = util.jsonToObject(objJSON, CD.class);
		try
		{
			em.persist(cd);	
			return "CD Added";
		}catch(Exception e)
		{
			return "Error CD not added";
		}
	}
	
	@Override
	public String updateCD(int id, String objSJON)
	{
		try
		{ 
			CD cd = em.find(CD.class, id);
			CD newCd = util.jsonToObject(objSJON, CD.class);
			cd = newCd;
			em.merge(cd);
			return "CD Updated";
			
		}catch (Exception e)
		{
			return "Update unsuccessful";
		}
	}

}
