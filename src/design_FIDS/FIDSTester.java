package design_FIDS;

import org.junit.Test;

public class FIDSTester {

	@Test
	public void test() {
		FlightManagementSystem system=new FlightManagementSystem();
		system.addFlight(100, "Delta", "D001", "CA", Direction.arrive);
		system.addFlight(400, "AA", "A001", "CN", Direction.arrive);
		system.addFlight(150, "UA", "U001", "LA", Direction.arrive);
		system.addFlight(200, "Blue", "B001", "AR", Direction.arrive);
		system.addFlight(100, "Delta", "D002", "NY", Direction.depart);
		system.addFlight(150, "AA", "A020", "CT", Direction.depart);
		system.addFlight(100, "AA", "A007", "NJ", Direction.depart);
		system.addFlight(350, "Delta", "D005", "WA", Direction.depart);
		system.addFlight(200, "UA", "U002", "AR", Direction.depart);
		system.addFlight(400, "UA", "U003", "TX", Direction.depart);
		system.addFlight(250, "CA", "C001", "CA", Direction.depart);
		system.updateDashBoard();
		system.display();
		system.setTime(200);
		system.updateDashBoard();
		system.display();
		system.setTime(400);
		system.updateDashBoard();
		system.display();
	}

}
