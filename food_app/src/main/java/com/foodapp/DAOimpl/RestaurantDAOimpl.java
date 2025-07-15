package com.foodapp.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.DAO.RestaurantDAO;
import com.foodapp.models.Restaurant;
import com.foodapp.util.DBconnection;


public class RestaurantDAOimpl implements RestaurantDAO{
	private final String INSERT="INSERT into restaurant(name,address,phoneNumber,cuisineType,deliveryTime,adminUserId,rating,isActive,imagePath) values (?,?,?,?,?,?,?,?,?)";
	private final String UPDATE="UPDATE restaurant SET name = ?, address = ?, phoneNumber = ?, cuisineType = ?, deliveryTime = ?, adminUserId = ?, rating = ?, isActive = ?, imagePath = ? WHERE restaurantId = ? ";
	private final String GET_RESTAURANT_BY_ID = " SELECT * from restaurant where resturantId= ? ";
	private final String GET_ALL_RESTAURANT= " SELECT * from restaurant ";
	private final String DELETE_RESTAURANT = "DELETE FROM user WHERE resturantId = ?";

	@Override
	//here we use iterator so we have given list
	public List<Restaurant> getAllRestaurant() {
		List<Restaurant> restaurants = new ArrayList<>();

	    try (Connection connection = DBconnection.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_RESTAURANT);) {

	        ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            int restaurantId = resultSet.getInt("restaurantId");
	            String name = resultSet.getString("name");
	            String address = resultSet.getString("address");
	            String phoneNumber = resultSet.getString("phoneNumber");
	            String cuisineType = resultSet.getString("cuisineType");

	            // get delivery time as Timestamp
	            Timestamp deliveryTime = resultSet.getTimestamp("deliveryTime");

	            int adminUserId = resultSet.getInt("adminUserId");
	            String rating = resultSet.getString("rating");
	            String isActive = resultSet.getString("isActive");
	            String imagePath = resultSet.getString("imagePath");

	            
	            Restaurant restaurant = new Restaurant(restaurantId, name, address, phoneNumber,
	                cuisineType, deliveryTime, adminUserId,
	                rating, isActive, imagePath
	            );

	            restaurants.add(restaurant);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return restaurants;
		
	}

	@Override
	public Restaurant getRestaurantById(int restaurantId) {
		Restaurant restaurant = null;

	    try (Connection connection = DBconnection.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(GET_RESTAURANT_BY_ID);) {

	   
			preparedStatement.setInt(1, restaurantId);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        while (resultSet.next()) {
	            int id = resultSet.getInt("restaurantId");
	            String name = resultSet.getString("name");
	            String address = resultSet.getString("address");
	            String phoneNumber = resultSet.getString("phoneNumber");
	            String cuisineType = resultSet.getString("cuisineType");
	            Timestamp deliveryTime = resultSet.getTimestamp("deliveryTime");
	            int adminUserId = resultSet.getInt("adminUserId");
	            String rating = resultSet.getString("rating");
	            String isActive = resultSet.getString("isActive");
	            String imagePath = resultSet.getString("imagePath");

	            restaurant = new Restaurant(
	                id, name, address, phoneNumber,
	                cuisineType, deliveryTime, adminUserId,
	                rating, isActive, imagePath
	            );
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return restaurant;
	}

	@Override
	public void addRestaurant(Restaurant u) {
		try (Connection connection = DBconnection.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {

		        preparedStatement.setString(1, u.getName());
		        preparedStatement.setString(2, u.getAddress());
		        preparedStatement.setString(3, u.getPhoneNumber());
		        preparedStatement.setString(4, u.getCuisineType());
		        preparedStatement.setTimestamp(5, u.getDeliveryTime()); // Assuming it's a java.sql.Timestamp
		        preparedStatement.setInt(6, u.getAdminUserId());
		        preparedStatement.setString(7, u.getRating());
		        preparedStatement.setString(8, u.getIsActive());
		        preparedStatement.setString(9, u.getImagePath());

		        int rows = preparedStatement.executeUpdate();
		        System.out.println(rows + " restaurant(s) added.");

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
	

	@Override
	public void updateRestaurant(Restaurant u) {
		try (Connection connection = DBconnection.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {

		        preparedStatement.setString(1, u.getName());
		        preparedStatement.setString(2, u.getAddress());
		        preparedStatement.setString(3, u.getPhoneNumber());
		        preparedStatement.setString(4, u.getCuisineType());
		        preparedStatement.setTimestamp(5, u.getDeliveryTime()); // java.sql.Timestamp
		        preparedStatement.setInt(6, u.getAdminUserId());
		        preparedStatement.setString(7, u.getRating());
		        preparedStatement.setString(8, u.getIsActive());
		        preparedStatement.setString(9, u.getImagePath());
		        preparedStatement.setInt(10, u.getRestaurantId()); // WHERE clause

		        int i = preparedStatement.executeUpdate();
		        System.out.println(i + " restaurant(s) updated.");

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		try (Connection connection = DBconnection.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(DELETE_RESTAURANT)) {

		        preparedStatement.setInt(1, restaurantId);
		        int i = preparedStatement.executeUpdate();
		        System.out.println(i + " restaurant(s) deleted.");

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
	}

}
