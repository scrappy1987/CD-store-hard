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
	
	@SuppressWarnings("unchecked")
	@Override
	public String getAllCDs() {
		Query query = em.createQuery("SELECT e FROM CD e");
		Collection<CD> cds = (Collection<CD>) query.getResultList();
		return util.getJSONForObject(cds);
	}

	@Override
	public String addCD(String jsonCD) {
		CD newCD = util.getObjectForJSON(jsonCD, CD.class);
		em.persist(newCD);
		return jsonCD;
	}

	@Override
	public String updateCD(Integer cdId, String jsonCDUpdated) {
		CD updatingCD = util.getObjectForJSON(jsonCDUpdated, CD.class);
		CD cd = findCD(cdId);
		if (cd != null){
			cd = updatingCD;
			em.merge(cd);
		}
		return "{\"message\": \"cd successfully updated\"}";
	}

	@Override
	public String deleteCD(Integer cdId) {
		CD cd = findCD(cdId);
		if(cd != null){
			em.remove(cd);
		}
		return "{\"message\": \"cd successfully removed\"}";
	}
	
	private CD findCD(Integer id){
		return em.find(CD.class, id);
	}
	
}
