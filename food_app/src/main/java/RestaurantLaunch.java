import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.foodapp.DAOimpl.RestaurantDAOimpl;
import com.foodapp.models.Restaurant;

public class RestaurantLaunch {
	 public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);

	        System.out.println("Enter the name:");
	        String name = s.next();

	        System.out.println("Enter the address :");
	        String address = s.next();

	        System.out.println("Enter the phone number:");
	        String phoneNumber = s.next();

	        System.out.println("Enter the cuisine type:");
	        String cuisineType = s.next();

	        System.out.println("Enter estimated delivery time in minutes:");
	        int deliveryInMins = s.nextInt();
	        s.nextLine(); // consume newline
	        Timestamp deliveryTime = Timestamp.valueOf(LocalDateTime.now().plusMinutes(deliveryInMins));

	        System.out.println("Enter the admin user ID:");
	        int adminUserId = s.nextInt();

	        System.out.println("Enter the rating:");
	        String rating = s.next();

	        System.out.println("Is active? (yes/no):");
	        String isActive = s.next();

	      
	        System.out.println("Enter the image path:");
	        String imagePath = s.next();

	        // Create Restaurant object (id will be auto-generated usually)
	        Restaurant restaurant = new Restaurant(name, address, phoneNumber, cuisineType,
	                deliveryTime, adminUserId, rating, isActive, imagePath);

	        // Add to database
	        RestaurantDAOimpl dao = new RestaurantDAOimpl();
	        dao.addRestaurant(restaurant);

	        System.out.println("Restaurant added successfully!");
	    }
}


