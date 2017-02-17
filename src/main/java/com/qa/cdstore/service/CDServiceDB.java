package com.qa.cdstore.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.UtilJSON;

@Stateless
@Default
public class CDServiceDB implements CDService {
	
	private EntityManager em;
	
	@Inject
	private UtilJSON helper;
	
	public String getCDs() {
		List<CD> cds = new ArrayList<CD>();
		cds = em.createQuery("SELECT cd FROM CD cd").getResultList();
		if (cds != null)
			return helper.toJson(cds);
		else 
			return "";
	}
}
