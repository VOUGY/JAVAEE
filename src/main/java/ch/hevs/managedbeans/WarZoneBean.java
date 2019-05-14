package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.Car;
import ch.hevs.businessobject.War;
import ch.hevs.businessobject.Weapon;
import ch.hevs.warservice.WarService;
import ch.hevs.weaponservice.WeaponService;
import ch.hevs.weaponservice.WeaponService;

/**
 * WarZoneBean.java
 * 
 */

public class WarZoneBean
{
  //  private List<Client> clients;
  
  // private War war;
    
    private List<String> weaponNames;


	private String weaponName;
    private WeaponService weapon;
    private WarService war;
    
    @PostConstruct
    public void initialize() throws NamingException {
    	
    	// use JNDI to inject reference to bank EJB
    	//InitialContext ctxwar = new InitialContext();
    	InitialContext ctx = new InitialContext();
		
		weapon = (WeaponService) ctx.lookup("java:global/TP-PROJECT-0.0.1-SNAPSHOT/WeaponBean!ch.hevs.weaponservice.WeaponService");
	//	war = (WarService) ctx.lookup("java:global/TP-PROJECT-0.0.1-SNAPSHOT/WarBean!ch.hevs.warservice.WarService");
		
		List<Weapon> weaponWeapon = weapon.GetWeapons();
    	this.weaponNames = new ArrayList<String>();
		for (Weapon weapon : weaponWeapon) {
			this.weaponNames.add(weapon.getName());
		}
		
		
		// ADD FUNCTION OK
		// weapon.AddCar();
	
		// MODIFY FUNCTION OK  
	/*	Car car =(Car) weaponWeapon.get(0);
		weaponName = car.getName();
		System.out.println(car.getName());
		car.setName("LOL");
		car.setIsTwoWheeled(true);
		weapon.EditCar(car);
		*/
		// DELETE FUNCTION OK 
		//weapon.DeleteWeapon(1);
    }
    
    
    
    
    public List<String> getWeaponNames() {
		return weaponNames;
	}

	public void setWeaponNames(List<String> weaponNames) {
		this.weaponNames = weaponNames;
	}
	
    public String getWeaponName() {
		return weaponName;
	}
	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public WeaponService getWeapon() {
		return weapon;
	}

	public void setWeapon(WeaponService weapon) {
		this.weapon = weapon;
	}
}