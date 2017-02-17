package com.qa.cdstore.service;

import java.util.Collection;

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
public class DBCDServiceImp implements CDService{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllCDs() {
		Query query = em.createQuery("SELECT e FROM CD e");
		Collection<CD> cds = (Collection<CD>) query.getResultList();
		return util.getJSONForObject(cds);
	}

	@Override
	public String getSingleCD(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteCD(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addNewCD(String jsonCD) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateCD(Integer cdId, String updateCD) {
		// TODO Auto-generated method stub
		return null;
	}

	


	
}
