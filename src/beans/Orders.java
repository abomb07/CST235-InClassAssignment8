package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import business.OrderBusinessInterface;

@ManagedBean
@ViewScoped
public class Orders {
	List<Order> orders = new ArrayList<Order>();
	
	@Inject
	OrderBusinessInterface bs;
	
	@PostConstruct
	public void init()
	{
		orders = bs.getOrders();
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
