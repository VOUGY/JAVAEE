package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

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

	private String tmpCountryOneName;
	private String tmpCountryTwoName;

	// Car and Gun variable (to edit or add)
	private Car tmpCar;
	private Gun tmpGun;
	private Weapon selectedWeapon;

	// War variable (to edit or add)
	private War tmpWar;

	// Country variable (to add)
	private Country tmpCountry;

	
	@PostConstruct
	public void initialize() throws NamingException {

		// use JNDI to inject reference to bank EJB
		InitialContext ctx = new InitialContext();

		weapon = (WeaponService) ctx
				.lookup("java:global/TP-PROJECT-0.0.1-SNAPSHOT/WeaponBean!ch.hevs.weaponservice.WeaponService");
		war = (WarService) ctx.lookup("java:global/TP-PROJECT-0.0.1-SNAPSHOT/WarBean!ch.hevs.warservice.WarService");
		country = (CountryService) ctx
				.lookup("java:global/TP-PROJECT-0.0.1-SNAPSHOT/CountryBean!ch.hevs.countryservice.CountryService");

		// Get all weapons from database
		this.weapons = weapon.GetWeapons();
		tmpCar = weapon.NewCar();

		// Get all wars from database
		this.wars = war.GetWars();
		tmpWar = new War();

		// Get all countries from database
		this.countries = country.GetCountries();
		this.countryNames = new ArrayList<String>();

		for (int i = 0; i < this.countries.size(); i++) {
			this.countryNames.add(this.countries.get(i).getName());
		}
		
		
		InitializeWar();
		UpdateData();
	}

	public void UpdateData() {
		this.weapons = weapon.GetWeapons();
		this.countries = country.GetCountries();
		this.wars = war.GetWars();
	}

	public void InitializeWar() {
		weapon.AddCars();
		weapon.AddGuns();
		country.AddCountriesWithWeapons();
	}

	public String openWar(Long selectedWar) {
		try {
			InitialContext ctx = new InitialContext();
			war = (WarService) ctx
					.lookup("java:global/TP-PROJECT-0.0.1-SNAPSHOT/WarBean!ch.hevs.warservice.WarService");
			tmpWar = war.GetWar(selectedWar);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "war?faces-redirect=true";
	}

	public String finishWar() {

		war.FinishWar(tmpWar);
		UpdateData();
		return "war?faces-redirect=true";

	}
	public String addWar() {
		tmpWar.setCountryOne(country.GetCountryWithName(tmpCountryOneName));
		tmpWar.setCountryTwo(country.GetCountryWithName(tmpCountryTwoName));
		war.AddWar(tmpWar);
		UpdateData();
		tmpWar = new War();
		return "warzone?faces-redirect=true";
	}
	
	
	public String editCar(long selectedWeaponId) {
		tmpCar = weapon.GetCar(selectedWeaponId);
		return "editCar?faces-redirect=true";
	}

	public String editCar() {
		weapon.EditCar(tmpCar);
		tmpCar = weapon.NewCar();
		UpdateData();
		return "weapons?faces-redirect=true";
	}

	public String addCar() {
		weapon.AddCar(tmpCar);
		tmpCar = weapon.NewCar();
		UpdateData();
		return "weapons?faces-redirect=true";

	}

	public String deleteWeapon(long selectedWeaponId) {
		weapon.DeleteWeapon(selectedWeaponId);
		UpdateData();
		return "weapons?faces-redirect=true";
	}



	public Country getCountryWithName(String countryName) {
		return country.GetCountryWithName(countryName);
	}

	public List<War> getWars() {
		return wars;
	}

	public String editWar() {
		war.EditWar(tmpWar);
		tmpWar = new War();
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

	public War getTmpWar() {
		return tmpWar;
	}

	public void setTmpWar(War tmpWar) {
		this.tmpWar = tmpWar;
	}

	public Country getTmpCountry() {
		return tmpCountry;
	}

	public void setTmpCountry(Country tmpCountry) {
		this.tmpCountry = tmpCountry;
	}

	public WarService getWar() {
		return war;
	}

	public void setWar(WarService war) {
		this.war = war;
	}

	public CountryService getCountry() {
		return country;
	}

	public void setCountry(CountryService country) {
		this.country = country;
	}

	public List<String> getCountryNames() {
		return countryNames;
	}

	public void setCountryNames(List<String> countryNames) {
		this.countryNames = countryNames;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getTmpCountryOneName() {
		return tmpCountryOneName;
	}

	public void setTmpCountryOneName(String tmpCountryOneName) {
		this.tmpCountryOneName = tmpCountryOneName;
	}

	public String getTmpCountryTwoName() {
		return tmpCountryTwoName;
	}

	public void setTmpCountryTwoName(String tmpCountryTwoName) {
		this.tmpCountryTwoName = tmpCountryTwoName;
	}

}