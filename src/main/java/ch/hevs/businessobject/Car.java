package ch.hevs.businessobject;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
public class Car extends Weapon {
	
	// table attributes
	private Boolean isTwoWheeled;
	
	// get & set	
	public Boolean getIsTwoWheeled() {
		return isTwoWheeled;
	}

	public void setIsTwoWheeled(Boolean isAutomatic) {
		this.isTwoWheeled = isTwoWheeled;
	}
	// constructor
		public Car() {
			
		}
		public Car(String name, String description, int strength, int quantity, Boolean isAutomatic)
		{
			super(name,description,strength,quantity);
			this.isTwoWheeled = isTwoWheeled;
		}
		
			
		
}
