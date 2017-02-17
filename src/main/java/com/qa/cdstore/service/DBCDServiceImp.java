package com.qa.cdstore.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.*;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

@Stateless
@Default
public class DBCDServiceImp implements CDService{
	@PersistenceContext(unitName = "primary")
	private EntityManager EM;
	
	@Inject
	private JSONUtil util;
	
	@Inject
	private DBWrapper dbw;
	
	@Override
	public String getAllCDs(){
		Query q = EM.createQuery(dbw.ConnectionURL());
		@SuppressWarnings("unchecked")
		Collection<CD> cds = (Collection<CD>)q.getResultList();
		return util.getJSONForObject(cds);
	}

	@Override
	public String addNewCD(String cdJSON) {
		CD newCD = util.getObjectForJSON(cdJSON, CD.class);
		EM.persist(newCD);
		return cdJSON;
	}

	@Override
	public String replaceCD(Integer Key, String cdUpdate) {
		CD newCD = util.getObjectForJSON(cdUpdate, CD.class);
		CD cd = FindCD(new Integer(Key));
		if(cd != null){
			cd = newCD;
			EM.merge(cd);
		}
		return "{\"message\": \"CD updated\"}";
	}

	@Override
	public String deleteCD(Integer Key) {
		CD cd = FindCD(new Integer(Key));
		if(cd != null) {
			EM.remove(cd);
		}
		return "{\"message\": \"book removed\"}";
	}
	
	protected CD FindCD(Integer Key){
		return EM.find(CD.class, Key);
	}
}