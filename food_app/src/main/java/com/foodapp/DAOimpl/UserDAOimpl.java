package com.foodapp.DAOimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.DAO.UserDAO;
import com.foodapp.models.User;
import com.foodapp.util.DBconnection;

public class UserDAOimpl implements UserDAO {

	
	private String INSERT_QUERY="INSERT into `user`(`name`, `username`, `password`, `email`, `phonenumber`, `address`,`role`,`created_Date`,`last_login_date`)values(?,?,?,?,?,?,?,?,?)";
	private String UPDATE_QUERY="UPDATE `user` SET `name`=?, `username`=?, `password`=?, `email`=?, `phonenumber`=?, `address`=?,`role`=? WHERE `userid`=? ";
	private String GET_USER_BY_ID="SELECT *from `user` WHERE `userid` =?";
	private String GETALLUSERS="SELECT*FROM `user`";
	private String DELETE_USER="DELETE FROM user WHERE userId = ?";

	@Override
	public List<User> getAllUsers() {
		List<User>users=new ArrayList<User>();
		try (Connection con=DBconnection.getConnection();
				PreparedStatement ps=con.prepareStatement(GETALLUSERS);)
		{
		
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				int id=res.getInt("userid");
				String name=res.getString("name");
				String username=res.getString("username");
				String password=res.getString("password");
				String email=res.getString("email");
				String phonenumber=res.getString("phonenumber");
				String address=res.getString("address");
				String role=res.getString("role");
				Timestamp created=res.getTimestamp("created_date");
				Timestamp lastlogin=res.getTimestamp("last_login_date");
				User u=new User(id,name,username,password,email,phonenumber,address,role,created,lastlogin);
				 users.add(u);
				
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
		
	}

	@Override
	public User getUserById(int userId) {
		User u = null;
		try (Connection con=DBconnection.getConnection();
				PreparedStatement ps=con.prepareStatement(GET_USER_BY_ID);)
		{
			ps.setInt(1,userId);
			ResultSet res=ps.executeQuery();
			while(res.next())
			{
				int id=res.getInt("userid");
				String name=res.getString("name");
				String username=res.getString("username");
				String password=res.getString("password");
				String email=res.getString("email");
				String phonenumber=res.getString("phonenumber");
				String address=res.getString("address");
				String role=res.getString("role");
				Timestamp created=res.getTimestamp("created_date");
				Timestamp lastlogin=res.getTimestamp("last_login_date");
				 u=new User(id,name,username,password,email,phonenumber,address,role,created,lastlogin);
				
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
		
	}


	@Override
	public void addUser(User u) {
		
		try (Connection con=DBconnection.getConnection();
				PreparedStatement ps=con.prepareStatement(INSERT_QUERY);)
		{
		
		
		ps.setString(1, u.getName());
		ps.setString(2, u.getUsername());
		ps.setString(3, u.getPassword());
		ps.setString(4, u.getEmail());
		ps.setString(5, u.getPhonenumber());
		ps.setString(6, u.getAddress());
		ps.setString(7, u.getRole());
		ps.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
		ps.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
		int i=ps.executeUpdate();
		System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(User u) {
		try (Connection con=DBconnection.getConnection();
				PreparedStatement ps=con.prepareStatement(UPDATE_QUERY);){
		        ps.setString(1, u.getName());
				ps.setString(2, u.getUsername());
				ps.setString(3, u.getPassword());
				ps.setString(4, u.getEmail());
				ps.setString(5, u.getPhonenumber());
				ps.setString(6, u.getAddress());
				ps.setString(7, u.getRole());
				ps.setInt(8, u.getUserId());
				
				int i=ps.executeUpdate();
				System.out.println(i);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	

	@Override
	public void deleteUser(int userid) {
		try (Connection connection = DBconnection.getConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);) {

		        preparedStatement.setInt(1, userid);
		        int i = preparedStatement.executeUpdate();
		        System.out.println(i + " user(s) deleted.");

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
	}

}
