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
public class DBCDServiceImp implements CDServiceInterface{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;
	
	@Override
	public String getAllCDs() {
		Query query = em.createQuery("SELECT e FROM CD e");
		Collection<CD> cds = (Collection<CD>) query.getResultList();
		return util.ObjectToJSON(cds);
	}

	@Override
	public String addNewCD(String cdJson) {
		CD newCD = util.JSONToObject(cdJson, CD.class);
		em.persist(newCD);
		return cdJson;
	}

	@Override
	public String replaceCD(Integer cdId, String updatedCD) {
		CD updateCD = util.JSONToObject(updatedCD, CD.class);
		CD cd = findCD(new Long(cdId));
		if(cd != null) {
			cd = updateCD;
			em.merge(cd);
		}
		return "CD successfully updated";
	}

	private CD findCD(Long id) {
		// TODO Auto-generated method stub
		return em.find(CD.class, id);
	}

	@Override
	public String deleteCD(Integer cdId) {
		CD cd = findCD(new Long(cdId));
		if(cd != null) {
			em.remove(cd);
		}
		return "CD successfully removed";
	}
	

}
