package ch.hevs.warservice;

import java.util.List;

import javax.ejb.Local;

import ch.hevs.businessobject.Car;
import ch.hevs.businessobject.Gun;
import ch.hevs.businessobject.War;
import ch.hevs.businessobject.Weapon;

@Local
public interface WarService {
	
	// To do => Nicolas Solioz
	
	void AddWar();
	void DeleteWar(long id);
	void EditWar();
	void FinishWar();
	
	//Views 
	List<War> GetWars();
	War GetWar(Long id);
		
	// To do => GV and NS	
	
	/*
	 * void EditCountry();
	 * void AddCountry();
	 */
	
}
