package com.qa.cdstore.service;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

@ApplicationScoped
@Default
public class MAPCDServiceImp implements CDService {

	private final int INITIAL_COUNT = 1;
	private Map<Integer, CD> cdMap;
	private int ID;

	public MAPCDServiceImp() {
		this.cdMap = new HashMap<Integer, CD>();
		ID = INITIAL_COUNT;
		initCDStore();
	}

	@Inject
	private JSONUtil util;

	@Override
	public String getAllCDs() {
		return util.getJSONForObject(cdMap.values());
	}

	@Override
	public String addNewCD(String cdJson) {
		ID++;
		CD newCD = util.getObjectForJSON(cdJson, CD.class);
		cdMap.put(ID, newCD);
		return cdJson;
	}

	@Override
	public String replaceCD(Integer cdId, String updatedCD) {
		CD newCD = util.getObjectForJSON(updatedCD, CD.class);
		cdMap.put(cdId, newCD);
		return updatedCD;
	}

	@Override
	public String deleteCD(Integer cdId) {
		cdMap.remove(cdId);
		return "{\"message\": \"CD sucessfully removed\"}";
	}

	private void initCDStore() {
		Map<Integer, String> songs1 = new HashMap<Integer, String>();
		songs1.put(1, "Pure Morning");

		Map<Integer, String> songs2 = new HashMap<Integer, String>();
		songs2.put(1, "Monkey Wrench");

		CD addCD1 = new CD(1, "Placebo", songs1, "Rock");
		CD addCD2 = new CD(2, "Foo Fighters", songs2, "Rock");

		this.cdMap.put(1, addCD1);
		this.cdMap.put(2, addCD2);
	}
}
