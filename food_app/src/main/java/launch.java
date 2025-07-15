import java.util.Scanner;

import com.foodapp.DAOimpl.UserDAOimpl;
import com.foodapp.models.User;
public class launch {


public static void main(String[]args)
{
	Scanner s=new Scanner(System.in);
	/*System.out.println("Enter the name:");
	String name=s.next();
	System.out.println("Enter the username:");
	String username=s.next();
	System.out.println("Enter the password:");
	String password=s.next();
	System.out.println("Enter the email:");
	String email=s.next();
	System.out.println("Enter the phonenumber:");
	String phonenumber=s.next();
	System.out.println("Enter the address:");
	String address=s.next();
	System.out.println("Enter the role:");
	String role=s.next();*/
	System.out.println("Enter the id:");
	int id=s.nextInt();
	//User u = new User(name,username,password,email,phonenumber,address,role);
	UserDAOimpl udao=new UserDAOimpl();
	//udao.addUser(u);
	udao.deleteUser(id);
	//User u=udao.getUserById(id);
	//System.out.println(u);
	//u.setPassword("5678");
	//u.setAddress("Rajaji Nagar");
	//udao.updateUser(u);
}
}
