package com.qa.cdstore.service;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;


@ApplicationScoped
@Alternative
public class MAPCDServiceImp implements CDService{
	
	private Map<Integer, CD> cdMap;
	private static final Logger LOGGER = Logger.getLogger(MAPCDServiceImp.class);
	
	@Inject
	private JSONUtil converter;
	
	
	public MAPCDServiceImp () {
		cdMap = new HashMap<Integer, CD>();
	}

	@Override
	public String addCD(String json) {
		CD newCD = converter.convertFromJSON(json, CD.class);
		if (getCD(newCD) == null) {
			LOGGER.info("Adding new CD to map");
			cdMap.put(newCD.getId(), newCD);
			LOGGER.info("New CD added");
			return json;
		}
		LOGGER.info("CD already in map");
		return null;
	}

	@Override
	public String updateCD(int id, String json) {
		CD newCD = converter.convertFromJSON(json, CD.class);
		String oldCD = getCD(id);
		if (oldCD != null) {
			LOGGER.info("Updating cd");
			cdMap.put(id, newCD);
			LOGGER.info("CD updated");
			return json;
		}
		LOGGER.info("CD not found");
		return null;
	}

	@Override
	public String removeCD(int id) {
		String cdToBeRemoved = getCD(id);
		if (cdToBeRemoved != null) {
			LOGGER.info("Removing cd");
			cdMap.remove(id);
			LOGGER.info("CD removed");
			return "CD successfully removed";
		}
		LOGGER.info("CD not found");
		return null;
	}

	@Override
	public String getAllCDs() {
		return converter.convertToJSON(cdMap.values());
	}

	@Override
	public String getCD(int id) {
		if (cdMap.containsKey(id)) return converter.convertToJSON(cdMap.get(id));
		else {
			LOGGER.info("CD not found");
			return null;
		}
	}
	
	private String getCD(CD cd) {
		return getCD(cd.getId());
	}
	
}
