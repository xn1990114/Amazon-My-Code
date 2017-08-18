package design_Intersection;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class IntersectionTester {

	@Test
	public void test() throws Exception {
		Intersection sec=new Intersection();
		sec.setSensor(1,2);
		sec.checkSensor();
		sec.updateStatus();
		System.out.println();
		for(int i=0;i<4;i++){
			System.out.print(sec.lights[i].status+"\t");
		}
		System.out.println();
		sec.setSensor(2,1);
		sec.checkSensor();
		sec.updateStatus();
		System.out.println();
		for(int i=0;i<4;i++){
			System.out.print(sec.lights[i].status+"\t");
		}
	}

}
