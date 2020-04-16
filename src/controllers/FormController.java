package controllers;

import java.text.DecimalFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.Order;
import beans.User;
import business.OrderBusinessInterface;

@ManagedBean
@ViewScoped
public class FormController {
	
	
	  @Inject 
	  OrderBusinessInterface service;
	  	  
	  public String onSubmit(User user) 
	  { 		
		  
		  FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user); 
		  return "TestResponse.xhtml"; 
	  }
	  
	  public String onSendOrder()
		{
			// Create an Order Number based on current time
			DecimalFormat df = new DecimalFormat("000000000000000");
			String orderNo = df.format(new Date().getTime());
			
			// Call Business Service to send an Order
			Order order = new Order();
			order.setOrderNo(orderNo);
			order.setProductName("This is an Ordered Product");
			order.setPrice((float)1000.00);
			order.setQuantity(2000);
			service.sendOrder(order);
			
			// Forward to Test Response View along with the User Managed Bean
			return "OrderResponse.xhtml";
		}

	  
	  public OrderBusinessInterface getService() 
	  { 
		  return service; 
	  }
}
