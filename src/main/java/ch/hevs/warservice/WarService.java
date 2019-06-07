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
	
	void AddWar(War war);
	// void DeleteWar(long id); --> A war can't be deleted, because history can't be erased
	void EditWar(War war);
	void FinishWar(War war);
	
	//Views 
	List<War> GetWars();
	War GetWar(Long id);
	War NewWar();
		
	
}
