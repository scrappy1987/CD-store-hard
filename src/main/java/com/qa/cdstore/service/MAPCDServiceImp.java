package com.qa.cdstore.service;
import java.util.HashMap;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

@ApplicationScoped
@Alternative
public class MAPCDServiceImp implements CDService {
	final int COUNT = 1;
	private HashMap<Integer, CD> cdMap;
	private int ID;
	
	@Inject
	private JSONUtil util;
		
	public MAPCDServiceImp(){
		this.cdMap = new HashMap<Integer, CD>();
		ID = COUNT;
		init();
	}
	
	private void init(){
		CD placebo = new CD("Placebo", "Pure Morning", "Rock");
		CD fooFighters = new CD("Foo Fighters", "Monkey Wrench", "Rock");
		cdMap.put(ID, placebo);
		cdMap.put(++ID, fooFighters);
	}

	@Override
	public String getAllCDs() {
		return util.convertToJSON(cdMap.values());
	}

	@Override
	public String getSingleCD(Integer id) {
		return util.convertToJSON(cdMap.get(id));
	}

	@Override
	public String addnewCD(String cd) {
		ID++;
		CD newCD = util.convertToObject(cd, CD.class);
		cdMap.put(ID, newCD);
		return cd;
	}

	@Override
	public String updateCD(Integer id, String cd) {
		CD newCD = util.convertToObject(cd, CD.class);
		cdMap.put(id, newCD);
		return cd;
	}

	@Override
	public String deleteCD(Integer id) {
		cdMap.remove(id);
		return "{\"message\": \"book sucessfully removed\"}";
	}
}
