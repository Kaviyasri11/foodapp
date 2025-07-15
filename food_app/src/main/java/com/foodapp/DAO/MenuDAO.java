package com.foodapp.DAO;

import java.util.List;

import com.foodapp.models.Menu;

public interface MenuDAO {
	List<Menu> getAllMenu();
	Menu getMenuById(int menuId);
	void addMenu(Menu m);
	void updateMenu(Menu m);
	void deleteMenu(int menuId);
	List<Menu> getMenuById1(int menuId);
	 
}
