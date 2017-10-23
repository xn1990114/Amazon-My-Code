package design_MovieBookingSystem;

public abstract class User {
	static int ID=1;
	int id;
	String userName;
	String password;
	BookingSystem sys;
	public User(String userName, String password, BookingSystem sys) {
		this.id = ID;
		ID++;
		this.userName = userName;
		this.password = password;
		this.sys = sys;
	}
	
	public boolean resetPassword(String oldPw,String newPw){
		if(!this.password.equals(oldPw)){
			return false;
		}
		this.password=newPw;
		return true;
	}
	
	
}
