package com.qa.cdstore.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

@Stateless
@Alternative
public class DBCDServiceImp implements CDService {

	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	public DBCDServiceImp() {
	}

	@Override
	public String getAllCDs() {
		Query query = em.createQuery("SELECT c FROM CD c");
		List<CD> listOfCDs = query.getResultList();
		return util.getJSONForObject(listOfCDs);
	}

	@Override
	public String addNewCD(String cdJson) {
		CD newCD = util.getObjectForJSON(cdJson, CD.class);
		em.persist(newCD);
		return cdJson;
	}

	@Override
	public String replaceCD(Integer cdId, String updatedCD) {
		return null;
	}

	@Override
	public String deleteCD(Integer cdId) {
		return null;
	}
}