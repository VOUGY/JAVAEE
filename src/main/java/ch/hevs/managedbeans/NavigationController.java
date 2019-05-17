package ch.hevs.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
public class NavigationController implements Serializable {
   //this managed property will read value from request parameter pageId
   @ManagedProperty(value = "#{param.pageId}")
   private String pageId;

   //condional navigation based on pageId
   //if pageId is 1 show page1.xhtml,
   //if pageId is 2 show page2.xhtml
   //else show home.xhtml
   
   public String showPage() {
      switch(pageId)
      {
      	case "warzone":
      		return "warzone?faces-redirect=true";
      		
      	case "war":
      		return "war?faces-redirect=true";
      		
      	case "weapons":
      		return "weapons?faces-redirect=true";
      		
      	case "countries":
      		return "countries?faces-redirect=true";
      		
      	case "addCountry":
      		return "addCountry?faces-redirect=true";
      		
      	case "addWar":
      		return "addWar?faces-redirect=true";
      		
      	case "addWeapon":
      		return "addWeapon?faces-redirect=true";
      	case "addCar" :
      		return "addCar?faces-redirect=true";
      }
      
      return "home";
   }

	public String getPageId() {
		return pageId;
	}
	
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
   
}