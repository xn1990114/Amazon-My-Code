package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.MatrixAverage;

public class MatrixAverageTester {

	@Test
	public void test() {
		MatrixAverage test=new MatrixAverage();
		double[][] nums1={{1,1,1,1,1,1},
		   			  	  {2,2,2,2,2,2},
		   			  	  {3,3,3,3,3,3},
		   			  	  {4,4,4,4,4,4},
		   			  	  {5,5,5,5,5,5}};
		test.replaceToAverage(nums1);
		test.display(nums1);
		double[][] nums2={{1,2,3,4,5,6},
 			  	  		  {2,3,4,5,6,7},
 			  	  		  {3,4,5,6,7,8},
 			  	  		  {4,5,6,7,8,9},
 			  	  		  {5,6,7,8,9,10}};
		test.replaceToAverage(nums2);
		test.display(nums2);
		double[][] nums3={{1,2,3,4,5,6}};
		test.replaceToAverage(nums3);
		test.display(nums3);
		double[][] nums4={{1},
	  	  		  		{2},
	  	  		  		{3}};
		test.replaceToAverage(nums4);
		test.display(nums4);
		double[][] nums5={};
		test.replaceToAverage(nums5);
		test.display(nums5);
	}

}
