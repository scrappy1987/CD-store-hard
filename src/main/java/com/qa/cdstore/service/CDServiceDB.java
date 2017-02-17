package com.qa.cdstore.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.UtilJSON;

@Stateless
@Default
public class CDServiceDB implements CDService {
	
	private static final Logger LOGGER = Logger.getLogger(CDServiceDB.class);
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private UtilJSON helper;
	
	@Override
	@SuppressWarnings("unchecked")
	public String getCDs() {
		List<CD> cds = (List<CD>) em.createQuery("SELECT cd FROM CD cd").getResultList();
		LOGGER.info("In GET CDS METHOD !!!!!!!!!");
		if (cds != null)
			return helper.toJson(cds);
		else 
			return "";
	}
	
	@Override
	public String addCD(String cdJson) {
		LOGGER.info("In ADD CD METHOD!!!!!!!!!!!!!");
		em.persist(helper.fromJson(cdJson, CD.class));
		return cdJson;
	}
}
