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
public class MAPCDServiceImp implements CDService {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllCDs() {
		Query query = em.createQuery("SELECT c FROM cd c");
		Collection<CD>cds = (Collection<CD>) query.getResultList();
		return util.getJSONForObject(cds);
	}

	@Override
	public String addNewCD(String cdJson) {
		CD cd = util.getObjectForJSON(cdJson,CD.class);
		em.persist(cd);
		return cdJson;
	}

	private CD findCD(Long id) {
		return em.find(CD.class,id);
	}
	
	@Override
	public String replaceCD(Integer id, String updatedCD) {
		CD updateCD = util.getObjectForJSON(updatedCD, CD.class);
		CD cd = findCD(new Long(id));
		if (cd != null) {
			cd = updateCD;
			em.merge(cd);
		}
		
		return "{\" message\": \"CD updated successfully\"}";
	}


	@Override
	public String deleteCD(Integer id) {
		CD cd = findCD(new Long(id));
		if (cd != null) {
			em.remove(cd);
		}
		
		return "{\"message\": \"Successfully removed CD\"}";
	}
}
