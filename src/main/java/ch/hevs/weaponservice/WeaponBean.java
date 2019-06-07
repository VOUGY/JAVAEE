package ch.hevs.weaponservice;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ch.hevs.businessobject.Car;
import ch.hevs.businessobject.Country;
import ch.hevs.businessobject.Gun;
import ch.hevs.businessobject.War;
import ch.hevs.businessobject.Weapon;

@Stateless
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)

public class WeaponBean implements WeaponService {
	
	@PersistenceContext(name = "WarPU")
	private EntityManager em;


	
	public int DeleteWeapon(long weaponId) {
		int delete = em.createQuery("DELETE FROM Weapon w where w.id = :id").setParameter("id", weaponId)
				.executeUpdate();
		return delete;
	}

	@Override
	public void EditCar(Car car) {
		em.merge(car);
	}
	
	@Override
	public void EditGun(Gun gun) {
		em.merge(gun);
		
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
	public Car GetCar(long carId) {
		//return (Car) em.createQuery("SELECT c FROM Car c where c.id =:id", Car.class).setParameter("id", carId).getSingleResult();
//		return (Car) em.createQuery("FROM Car c where c.id =:id")
		return (Car) em.createQuery("FROM Car WHERE id = " + carId).getSingleResult();
	}


	@Override
	public void AddCar(Car car) {
		em.persist(car);
	}

	public void AddCars() {

		Car cartmp = new Car();
		cartmp.setDescription("Best of the best of the best tanks");
		cartmp.setWheels(0);
		cartmp.setName("Tank");
		cartmp.setQuantity(100);
		cartmp.setStrength(10000000);
		em.persist(cartmp);
		
		cartmp = new Car();
		cartmp.setDescription("Transport");
		cartmp.setWheels(8);
		cartmp.setName("Puch");
		cartmp.setQuantity(1000);
		cartmp.setStrength(1);
		
		cartmp = new Car();
		cartmp.setDescription("Transport");
		cartmp.setWheels(2);
		cartmp.setName("Moto");
		cartmp.setQuantity(1000);
		cartmp.setStrength(1);
		
		cartmp = new Car();
		cartmp.setDescription("Transport");
		cartmp.setWheels(2);
		cartmp.setName("Bike");
		cartmp.setQuantity(100);
		cartmp.setStrength(0);
	}

	@Override
	public void AddGun(Gun gun) {
		em.persist(gun);
	}

	public void AddGuns() {
		Gun guntmp = new Gun();
		guntmp.setDescription("New gun");
		guntmp.setIsAutomatic(true);
		guntmp.setName("Ak47");
		guntmp.setQuantity(1000);
		guntmp.setStrength(4);
		em.persist(guntmp);
		
		guntmp.setDescription("45mm / 32 ");
		guntmp.setIsAutomatic(false);
		guntmp.setName("Revolver");
		guntmp.setQuantity(4000);
		guntmp.setStrength(1);
		em.persist(guntmp);
		
		guntmp = new Gun();
		guntmp.setDescription("Sniper");
		guntmp.setIsAutomatic(false);
		guntmp.setName("S112-sp03");
		guntmp.setQuantity(1000	);
		guntmp.setStrength(100);
		em.persist(guntmp);
		
		guntmp = new Gun();
		guntmp.setDescription("Boum");
		guntmp.setIsAutomatic(false);
		guntmp.setName("Grenades");
		guntmp.setQuantity(100000);
		guntmp.setStrength(10);
		em.persist(guntmp);
		
		guntmp = new Gun();
		guntmp.setDescription("Shhhh");
		guntmp.setIsAutomatic(true);
		guntmp.setName("Mines");
		guntmp.setQuantity(10000);
		guntmp.setStrength(1000);
		em.persist(guntmp);
	}

	@Override
	public Car NewCar() {
		// TODO Auto-generated method stub
		return new Car();
	}
	
}
