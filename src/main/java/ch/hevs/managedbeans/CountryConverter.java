package ch.hevs.managedbeans;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;

import ch.hevs.businessobject.Country;
import ch.hevs.countryservice.CountryService;

@FacesConverter(value = "countryConverter")
public class CountryConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String countryId) {

    	CountryService country = (CountryService) ctx.getApplication().getExpressionFactory()
    			.createValueExpression(ctx.getELContext(), "#{CountryService}", CountryService.class);
    	
    	return country.GetCountry(Long.parseLong(countryId));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object country) {

    	return ((Country)country).getId().toString();
    }

}
