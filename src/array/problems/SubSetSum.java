package array.problems;

import java.util.ArrayList;

public class SubSetSum {
	
	public static boolean isSubsetSum(int a[], int n, int sum) {
		if (sum == 0) return true;
		if (n == 0 && sum != 0) return false;
		
		if (a[n-1] > sum) {
			return isSubsetSum(a, n-1, sum);
		}
		
		return isSubsetSum(a, n-1, sum) || isSubsetSum(a, n-1, sum - a[n-1]);
	}
	
	//Dynamic solution
	public static boolean isSubsetSum2(int a[], int n, int sum) {
		
		// The value of subset[i][j] will be true if there 
        // is a subset of set[0..j-1] with sum equal to i
		boolean[][] subset = new boolean[sum+1][n+1];
		
		 // If sum is 0, then answer is true
		for (int i  = 0; i <= n; i++ ) {
			subset[0][i] = true;
		}
		
		 // If sum is not 0 and set is empty, then answer is false
		for (int i = 1; i<= sum; i++) {
			subset[i][0] = false;
		}
		
		for (int i =1 ; i <= sum; i++) {
			for ( int j = 1; j <= n; j++) {
				subset[i][j] = subset[i][j-1];
				if ( i >= a[j-1]) {
					subset[i][j] = subset[i][j] || subset[i - a[j-1]][j-1];
				}
			}
		}
		
//      for (int i = 0; i <= sum; i++)
//      {
//        for (int j = 0; j <= n; j++)
//           System.out.printf("%-8s",String.valueOf(subset[i][j]));
//        System.out.println();
//      } 
		return subset[sum][n];
	}

      
    
  
    public static void main (String args[]) {
          int set[] = {8,3,9,1,1};
          int sum = 5;
          int n = set.length;
          if (isSubsetSum2(set, n, sum) == true)
             System.out.println("Found a subset with given sum");
          else
             System.out.println("No subset with given sum");
          
    }
}
