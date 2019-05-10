package ch.hevs.warservice;

import java.util.List;

import javax.ejb.Local;

import ch.hevs.businessobject.Car;
import ch.hevs.businessobject.Gun;
import ch.hevs.businessobject.Weapon;

@Local
public interface WarService {
	
	// To do => Nicolas Solioz
	/*
	void AddWar();
	void DeleteWar(long id);
	void EditWar();
	void FinishWar();
	*/
	
	// To do => Guillaume Vouilloz
	
	// Add Car or Gun 
		//void AddWeapon(Weapon weapon);
	void AddCar(Car car);
	void AddGun(Gun gun);
	
	//Delete Weapon 
	void DeleteWeapon(long id);
	
	//Update Weapon
	void EditWeapon(Weapon weapon);
	
	//Views 
	List<Weapon> GetWeapons();
	Weapon GetWeapon(long id);
	
	
	// To do => GV and NS	
	
	/*
	 * void EditCountry();
	 * void AddCountry();
	 */
	
}
