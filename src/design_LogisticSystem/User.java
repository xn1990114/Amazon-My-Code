package design_LogisticSystem;
import java.util.*;

public abstract class User {
	int id;
	String userName;
	String password;
	List<Order> myOrders;

	public boolean resetPassword(String oldPassword,String newPassword){
		if(!this.password.equals(oldPassword)){
			return false;
		}
		this.password=newPassword;
		return true;
	}
	
}
