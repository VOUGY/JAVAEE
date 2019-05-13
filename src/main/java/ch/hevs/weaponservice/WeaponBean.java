package ch.hevs.weaponservice;

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

import ch.hevs.businessobject.Car;
import ch.hevs.businessobject.Gun;
import ch.hevs.businessobject.War;
import ch.hevs.businessobject.Weapon;

@Stateless
public class WeaponBean implements WeaponService {

	
	@PersistenceContext(name = "WarPU")
	private EntityManager em;


	@Override
	public int DeleteWeapon(long weaponId) {
		int delete = em.createQuery("DELETE FROM Weapon w where w.id = :id").setParameter("id", weaponId)
				.executeUpdate();
		return delete;
	}

	@Override
	public void EditCar(Car car) {
		Query query = em.createQuery("UPDATE Car SET description  = :des, name =  :name, quantity");
		int updateCount = query.executeUpdate();
	}
	
	@Override
	public void EditGun(Gun gun) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Weapon> GetWeapons() {
		return em.createQuery("FROM Weapon").getResultList();
	}

	@Override
	public Weapon GetWeapon(long weaponId) {
		return (Weapon) em.createQuery("FROM Weapon w where w.id =:id").setParameter("id", weaponId).getSingleResult();
	}

	@Override
	public void AddCar(Car car) {
		em.persist(car);
	}

	public void AddCar() {

		Car cartmp = new Car();
		cartmp.setDescription("New car");
		cartmp.setIsTwoWheeled(false);
		cartmp.setName("CarName");
		cartmp.setQuantity(10);
		cartmp.setStrength(10);
		em.persist(cartmp);
	}

	@Override
	public void AddGun(Gun gun) {
		em.persist(gun);
	}

	public void AddGun() {
		Gun guntmp = new Gun();
		guntmp.setDescription("New gun");
		guntmp.setIsAutomatic(true);
		guntmp.setName("CarName");
		guntmp.setQuantity(1000);
		guntmp.setStrength(4);
		em.persist(guntmp);
	}

	
}
