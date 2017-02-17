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
	
	@Inject JSONUtil util;
	
	@Override
	public String getAllCDs(){
		Query query = em.createQuery("SELECT e FROM CD e");
		Collection<CD> cds = (Collection<CD>) query.getResultList();
		return util.getJSONForObject(cds);
	}

	@Override
	public String addNewCD(String cdJson) {
		CD newCD = util.getObjectForJSON(cdJson, CD.class);
		em.persist(newCD);
		return cdJson;
	}

	@Override
	public String updateCD(int cdId, String updatedCD) {
		CD updateCD = util.getObjectForJSON(updatedCD, CD.class);
		CD cd = findCD(new Long(cdId));
		if (cd != null)
		{
			cd = updateCD;
			em.merge(cd);
		}
		return "{\"message\": \"cd succesfully updated\"}";
	}

	@Override
	public String deleteCD(int cdId) {
		CD cd = findCD(new Long(cdId));
		if(cd != null)
		{
			em.remove(cd);
		}
		return "{\"message\": \"cd succesfully removed\"}";
	}
	
	private CD findCD(Long id){
		return em.find(CD.class, id);
	}
}
