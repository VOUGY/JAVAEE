package ch.hevs.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import ch.hevs.managedbeans.WarZoneBean;

@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
public class NavigationController implements Serializable {
   //this managed property will read value from request parameter pageId
   //condional navigation based on pageId
   //if pageId is 1 show page1.xhtml,
   //if pageId is 2 show page2.xhtml
   //else show home.xhtml
	
   public String WarZone(){
		return "warzone?faces-redirect=true";
   }
   
   public String War(){
		return "war?faces-redirect=true";
   }
   
   public String Weapons(){
		return "weapons?faces-redirect=true";
   }
   
   public String Countries(){
		return "countries?faces-redirect=true";
   }
   
   public String AddCountry(){
		return "addCountry?faces-redirect=true";
   }
   
   public String AddWar(){
		return "addWar?faces-redirect=true";
	}
   
   public String AddCar(){
		return "addCar?faces-redirect=true";
   }
   
   public String AddWeapon(){
		return "addWeapon?faces-redirect=true";
   }
   
}