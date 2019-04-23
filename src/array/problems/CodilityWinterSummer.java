package array.problems;

import java.util.Arrays;

/**
 * 
 * @author dhamrik
 * [5,-2,3,8,6] => 3
 *  5 3 6 14 20
 * [-5,-5,-5,-42, 6, 12] => 4
 *
 */
public class CodilityWinterSummer {

	public static int getWinter(int[] T) {
		int[] minR = new int[T.length];
		minR[T.length - 1] = T[T.length - 1];
		
		for (int i = T.length - 2; i >= 0; i--) {
			minR[i] = Math.min(minR[i+1], T[i]); 
		}
		int maxSoFar = T[0];
		
		int index = 0;
		for (int i = 1; i < T.length-1; i++) {
			if (maxSoFar < minR[i+1]){
				index = i;
			}

			maxSoFar = Math.max(maxSoFar, T[i]);
			
		}
		return index;
	}
	
	public static int getWinter1(int[] T) {
		int[] dp = new int[T.length];
		dp[0] = T[0];
		for (int i = 1; i < T.length; i++) dp[i] = T[i] + dp[i-1];
		int maxSoFar = T[0];
		int index = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < T.length; i++) {
			if (dp[i] < min) {
				min = dp[i];
				maxSoFar = Math.max(maxSoFar, T[i]);
			}
			if (T[i] < maxSoFar) {
				index = i+ 1;
			}
		}
		
		return index;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] T = new int[] {5,-2,3,8,6};
		int[] T1 = new int[] {-5, -5, -5, -42, 6, 12};
		
		System.out.println(getWinter1(T));
		System.out.println(getWinter1(T1));
		
		System.out.println(getWinter(T));
		System.out.println(getWinter(T1));
	}

}
