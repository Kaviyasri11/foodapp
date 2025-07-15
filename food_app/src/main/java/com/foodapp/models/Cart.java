package com.foodapp.models;

public class Cart {
    private int itemId;
    private String itemName;
    private double price;
    private int quantity;
    private String imagePath; 
    private String description;

    public Cart(int itemId, String itemName, double price, int quantity, String imagePath, String description) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.imagePath = imagePath;
        this.description = description;
    }

    public int getItemId() {
        return itemId;
    }
    public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getItemName() {
        return itemName;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
    
}
