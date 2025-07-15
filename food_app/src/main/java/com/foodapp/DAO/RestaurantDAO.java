package com.foodapp.DAO;

import java.util.List;

import com.foodapp.models.Restaurant;

public interface RestaurantDAO {
	List<Restaurant> getAllRestaurant();
    Restaurant getRestaurantById(int restaurantId);
	void addRestaurant(Restaurant u);
	void updateRestaurant(Restaurant u);
	void deleteRestaurant(int restaurantId);

}
