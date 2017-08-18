package parkingLot;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParkingLotTester {

	@Test
	public void test() {
		ParkingManager pm=new ParkingManager(3,1,5);
		Vehicle m1=new MotorCycle("m1");
		Vehicle m2=new MotorCycle("m2");
		Vehicle m3=new MotorCycle("m3");
		Vehicle c1=new Car("c1");
		Vehicle c2=new Car("c2");
		Vehicle c3=new Car("c3");
		Vehicle b1=new Bus("b1");
		Vehicle b2=new Bus("b2");
		assertTrue(pm.parkVehicle(m1));
		assertTrue(pm.parkVehicle(b1));
		assertTrue(pm.parkVehicle(m2));
		assertTrue(pm.parkVehicle(m3));
		assertTrue(pm.parkVehicle(c1));
		assertTrue(pm.parkVehicle(c2));
		assertTrue(pm.parkVehicle(b2));
		assertTrue(!pm.parkVehicle(c3));
		assertTrue(pm.removeCar(b2));
		assertTrue(pm.parkVehicle(c3));
	}

}
