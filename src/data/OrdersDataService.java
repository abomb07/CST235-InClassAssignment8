package data;

import beans.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class OrdersDataService
 */
@Stateless
@Local(DataAccessInterface.class)
@LocalBean
public class OrdersDataService implements DataAccessInterface {

    /**
     * Default constructor. 
     */
    public OrdersDataService() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see DataAccessInterface#update()
     */
    public boolean update(Order order) {
        // TODO Auto-generated method stub
			return false;
    }

	/**
     * @see DataAccessInterface#create()
     */
    public Order create(Order order) {
    	Connection conn = null;
		  String URL = "jdbc:postgresql://localhost:5432/postgres";
		  String USER = "postgres";
		  String PASS = "root";
		  String SQL = "INSERT INTO testapp.orders(order_no, product_name, price, quantity) VALUES ('4', 'ITEM', '3.99', '10');";
		  try 
		  {
			  conn = DriverManager.getConnection(URL, USER, PASS);
			  
			  Statement stmt = conn.createStatement();
		
			  if(stmt.executeUpdate(SQL) > 0)
				{
					return order;
				}
				else
				{
					return null;
				}
		  } 
		  catch (SQLException e) 
		  {
			  e.printStackTrace();
			  return null;
		  }
		  finally
		  {
			  if(conn != null)
			  {
				  try
				  {
					  conn.close();
				  }
				  catch (SQLException e)
				  {
					  e.printStackTrace();
				  }
			  }
		  }
    }

	/**
     * @see DataAccessInterface#delete()
     */
    public boolean delete(Order order) {
        // TODO Auto-generated method stub
			return false;
    }

	/**
     * @see DataAccessInterface#findAll()
     */
    public List<Order> findAll() 
    {
    	Connection conn = null;
		  String URL = "jdbc:postgresql://localhost:5432/postgres";
		  String USER = "postgres";
		  String PASS = "root";
		  String SQL = "SELECT * FROM testapp.orders";
		  List<Order> orders = new ArrayList<Order>();
		  try 
		  {
			  conn = DriverManager.getConnection(URL, USER, PASS);
			  
			  Statement stmt = conn.createStatement();
			  ResultSet rs = stmt.executeQuery(SQL);
			  
			  while(rs.next())
			  {
				  orders.add(new Order(rs.getString("ORDER_NO"), 
						  			   rs.getString("PRODUCT_NAME"), 
						  			   rs.getFloat("PRICE"), 
						  			   rs.getInt("QUANTITY")));
			  }
			  rs.close();
		  } 
		  catch (SQLException e) 
		  {
			  e.printStackTrace();
		  }
		  finally
		  {
			  if(conn != null)
			  {
				  try
				  {
					  conn.close();
				  }
				  catch (SQLException e)
				  {
					  e.printStackTrace();
				  }
			  }
		  }
		  return orders;
    }

	/**
     * @see DataAccessInterface#findById(int)
     */
    public Order findByOrderNo(int id) 
    {
    	Order o1 = null;
    	Connection conn = null;
		  String URL = "jdbc:postgresql://localhost:5432/postgres";
		  String USER = "postgres";
		  String PASS = "root";
		  String SQL = "SELECT * FROM testapp.orders WHERE order_no = ?";
		  
		  try 
		  {
			  conn = DriverManager.getConnection(URL, USER, PASS);
			  
			  PreparedStatement stmt = conn.prepareStatement(SQL);
			  stmt.setInt(1, id);
			  ResultSet rs = stmt.executeQuery();
			  
			  while(rs.next())
			  {
				  o1 = new Order(rs.getString("ORDER_NO"), 
						  			   rs.getString("PRODUCT_NAME"), 
						  			   rs.getFloat("PRICE"), 
						  			   rs.getInt("QUANTITY"));
			  }
			  rs.close();
		  } 
		  catch (SQLException e) 
		  {
			  e.printStackTrace();
		  }
		  finally
		  {
			  if(conn != null)
			  {
				  try
				  {
					  conn.close();
				  }
				  catch (SQLException e)
				  {
					  e.printStackTrace();
				  }
			  }
		  }
		  return o1;
    }

}
