package com.foodapp.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.DAO.MenuDAO;
import com.foodapp.models.Menu;
import com.foodapp.util.DBconnection;



public class MenuDAOimp implements MenuDAO{
	private final String INSERT = "INSERT INTO menu (restaurantId, itemName, description, price, isAvailable, ratings, imagePath) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String UPDATE = "UPDATE menu SET restaurantId = ?, itemName = ?, description = ?, price = ?, isAvailable = ?, ratings = ?, imagePath = ? WHERE menuId = ?";
    private final String GET_ALL_MENU = "SELECT * FROM menu";
    private final String GET_MENU_BY_ID = "SELECT * FROM menu WHERE menuId = ?";
    private final String GETMENUBYID = "SELECT * FROM menu WHERE restaurantId  = ?";
    private final String DELETE_MENU = "DELETE FROM menu WHERE menuId = ?";

	@Override
	public List<Menu> getAllMenu() {
		List<Menu> menus = new ArrayList<Menu>();

	    try (Connection connection = DBconnection.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_MENU);) {

	        ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            int menuId = resultSet.getInt("menuId");
	            int restaurantId = resultSet.getInt("restaurantId");
	            String itemName = resultSet.getString("itemName");
	            String description = resultSet.getString("description");
	            String price = resultSet.getString("price");
	            String isAvailable = resultSet.getString("isAvailable");
	            String ratings = resultSet.getString("ratings");
	            String imagePath = resultSet.getString("imagePath");

	            Menu m = new Menu(menuId, restaurantId, itemName, description, price, isAvailable, ratings, imagePath);
	            menus.add(m);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return menus;
		
	}

	@Override
	public Menu getMenuById(int menuId) {
		Menu menu = null;

	    try (Connection connection = DBconnection.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(GET_MENU_BY_ID);) {

	        preparedStatement.setInt(1, menuId);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            int id = resultSet.getInt("menuId");
	            int restaurantId = resultSet.getInt("restaurantId");
	            String itemName = resultSet.getString("itemName");
	            String description = resultSet.getString("description");
	            String price = resultSet.getString("price");
	            String isAvailable = resultSet.getString("isAvailable");
	            String ratings = resultSet.getString("ratings");
	            String imagePath = resultSet.getString("imagePath");

	            menu = new Menu(id, restaurantId, itemName, description, price, isAvailable, ratings, imagePath);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return menu;
	}
	@Override
	public List<Menu> getMenuById1(int restaurantId) {
		List<Menu> menu = new ArrayList<Menu>();;

	    try (Connection connection = DBconnection.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(GETMENUBYID);) {

	        preparedStatement.setInt(1, restaurantId);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            int id = resultSet.getInt("menuId");
	            int restId = resultSet.getInt("restaurantId");
	            String itemName = resultSet.getString("itemName");
	            String description = resultSet.getString("description");
	            String price = resultSet.getString("price");
	            String isAvailable = resultSet.getString("isAvailable");
	            String ratings = resultSet.getString("ratings");
	            String imagePath = resultSet.getString("imagePath");

	            Menu m=  new Menu(id, restId, itemName, description, price, isAvailable, ratings, imagePath);
	            menu.add(m);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return menu;
	}
	@Override
	public void addMenu(Menu m) {
		try (Connection connection = DBconnection.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(INSERT);) {
		         
		        preparedStatement.setInt(1, m.getRestaurantId());
		        preparedStatement.setString(2, m.getItemName());
		        preparedStatement.setString(3, m.getDescription());
		        preparedStatement.setString(4, m.getPrice());
		        preparedStatement.setString(5, m.getIsAvailable());
		        preparedStatement.setString(6, m.getRatings());
		        preparedStatement.setString(7, m.getImagePath());

		        int i = preparedStatement.executeUpdate();
		        System.out.println(i + " menu item(s) inserted.");

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
	}

	@Override
	public void updateMenu(Menu m) {
		 try (Connection connection = DBconnection.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);) {

		        preparedStatement.setInt(1, m.getRestaurantId());
		        preparedStatement.setString(2, m.getItemName());
		        preparedStatement.setString(3, m.getDescription());
		        preparedStatement.setString(4, m.getPrice());
		        preparedStatement.setString(5, m.getIsAvailable());
		        preparedStatement.setString(6, m.getRatings());
		        preparedStatement.setString(7, m.getImagePath());
		        preparedStatement.setInt(8, m.getMenuId());  // WHERE menuId = ?

		        int i = preparedStatement.executeUpdate();
		        System.out.println(i + " menu item(s) updated.");

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
	}

	@Override
	public void deleteMenu(int menuId) {
		
		try (Connection connection = DBconnection.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MENU);) {

		        preparedStatement.setInt(1, menuId);
		        int i = preparedStatement.executeUpdate();
		        System.out.println(i + " menu item(s) deleted.");

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}

}
