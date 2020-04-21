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

	public String onLogoff() {
		// Invalidate the Session to clear the security token
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

		// Redirect to a protected page (so we get a full HTTP Request) to get Login
		// Page
		return "TestResponse.xhtml?faces-redirect=true";

	}

	public String onSendOrder() {
		// Create an Order Number based on current time
		DecimalFormat df = new DecimalFormat("000000000000000");
		String orderNo = df.format(new Date().getTime());

		// Call Business Service to send an Order
		Order order = new Order();
		order.setOrderNo(orderNo);
		order.setProductName("This is an Ordered Product");
		order.setPrice((float) 1000.00);
		order.setQuantity(2000);
		service.sendOrder(order);

		// Forward to Test Response View along with the User Managed Bean
		return "OrderResponse.xhtml";
	}

	public OrderBusinessInterface getService() {
		return service;
	}
}
