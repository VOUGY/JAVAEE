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

import ch.hevs.businessobject.War;
import ch.hevs.businessobject.Weapon;

@Stateless
public class WarBean implements WarService {
	
	private List<String> weaponNames;
	private String weaponName;
	private WarService warservice;
	
	 @PostConstruct
	    public void initialize() throws NamingException {
		 
		 InitialContext ctx = new InitialContext();
		warservice = (WarService) ctx.lookup("java:global/TP-PROJECT-E-0.0.1-SNAPSHOT/BankBean!ch.hevs.warservice.WarService");  
			
		// get weapons
		List<Weapon> weaponList = warservice.GetWeapons();
		this.weaponNames = new ArrayList<String>();
		for (Weapon weapon : weaponList) {
			this.weaponNames.add(weapon.getName());
		}
		
		// get one weapon
		this.weaponName = warservice.GetWeapon(1).getName();
	    	
	    // TO DO : initialize Gun / Car classes and link them to Weapon
		 
	    }
	
	@PersistenceContext(name = "WarPU")
	private EntityManager em;
	
	
	@Resource 
	private SessionContext ctx;
	
	@Override
	public void AddWeapon(Weapon weapon) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteWeapon(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void EditWeapon(Weapon weapon) {
		//em.createQuery(qlString)		
	}

	@Override
	public List<Weapon> GetWeapons() {
		return em.createQuery("FROM Weapon").getResultList();
	}

	@Override
	public Weapon GetWeapon(long weaponId) {
		return (Weapon) em.createQuery("FROM Weapon w where w.id =:id").setParameter("id", weaponId).getSingleResult();
	}
}
