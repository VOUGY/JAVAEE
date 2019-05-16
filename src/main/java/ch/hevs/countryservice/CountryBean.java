package ch.hevs.countryservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.hevs.businessobject.Country;
import ch.hevs.businessobject.War;

@Stateless
public class CountryBean implements CountryService {
	
	@PersistenceContext(name = "CountryPU")
	private EntityManager em;
	
	@Override
	public List<Country> GetCountries() {
		return em.createQuery("FROM Country").getResultList();
	}

}
