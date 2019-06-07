package ch.hevs.countryservice;

import java.util.List;

import javax.ejb.Local;

import ch.hevs.businessobject.Country;
import ch.hevs.businessobject.War;
import ch.hevs.businessobject.Weapon;

@Local
public interface CountryService {
	
	//Views 
	List<Country> GetCountries();
	
	Country GetCountry(Long id);
	Country GetCountryWithName(String countryName);
	void AddWeaponCountry(Country country, Weapon weapon);
	void AddCountries();
}
