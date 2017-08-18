package onlineBookReader;

import static org.junit.Assert.*;

import org.junit.Test;

public class OnLineBookReaderTester {

	@Test
	public void test() {
		BookReader br=new BookReader();
		Book b1=new Book("Book1","Nan",1,15);
		Book b2=new Book("Book2","Nan",2,10);
		Book b3=null;
		br.registerUser(1, "123");
		br.registerUser(2, "234");
		br.registerUser(3, "345");
		assertTrue(br.userSignin(1, "123"));
		assertTrue(!br.userSignin(2, "123"));
		assertTrue(br.userSignin(2, "234"));
		assertTrue(br.userSignOff());
		assertTrue(!br.userSignOff());
		assertTrue(br.userSignin(1, "123"));
		assertTrue(br.addBook(b1));
		assertTrue(br.addBook(b2));
		assertTrue(!br.addBook(b3));
		assertTrue(br.readBook(2));
		for(int i=1;i<=10;i++){
			assertTrue(br.nextPage().equals(b2.name+i));
		}
		assertTrue(br.getLastReadBook()==2);
		assertTrue(br.readBook(1));
		for(int i=1;i<=15;i++){
			assertTrue(br.nextPage().equals(b1.name+i));
		}
		assertTrue(br.nextPage()==null);
		assertTrue(br.getLastReadBook()==1);
	}

}
