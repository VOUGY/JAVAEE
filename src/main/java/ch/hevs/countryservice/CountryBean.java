package ch.hevs.countryservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.hevs.businessobject.Car;
import ch.hevs.businessobject.Country;
import ch.hevs.businessobject.War;
import ch.hevs.businessobject.Weapon;
import ch.hevs.weaponservice.WeaponService;

@Stateless
public class CountryBean implements CountryService {
	
	@EJB
	private WeaponService weapon;
	
	@PersistenceContext(name = "CountryPU")
	private EntityManager em;
	
	@Override
	public List<Country> GetCountries() {
		return em.createQuery("FROM Country").getResultList();
	}
	
	@Override
	public Country GetCountry(Long id) {
		return (Country) em.createQuery("From Country WHERE id = " + id).getSingleResult();
	}
	
	@Override
	public Country GetCountryWithName(String countryName) {
		return (Country) em.createQuery("From Country Where name = '" + countryName + "'").getSingleResult();
	}

	public void AddCountries() {

		Country country = new Country();
		country.setName("France");
		country.setAbbreviation("FR");
		country.setLocation("Europe");
		country.setDescription("Liberté, égalité, fraternité");
		Country country2 = new Country();
		country2.setName("Germany");
		country2.setAbbreviation("DE");
		country2.setLocation("Europe");
		country2.setDescription("Einigkeit und Recht und Freiheit");
		
		
		Country country3 = new Country();
		country3.setName("United Kingdom");
		country3.setAbbreviation("UK");
		country3.setLocation("Europe");
		country3.setDescription("Dieu et mon droit");
		
		Country country4 = new Country();
		country4.setName("United States");
		country4.setAbbreviation("US");
		country4.setLocation("North America");
		country4.setDescription("In God We Trust");
		
		Country country5 = new Country();
		country5.setName("Japon");
		country5.setAbbreviation("JA");
		country5.setLocation("Asia");
		
		
		em.merge(country);
		em.merge(country2);
		em.merge(country3);
		em.merge(country4);
		em.merge(country5);
		
	}
	public void AddWeaponCountry(Country country, Weapon weapon)
	{
		country.addWeapon(weapon);
		em.merge(country);
	}
	
	@Override
	public void AddCountry(Country country) {
		em.persist(country);
	}

	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public void AddCountriesWithWeapons() {
		AddCountries();
		AddWeaponCountry(GetCountries().get(0), weapon.GetWeapons().get(0));
	    AddWeaponCountry(GetCountries().get(0), weapon.GetWeapons().get(1));
		AddWeaponCountry(GetCountries().get(1), weapon.GetWeapons().get(2));
		AddWeaponCountry(GetCountries().get(1), weapon.GetWeapons().get(3));
	}
	
	@Override
	public Country NewCountry() {
		// TODO Auto-generated method stub
		return new Country();
	}
}
