package ch.hevs.businessobject;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostPersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="War")
public class War {
	
	// table attributes
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="startDate")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Column(name="endDate")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Column(name="description")
	private String description;
	
	// relations
	
	@ManyToOne
	private Country countryOne;
	
	@ManyToOne
	private Country countryTwo;

			
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
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Country getCountryOne() {
		return countryOne;
	}
	public void setCountryOne(Country countryOne) {
		this.countryOne = countryOne;
	}
	
	public Country getCountryTwo() {
		return countryTwo;
	}
	public void setCountryTwo(Country countryTwo) {
		this.countryTwo = countryTwo;
	}
	
	// methods
	
	// constructors
	public War(String name, Date startDate, Date endDate, String description, Country countryOne, Country countryTwo) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.countryOne = countryOne;
		this.countryTwo = countryTwo;
	}
	
	public War() {
		
	}
	
	@PostPersist
	public void acknowledgePersist() {
		System.out.println("war persisted!!!");
	}

}
