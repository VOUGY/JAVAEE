package ch.hevs.warservice;

import java.util.ArrayList;
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
	public void AddWar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteWar(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EditWar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void FinishWar() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<War> GetWars() {
		return em.createQuery("FROM War").getResultList();
	}
		

	
	
}
