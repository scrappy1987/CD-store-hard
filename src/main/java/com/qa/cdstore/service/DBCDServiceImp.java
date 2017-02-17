package com.qa.cdstore.service;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Produces;
import com.qa.cdstore.model.CD;
import com.qa.cdstore.util.JSONUtil;

@Stateless
@Default
public class DBCDServiceImp implements CDService {
	
	@Inject
	private JSONUtil util;
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Produces
	public EntityManager getEntityManager(){
		return em;
	}
		
	@Override
	public String getAllCDs() {
		Query query = em.createQuery("SELECT c FROM CD c");
		Collection<CD> result = (Collection<CD>) query.getResultList();
		return util.convertToJSON(result);
	}

	@Override
	public String getSingleCD(Integer id) {
		Query query = em.createQuery("SELECT c FROM CD c WHERE ID =" + id );
		Collection<CD> result = (Collection<CD>) query.getResultList();
		return util.convertToJSON(result);
	}

	@Override
	public String addnewCD(String cd) {
		CD newCD = util.convertToObject(cd, CD.class);	
		em.persist(newCD);
		return cd;
	}

	@Override
	public String updateCD(Integer id, String cd) {	
		CD updatedCD = util.convertToObject(cd, CD.class);
		CD newCD = findCD(id);
		int currentID;
		if(cd != null){
			currentID = newCD.getId();
			newCD = updatedCD;
			newCD.setId(currentID);
			em.merge(cd);
		}
		return "{\"message\": \"cd updated\"}";		
	}

	@Override
	public String deleteCD(Integer id) {		
		CD newCD = em.find(CD.class, id);		
		
		em.remove(newCD);		
		return "{\"message\": \"cd removed\"}";
	}
	
	private CD findCD(int id) {
		return em.find(CD.class, id);
	}
}
