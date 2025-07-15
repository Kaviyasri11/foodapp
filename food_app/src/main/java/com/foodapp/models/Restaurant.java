package com.foodapp.models;

import java.sql.Timestamp;

public class Restaurant {
int restaurantId;
String name;
String address;
String phoneNumber;
String cuisineType;
Timestamp deliveryTime;
int adminUserId;
String rating;
String isActive;
String ImagePath;
public  Restaurant() {
	
}
public Restaurant( String name, String address, String phoneNumber, String cuisineType,
		Timestamp deliveryTime, int adminUserId, String rating, String isActive, String imagePath) {
	super();
	
	this.name = name;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.cuisineType = cuisineType;
	this.deliveryTime = deliveryTime;
	this.adminUserId = adminUserId;
	this.rating = rating;
	this.isActive = isActive;
	ImagePath = imagePath;
}
public Restaurant(int restaurantId, String name, String address, String phoneNumber, String cuisineType,
		Timestamp deliveryTime, int adminUserId, String rating, String isActive, String imagePath) {
	super();
	this.restaurantId = restaurantId;
	this.name = name;
	this.address = address;
	this.phoneNumber = phoneNumber;
	this.cuisineType = cuisineType;
	this.deliveryTime = deliveryTime;
	this.adminUserId = adminUserId;
	this.rating = rating;
	this.isActive = isActive;
	ImagePath = imagePath;
}
public int getRestaurantId() {
	return restaurantId;
}
public void setRestaurantId(int restaurantId) {
	this.restaurantId = restaurantId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getCuisineType() {
	return cuisineType;
}
public void setCuisineType(String cuisineType) {
	this.cuisineType = cuisineType;
}
public Timestamp getDeliveryTime() {
	return deliveryTime;
}
public void setDeliveryTime(Timestamp deliveryTime) {
	this.deliveryTime = deliveryTime;
}
public int getAdminUserId() {
	return adminUserId;
}
public void setAdminUserId(int adminUserId) {
	this.adminUserId = adminUserId;
}
public String getRating() {
	return rating;
}
public void setRating(String rating) {
	this.rating = rating;
}
public String getIsActive() {
	return isActive;
}
public void setIsActive(String isActive) {
	this.isActive = isActive;
}
public String getImagePath() {
	return ImagePath;
}
public void setImagePath(String imagePath) {
	ImagePath = imagePath;
}
@Override
public String toString() {
	return "Restaurant: ["+ name+" "+address+" "+phoneNumber+" "+rating+" "+"]";
}
}
