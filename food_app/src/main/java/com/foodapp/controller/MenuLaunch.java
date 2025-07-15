package com.foodapp.controller;

import java.util.Scanner;

import com.foodapp.DAOimpl.MenuDAOimp;
import com.foodapp.models.Menu;

public class MenuLaunch {
	 public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);

	        System.out.println("Enter the restaurant ID:");
	        int restaurantId = s.nextInt();
	        s.nextLine(); // consume newline

	        System.out.println("Enter the item name:");
	        String itemName = s.nextLine();

	        System.out.println("Enter the description:");
	        String description = s.nextLine();

	        System.out.println("Enter the price:");
	        String price = s.nextLine();

	        System.out.println("Is it available? (yes/no):");
	        String isAvailable = s.nextLine();

	        System.out.println("Enter the ratings:");
	        String ratings = s.nextLine();

	        System.out.println("Enter the image path:");
	        String imagePath = s.nextLine();

	        // ID is auto-generated, so pass 0 or skip in constructor if overloaded
	        Menu menu = new Menu( restaurantId, itemName, description, price, isAvailable, ratings, imagePath);

	        MenuDAOimp dao = new MenuDAOimp();
	        dao.addMenu(menu);

	        System.out.println("Menu item added successfully!");
	    }
}



