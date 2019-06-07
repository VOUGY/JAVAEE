package ch.hevs.businessobject;

import javax.persistence.Entity;
import javax.persistence.PostPersist;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.List;

import javax.persistence.Column;


@Entity
@Table(name="Country")
public class Country {

	// table attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="abbreviation")
	private String abbreviation;	
	@Column(name="description")
	private String description;	
	@Column(name="location")
	private String location;
	
	// relations
	@ManyToMany (mappedBy="countries")
	private List<Weapon> weapons;
	
	@OneToMany(mappedBy="countryOne")
	private List<War> wars;
	
	// get & set
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	// description
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Weapon> getWeapons() {
		return weapons;
	}
	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}
	public List<War> getWars() {
		return wars;
	}
	public void setWars(List<War> wars) {
		this.wars = wars;
	}

	//methods

	// constructors
	
	
	public Country (String name, String abbreviation, String location, String description) {
		this.name = name;
		this.abbreviation = abbreviation;
		this.location = location;
		this.description = description;
	}
	public Country()
	{
		
	}
	
	
	// helper methods
	public void addWeapon(Weapon w1) {
		this.weapons.add(w1);
		List<Country> countries =w1.getCountries();
		countries.add(this);
		w1.setCountries(countries);
	}
	
	@PostPersist
	public void acknowledgePersist() {
		System.out.println("country persisted!!!");
	}
}