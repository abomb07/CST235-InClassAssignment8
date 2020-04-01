package data;

import java.util.List;

import beans.Order;

public interface DataAccessInterface {
	public List<Order> findAll();
	public Order findById(int id);
	public boolean create(Order order);
	public boolean update(Order order);
	public boolean delete(Order order);
}
