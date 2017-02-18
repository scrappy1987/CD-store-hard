package com.qa.cdstore.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.*;
import javax.inject.Inject;
import javax.persistence.*;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtility;

@Stateless
@Default
public class DBCDService implements CDService {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	@Inject
	private JSONUtility jsonUtil;
	
	@Override
	public String getCDAll() {
		Query query = em.createQuery("select * from cd", CD.class); 
		Collection<CD> cds = (Collection<CD>) query.getResultList();
		return jsonUtil.getObjectAsJSON(cds);
	}
	
	public String getCDByID(int id) {
		CD foundCD = findCD(id);
		return jsonUtil.getObjectAsJSON(foundCD);
		
	}
	
	public String updateCD(int id, String updatedCDJSON) {
		CD updatedCD = jsonUtil.getJSONAsObject(updatedCDJSON);
		CD foundCD = findCD(id);
		if (foundCD != null) {
			foundCD = updatedCD;
			em.merge(foundCD);
		}
		return updatedCDJSON;
		
	}
	
	public String deleteCD(int id) {
		CD foundCD = findCD(id);
		if (foundCD != null) {
			em.remove(foundCD);
		}
		return "{\"message\":\"CD successfully removed\"}";
		
	}
	
	public String createCD(String newCDJSON) {
		CD newCD = jsonUtil.getJSONAsObject(newCDJSON);
		em.persist(newCD);
		return newCDJSON;
		
	}
	
	public CD findCD(Integer id) {
		CD found = em.find(CD.class, id);
		return found;
	}

}
