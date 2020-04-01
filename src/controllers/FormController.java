package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
		  getAllOrders();
		  //insertOrder();
		  //getAllOrders();
		  
		  FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user); 
		  return "TestResponse.xhtml"; 
	  }
	  
	  public OrderBusinessInterface getService() 
	  { 
		  return service; 
	  }
	 
	  private List<Order> getAllOrders()
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
				  System.out.println(rs.getString("ORDER_NO") + " " + 
						  			   rs.getString("PRODUCT_NAME") + " " + 
						  			   rs.getFloat("PRICE") + " " + 
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
		  return orders;
	  }
	  
	  private void insertOrder()
	  {
		  Connection conn = null;
		  String URL = "jdbc:postgresql://localhost:5432/postgres";
		  String USER = "postgres";
		  String PASS = "root";
		  String SQL = "INSERT INTO testapp.orders(order_no, product_name, price, quantity) VALUES ('4', 'This is the inserted product', '3.99', '10');";
		  try 
		  {
			  conn = DriverManager.getConnection(URL, USER, PASS);
			  
			  Statement stmt = conn.createStatement();
		
			  stmt.executeUpdate(SQL);
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
	  }
}
