package ch.hevs.businessobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
public class Gun extends Weapon {
	
	// table attributes
	private Boolean isAutomatic;
	
	// get & set	
	public Boolean getIsAutomatic() {
		return isAutomatic;
	}

	public void setIsAutomatic(Boolean isAutomatic) {
		this.isAutomatic = isAutomatic;
	}
	// constructor
		public Gun() {
			
		}
		public Gun(Boolean isAutomatic)
		{
			// TO DO
		}

}
