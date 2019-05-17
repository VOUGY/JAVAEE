package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.Car;
import ch.hevs.businessobject.Country;
import ch.hevs.businessobject.Gun;
import ch.hevs.businessobject.War;
import ch.hevs.businessobject.Weapon;
import ch.hevs.countryservice.CountryService;
import ch.hevs.warservice.WarService;
import ch.hevs.weaponservice.WeaponService;
import ch.hevs.weaponservice.WeaponService;

/**
 * WarZoneBean.java
 * 
 */

public class WarZoneBean {

	private List<War> wars;
	private List<Country> countries;
	private List<Weapon> weapons;

	private String weaponName;
	private WeaponService weapon;
	private WarService war;
	private CountryService country;

	private War selectedWar;

	private Country selectedCountry;
	private List<String> countryNames;
	private String countryName;

	// Car and Gun variable (to edit or add)
	private Car tmpCar;
	private Gun tmpGun;
	private Weapon selectedWeapon;

	@PostConstruct
	public void initialize() throws NamingException {

		// use JNDI to inject reference to bank EJB
		// InitialContext ctxwar = new InitialContext();
		InitialContext ctx = new InitialContext();

		weapon = (WeaponService) ctx
				.lookup("java:global/TP-PROJECT-0.0.1-SNAPSHOT/WeaponBean!ch.hevs.weaponservice.WeaponService");
		war = (WarService) ctx.lookup("java:global/TP-PROJECT-0.0.1-SNAPSHOT/WarBean!ch.hevs.warservice.WarService");
		country = (CountryService) ctx
				.lookup("java:global/TP-PROJECT-0.0.1-SNAPSHOT/CountryBean!ch.hevs.countryservice.CountryService");

		// Get all weapons from database
		this.weapons = weapon.GetWeapons();
		tmpCar = new Car();
		tmpGun = new Gun();
		// Get all wars from database
		this.wars = war.GetWars();

		// Get all countries from database
		this.countries = country.GetCountries();
		this.countryNames = new ArrayList<String>();

		for (int i = 0; i < this.countries.size(); i++) {
			this.countryNames.add(this.countries.get(i).getName());
		}
		// ADD FUNCTION OK
		// weapon.AddCar();

		// MODIFY FUNCTION OK
		/*
		 * Car car =(Car) weaponWeapon.get(0); weaponName = car.getName();
		 * System.out.println(car.getName()); car.setName("LOL");
		 * car.setIsTwoWheeled(true); weapon.EditCar(car);
		 */
		// DELETE FUNCTION OK
		// weapon.DeleteWeapon(1);
	}

	public void UpdateData() {
		this.weapons = weapon.GetWeapons();
		this.countries = country.GetCountries();
	}

	public String openWar(Long selectedWar) {
		try {
			InitialContext ctx = new InitialContext();
			war = (WarService) ctx
					.lookup("java:global/TP-PROJECT-0.0.1-SNAPSHOT/WarBean!ch.hevs.warservice.WarService");
			this.selectedWar = war.GetWar(selectedWar);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "war?faces-redirect=true";
	}

	public String editCar(long selectedWeaponId) {
		tmpCar = weapon.GetCar(selectedWeaponId);
		return "editCar?faces-redirect=true";
	}

	public String deleteWeapon(long selectedWeaponId) {
		weapon.DeleteWeapon(selectedWeaponId);
		UpdateData();
		return "warzone?faces-redirect=true";
	}

	public String addWar() {
		return "warzone?faces-redirect=true";
	}

	public List<War> getWars() {
		return wars;
	}

	public String editCar() {
		weapon.EditCar((Car) tmpCar);
		return "warzone?faces-redirect=true";
	}

	public String addCar() {
		weapon.AddCar(tmpCar);
		UpdateData();
		return "warzone?faces-redirect=true";
	}

	public void setWars(List<War> wars) {
		this.wars = wars;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public List<Weapon> getWeapons() {
		return weapons;
	}

	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public WeaponService getWeapon() {
		return weapon;
	}

	public void setWeapon(WeaponService weapon) {
		this.weapon = weapon;
	}

	public String[][] getWarringCountries() {
		String[][] warringCountries = null;

		return warringCountries;
	}

	public Country getSelectedCountry() {
		return this.selectedCountry;
	}

	public void setSelectedCountry(Country selectedCountry) {
		this.selectedCountry = selectedCountry;
	}

	public Weapon getSelectedWeapon() {
		return this.selectedWeapon;
	}

	public void setSelectedWeapon(Weapon selectedWeapon) {
		this.selectedWeapon = selectedWeapon;
	}

	public War getSelectedWar() {
		return this.selectedWar;
	}

	public void setSelectedWar(War selectedWar) {
		this.selectedWar = selectedWar;
	}

	public Car getTmpCar() {
		return tmpCar;
	}

	public void setTmpCar(Car tmpCar) {
		this.tmpCar = tmpCar;
	}

	public Gun getTmpGun() {
		return tmpGun;
	}

	public void setTmpGun(Gun tmpGun) {
		this.tmpGun = tmpGun;
	}
	
}