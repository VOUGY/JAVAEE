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
	private int wheels = 4;
	
	
	public int getWheels() {
		return wheels;
	}
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
		// constructor
		public Car() {
			
		}
		public Car(String name, String description, int strength, int quantity, int wheels)
		{
			super(name,description,strength,quantity);
			this.wheels = wheels;
		}
		
			
		
}
