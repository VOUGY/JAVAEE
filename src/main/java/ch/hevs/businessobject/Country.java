package ch.hevs.businessobject;

import javax.persistence.Entity;
import javax.persistence.PostPersist;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;


@Entity
@Table(name="Country")
public class Country {

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
	@ManyToOne
	@JoinColumn(name = "FK_CLIENT")
	private Client owner;

	// id 
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
	
	@PostPersist
	public void acknowledgePersist() {
		System.out.println("account persisted!!!");
	}
}