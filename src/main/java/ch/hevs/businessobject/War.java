package ch.hevs.businessobject;

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

import org.eclipse.persistence.jpa.jpql.parser.DateTime;

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
	private DateTime startDate;
	@Column(name="endDate")
	private DateTime endDate;
	@Column(name="description")
	private String description;
	@Column(name="countryOne")
	private Country countryOne;
	@Column(name="countryTwo")
	private Country countryTwo;
	
	// relations NOT FINISHED YET
	/*@ManyToOne(cascade = CascadeType.ALL)//@JoinColumn(name = "FK_CLIENT")
	private List<Account> accounts; */
	
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
	
	public DateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}
	
	public DateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(DateTime endDate) {
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
	public War(String name, DateTime startDate, DateTime endDate, String description, Country countryOne, Country countryTwo) {
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
