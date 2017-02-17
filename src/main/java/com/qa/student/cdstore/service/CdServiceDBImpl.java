package com.qa.student.cdstore.service;

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
public class CdServiceDBImpl  implements CdService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil jutil;
	
	@SuppressWarnings("unchecked")
	@Override
	public String getAllCDs(){ 
		Query query = em.createQuery("SELECT e FROM CD e");
		Collection<CD> cds = (Collection<CD>) query.getResultList();
		return jutil.getJSONForObject(cds);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String getCD(Integer cdID){ 
		Query query = em.createQuery("SELECT e FROM CD e");
		Collection<CD> cds = (Collection<CD>) query.getResultList();
		String cdstring = "not found";
		for(CD cd : cds)
		{
			if(cd.getId().equals(new Long(cdID)))
			{
				cdstring = jutil.getJSONForObject(cd);
			}
		}
		return cdstring;
	}
	
	@Override
	public String addNewCDs(String cdJson) {
		CD newCD = jutil.getObjectForJSON(cdJson, CD.class);
		em.persist(newCD);
		return cdJson;
	}

	@Override
	public String replaceCD(Integer cdId, String updatedCd) {
		CD updateCD = jutil.getObjectForJSON(updatedCd, CD.class);
		CD cd = findCd(new Long(cdId));
		Long ll;
		if (cd != null) {
			ll = cd.getId();
			cd = updateCD;
			cd.setId(ll);
			em.merge(cd);
		}
		return "{\"message\": \"cd sucessfully updated\"}";
	}

	@Override
	public String deleteCD(Integer cdId) {
		CD cd = findCd(new Long(cdId));
		if (cd != null) {
			em.remove(cd);
		}
		return "{\"message\": \"cd sucessfully removed\"}";
	}

	private CD findCd(Long id) {
		return em.find(CD.class, id);
	}
	
	
	
}
