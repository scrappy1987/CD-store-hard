package com.qa.cdstore.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

@Stateless
@Default
public class DBCDServiceImp implements CDService {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	@SuppressWarnings("unchecked")
	@Override
	public String getAllCDs() {
		Query query = em.createQuery("SELECT c FROM CD c");
		Collection<CD> cds = (Collection<CD>) query.getResultList();
		return util.getJSONForObject(cds);
	}

	@Override
	public String addNewCD(String cdJson) {
		CD newCD = util.getObjectForJSON(cdJson, CD.class);
		em.persist(newCD);
		return "Added cd";
	}

	@Override
	public String replaceCD(Long cdId, String updatedCD) {
		CD updateCD = util.getObjectForJSON(updatedCD, CD.class);
		CD cd = em.find(CD.class, cdId);
		if (cd != null) {
			cd = updateCD;
			em.merge(cd);
		}
		return "{\"message\": \"updated cd\"}";
	}

	@Override
	public String deleteCD(Long cdId) {
		CD cd = em.find(CD.class, cdId);
		if (cd != null) {
			em.remove(cd);
		}
		return "{\"message\": \"deleted cd\"}"; 
	}

}
