package data;

import java.util.List;

import beans.Order;

public interface DataAccessInterface {
	public List<Order> findAll();
	public Order findByOrderNo(int id);
	public Order create(Order order);
	public boolean update(Order order);
	public boolean delete(Order order);
}
