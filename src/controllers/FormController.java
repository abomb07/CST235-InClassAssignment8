package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.MyTimerService;
import business.OrderBusinessInterface;


@ManagedBean
@ViewScoped
public class FormController {
	
	@Inject
	OrderBusinessInterface service;
	
	@EJB
	MyTimerService timer;
	
	public String onSubmit(User user) 
	{
		service.test();
		
		//set timer to 10s
		timer.setTimer(10000);
		
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		return "TestResponse.xhtml";
	}
	
	public OrderBusinessInterface getService()
	{
		return service;
	}

}
