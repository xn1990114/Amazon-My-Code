package onsite;

import java.util.*;

/*
 * There are three row of houses. There are N houses in each row. 
 * Each house can be painted with three colors: red, blue and green. 
 * The cost of painting each house with a certain color is different. 
 * You have to paint all the houses with following constaints
 * No two adjacent houses in a row have the same color.
 * Houses in a column have three different colors
 * You have to paint the houses with minimum cost. How would you do it?
 */
public class PaintThreeHouse {
	// costs contains cost for house on row i, col j -- to be color
	// 0-red,1-blue,2-green
	public int paintCost(int N, int[][][] costs) {
		// rbg,rgb,bgr,brg,grb,gbr
		String[] color = { "r", "b", "g" };
		Map<String, Integer> last = new HashMap<String, Integer>();
		last.put("rbg", 0);
		last.put("rgb", 0);
		last.put("bgr", 0);
		last.put("brg", 0);
		last.put("grb", 0);
		last.put("gbr", 0);
		for (int i = 0; i < N; i++) {
			Map<String, Integer> currMap = new HashMap<String, Integer>();
			for (int c1 = 0; c1 < color.length; c1++) {
				for (int c2 = 0; c2 < color.length; c2++) {
					if (c1 == c2) {
						continue;
					}
					String curr = color[c1] + color[c2] + color[3 - c1 - c2];
					for (String lastKey : last.keySet()) {
						if (completeMisMatch(curr, lastKey)) {
							if (!currMap.containsKey(curr)) {
								currMap.put(curr, Integer.MAX_VALUE);
							}
							currMap.put(curr, Math.min(currMap.get(curr),
									last.get(lastKey) + costs[0][i][c1] + costs[1][i][c2] + costs[2][i][3 - c1 - c2]));
						}
					}
				}
			}
			last = currMap;
		}
		int min = Integer.MAX_VALUE;
		for (String key : last.keySet()) {
			min = Math.min(min, last.get(key));
		}
		return min;
	}

	public boolean completeMisMatch(String s1, String s2) {
		for (int i = 0; i < 3; i++) {
			if (s1.charAt(i) == s2.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
