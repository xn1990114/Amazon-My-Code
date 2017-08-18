package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.PaintThreeHouse;

public class PaintThreeHouseTester {

	@Test
	public void test() {
		PaintThreeHouse pth=new PaintThreeHouse();
		int N=4;
		int[][][] costs={
				{{4,5,1},{9,1,8},{6,9,1},{2,5,7}},
				{{5,2,7},{5,8,2},{8,1,5},{8,4,1}},
				{{2,5,7},{4,7,2},{1,6,1},{3,7,3}},
		};
		System.out.println(pth.paintCost(N, costs));
	}

}
