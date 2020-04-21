package business;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import beans.Order;
import data.DataAccessInterface;
import data.OrdersDataService;

/**
 * Session Bean implementation class OrdersBusinessService
 */
@Stateless
@Local(OrderBusinessInterface.class)
@LocalBean
@Alternative
public class OrdersBusinessService implements OrderBusinessInterface {

	@EJB
	DataAccessInterface service;
	
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName="java:/jms/queue/Order")
	private Queue queue;

	List<Order> orders = new ArrayList<Order>();

	/**
	 * Default constructor.
	 */
	public OrdersBusinessService() 
	{
		
	}

	/**
	 * @see OrderBusinessInterface#test()
	 */
	public void test() {
		System.out.println("Hello from the OrdersBusinessService");
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return service.findAll();
	}

	@Override
	public void setOrders(List<Order> orders) {
		// TODO Auto-generated method stub
		this.orders = orders;
	}

	public void sendOrder(Order order)
	{
		try 
		{
			Connection connection = connectionFactory.createConnection();
			Session  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(queue);
			TextMessage message1 = session.createTextMessage();
			message1.setText("This is test message");
			messageProducer.send(message1);
			connection.close();
		} 
		catch (JMSException e) 
		{
			e.printStackTrace();
		}

	}

	@Override
	public Order findOrder(int id) {
		// TODO Auto-generated method stub
		return service.findByOrderNo(id);
	}

	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		return service.create(order);
	}
}
