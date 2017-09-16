package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.CoinChange;

public class CoinChangeTester {

	@Test
	public void test() {
		CoinChange tester=new CoinChange();
		double[] coins={0.01,0.05,0.25, 0.1};
		double target=0.52;
		System.out.println(tester.findCoinsChange(coins, target));
	}

}
