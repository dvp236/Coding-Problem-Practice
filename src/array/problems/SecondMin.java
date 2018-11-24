package array.problems;

/**
 * 
 * @author dharmik
 *
 * Find the second minimum element from the array.
 */
public class SecondMin {
	
	public static int getSecondMininum(int[] a) {
		if (a == null || a.length < 2) {
			return Integer.MIN_VALUE;
		}
		
		int min, smin;
		min = Integer.MAX_VALUE;
		smin = Integer.MAX_VALUE;
		
		for (int i = 0; i < a.length; i++) {
			if (a[i] < min) {
				smin = min;
				min = a[i];
			}
			
			if (a[i] < smin && a[i] > min) {
				smin = a[i];
			}
		}
		
		return smin;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{16,3,4,5,9,1,4};
		int[] b = new int[]{16,8,1,6,5,4,3,2};
		System.out.println(getSecondMininum(a));
		System.out.println(getSecondMininum(b));
	}

}
