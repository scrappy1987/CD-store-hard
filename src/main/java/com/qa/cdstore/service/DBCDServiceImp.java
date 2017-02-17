package com.qa.cdstore.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.*;

@Stateless
@Default
public class DBCDServiceImp implements CDService{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	private JSONUtil js = new JSONUtil();
	
	public String getCDs(){
		@SuppressWarnings("unchecked")
		final List<CD> listOfCDs = em.createQuery("select c from CD c").getResultList();
		String convertCDtoJSON = js.getJSONForObject(listOfCDs); 
		return convertCDtoJSON;
	}
	
	
	public String getSingleCD(Integer id){
		CD singleCD = em.find(CD.class, id);
		String convertCDtoJSON = js.getJSONForObject(singleCD); 
		return convertCDtoJSON;
	}
	
	
	public String replaceCD(Integer id, String cdToUpdate){
		CD newCD = js.getObjectForJSON(cdToUpdate, CD.class);
		CD CD = findCD(new Integer(id));
		if(CD != null){
			CD = newCD;
			em.merge(CD);
		}
		return "{\"yesfam its updated\"}";
	}
	
	
	public String addCD(String cdJSON){
		CD newCD = js.getObjectForJSON(cdJSON, CD.class);
		em.persist(newCD);
		return cdJSON;
	}
	
	 public String deleteCD(Integer id){
		 CD cdToDelete = findCD(id);
		 if(cdToDelete != null){
			 em.remove(cdToDelete);
		 }
		 return "(\"yesfam its deleted\"}";
	}
	 
	 private CD findCD(int id){
		 return em.find(CD.class, id);
	 }



	}
	

