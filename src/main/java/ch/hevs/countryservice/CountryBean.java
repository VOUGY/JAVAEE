package ch.hevs.countryservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.hevs.businessobject.Car;
import ch.hevs.businessobject.Country;
import ch.hevs.businessobject.War;
import ch.hevs.businessobject.Weapon;

@Stateless
public class CountryBean implements CountryService {
	
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
		
		
		em.persist(country);
		em.persist(country2);
		em.persist(country3);
		em.persist(country4);
		em.persist(country5);
		
	}
	public void AddWeaponCountry(Country country, Weapon weapon)
	{
		country.getWeapons().add(weapon);
		em.merge(country);
	}

}
