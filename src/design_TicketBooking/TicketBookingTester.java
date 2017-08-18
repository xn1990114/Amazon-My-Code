package design_TicketBooking;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TicketBookingTester {

	@Test
	public void test() {
		BookingSystem bs=new BookingSystem();
		assertTrue(bs.addTicketType("NBA", 2, 2, 0));
		assertTrue(bs.addTicketType("UFFA", 2, 2, 0));
		assertTrue(bs.addTicketType("NFL", 2, 2, 0));
		assertTrue(bs.addTicketType("Nothing", 0, 0, 0));
		bs.bookTicket("NBA", 1, 1);
		bs.bookTicket("NBA", 1, 2);
		bs.bookTicket("NBA", 2, 1);
		bs.bookTicket("UFFA", 1, 1);
		assertFalse(bs.bookTicket("UFFA", 1, 1));
		bs.bookTicket("Nothing", 1, 1);
		bs.bookTicket("Nothing", 1, 2);
		bs.bookTicket("Nothing", 1, 3);
		bs.bookTicket("Nothing", 1, 4);
		bs.bookTicket("NFL", 1, 1);
		bs.bookTicket("NFL", 1, 3);
		bs.bookTicket("NFL", 1, 2);
		bs.bookTicket("NFL", 0, 1);
		bs.bookTicket("NFL", 1, 0);
		assertFalse(bs.addTicketType("NBA", 5, 5, 0));
		String[] expected1={"NBA","NFL","UFFA","Nothing"};
		List<String> r1=bs.findMostPopular(5);
		for(int i=0;i<r1.size();i++){
			System.out.println(r1.get(i)+bs.ticketType.get(r1.get(i)).countSold);
			assertTrue(r1.get(i).equals(expected1[i]));
		}
		assertTrue(bs.cancelTicket("NBA", 1, 1));
		assertFalse(bs.cancelTicket("NBA", 1, 1));
		assertTrue(bs.cancelTicket("NBA", 1, 2));
		String[] expected2={"NFL","UFFA","NBA","Nothing",};
		List<String> r2=bs.findMostPopular(4);
		for(int i=0;i<r1.size();i++){
			assertTrue(r2.get(i).equals(expected2[i]));
		}
		List<String> r3=bs.findMostPopular(1);
		assertTrue(r3.size()==1&&r3.get(0).equals("NFL"));
	}

}
