package ch.hevs.weaponservice;

import java.util.List;

import javax.ejb.Local;

import ch.hevs.businessobject.Car;
import ch.hevs.businessobject.Gun;
import ch.hevs.businessobject.Weapon;

@Local
public interface WeaponService {
	
	// Add Car or Gun 
		//void AddWeapon(Weapon weapon);
	void AddCar();
	void AddCar(Car car);
	void AddGun();
	void AddGun(Gun gun);
	
	//Delete Weapon 
	int DeleteWeapon(long id);
	
	//Update Weapon
	void EditGun(Gun gun);
	void EditCar(Car car);
	
	//Views 
	List<Weapon> GetWeapons();
	Weapon GetWeapon(long id);
	Car GetCar(long carId);

}
