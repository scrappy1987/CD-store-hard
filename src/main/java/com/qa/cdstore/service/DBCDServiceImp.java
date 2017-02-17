package com.qa.cdstore.service;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;


@Stateless
@Default
public class DBCDServiceImp implements CDService{
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	private static final Logger LOGGER = Logger.getLogger(DBCDServiceImp.class);
	
	@Inject
	private JSONUtil converter;

	@Override
	public String addCD(String json) {
		CD newCD = converter.convertFromJSON(json, CD.class);
		if (getCD(newCD) == null) {
			LOGGER.info("Adding new CD to map");
			em.persist(newCD);
			LOGGER.info("New CD added");
			return json;
		}
		LOGGER.info("CD already in database");
		return null;
	}

	@Override
	public String updateCD(int id, String json) {
		CD newCD = converter.convertFromJSON(json, CD.class);
		String oldCD = getCD(id);
		if (oldCD != null) {
			LOGGER.info("Updating cd");
			em.merge(newCD);
			LOGGER.info("CD updated");
			return json;
		}
		LOGGER.info("CD not found");
		return null;
	}

	@Override
	public String removeCD(int id) {
		try {
			CD removeMe = em.find(CD.class, id);
			if (removeMe == null) throw new NullPointerException();
			LOGGER.info("Removing cd");
			em.remove(removeMe);
			LOGGER.info("CD removed");
			return converter.convertToJSON(removeMe);
		}
		catch(Exception e) {
			return "CD ID="+id+" not found";
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getAllCDs() {
		Query query = em.createQuery("SELECT c FROM CD c");
		Collection<CD> cds = (Collection<CD>) query.getResultList();
		return converter.convertToJSON(cds);
	}

	@Override
	public String getCD(int id) {
		CD cdToBeReturned = em.find(CD.class, id);
		if (cdToBeReturned != null) {
			LOGGER.info("Returning CD with ID="+id);
			return converter.convertToJSON(cdToBeReturned);
		}
		LOGGER.info("CD not found");
		return null;
	}
	
	private String getCD(CD cd) {
		return getCD(cd.getId());
	}

}
