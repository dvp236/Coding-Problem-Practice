package array.problems;

import java.util.HashSet;

/**
 * 
 * @author dharmik
 * 
 * 
 *
 */
public class FindSmallestPositiveMissingNumberFromArray {
	
	public static int findMissing(int[] a) {
		HashSet<Integer> hs = new HashSet<>();
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) hs.add(a[i]);
		}
		
		for (int i = 1; i <= a.length; i++) {
			if (!hs.contains(i)) return i;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{2, 3, -7, 6, 8, 1, -10, 15};
		int[] a1 = new int[]{1, 1, 0, -1, -2};
		System.out.println(findMissing(a));
		System.out.println(findMissing(a1));
	}

}
