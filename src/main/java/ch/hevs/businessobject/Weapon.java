package ch.hevs.businessobject;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
=======
import javax.persistence.ManyToMany;
>>>>>>> 6c2598a46d04fc862621a79588bb3660b7484c03
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Weapon {
	
	// table attributes
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="strength")
	private int strength;
<<<<<<< HEAD
	@Column(name="quantity")
	private int quantity;
=======
	
	// relations
	
	@ManyToMany
	private List<Country> countries; 
>>>>>>> 6c2598a46d04fc862621a79588bb3660b7484c03
	
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
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	// constructor
	public Weapon() {
		// TO DO
	}
	

}
