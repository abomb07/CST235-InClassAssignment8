package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

/**
 * Session Bean implementation class AnotherOrdersBusinessService
 */
@Stateless
@Local(OrderBusinessInterface.class)
@LocalBean
@Alternative
public class AnotherOrdersBusinessService implements OrderBusinessInterface {

	List<Order> orders = new ArrayList<Order>();

	/**
	 * Default constructor.
	 */
	public AnotherOrdersBusinessService() {
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

	/**
	 * @see OrderBusinessInterface#test()
	 */
	public void test() {
		System.out.println("Hello from AnotherOrdersBusinessService");
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		// TODO Auto-generated method stub
		this.orders = orders;
	}

	@Override
	public void sendOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

}
