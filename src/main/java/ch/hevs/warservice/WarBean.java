package ch.hevs.warservice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ch.hevs.businessobject.Car;
import ch.hevs.businessobject.Gun;
import ch.hevs.businessobject.War;
import ch.hevs.businessobject.Weapon;

@Stateless
public class WarBean implements WarService {


	@PersistenceContext(name = "WarPU")
	private EntityManager em;

	@Override
	public void EditWar(War war) {
		em.merge(war);
		
	}
	
	@Override
	public void AddWar(War war) {
		em.persist(war);
	}

	@Override
	public void FinishWar(War war) {
	    Date today = new Date();
	    war.setEndDate(today);
	    em.merge(war);
		
	}
	
	@Override
	public List<War> GetWars() {
		return em.createQuery("FROM War").getResultList();
	}
	
	@Override
	public War GetWar(Long id) {
		return (War) em.createQuery("FROM War WHERE id = " + id).getSingleResult();
	}
		

	
	
}
