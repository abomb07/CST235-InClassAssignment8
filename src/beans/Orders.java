package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Orders {
	List<Order> orders = new ArrayList<Order>();
	
	public Orders() {
		orders.add(new Order("00000001", "P1", (float) 1.00, 1));
		orders.add(new Order("00000002", "P2", (float) 3.00, 2));
		orders.add(new Order("00000003", "P3", (float) 1.50, 4));
		orders.add(new Order("00000004", "P4", (float) 2.50, 4));
		orders.add(new Order("00000005", "P5", (float) 3.50, 4));
		orders.add(new Order("00000006", "P6", (float) 4.50, 4));
		orders.add(new Order("00000007", "P7", (float) 5.50, 4));
		orders.add(new Order("00000008", "P8", (float) 6.50, 4));
		orders.add(new Order("00000009", "P9", (float) 7.50, 4));
		orders.add(new Order("00000010", "P10", (float) 8.50, 4));
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
