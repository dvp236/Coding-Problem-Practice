package array.problems;

public class CoinChange {
	//
	public static int changeWays(int[] denom, int n, int index) {
		int ways = 0;
		if (index >= denom.length - 1) return 1;
		int denomAmount = denom[index];
		
		
		for ( int i = 0; i * denomAmount <= n; i++) {
			int amountRem = n - i * denomAmount;
			//remain = n - amount;
			ways += changeWays(denom, amountRem, index+1);
		}
		
		return ways;
	}
	
	public static int dpChangeWays(int[] denom, int n, int index) {
		int[][] map = new int[n+1][denom.length];
		return dpChangeWaysHelper(denom, n, 0, map);
	}
	
	public static int dpChangeWaysHelper(int[] denom, int n, int index, int[][] map) {
		if(map[n][index] > 0) return map[n][index];
			
		
		if(index >= denom.length - 1) return 1;
		
		int amount = denom[index];
		int ways = 0;
		for (int i = 0; i * amount <= n; i++) {
			int remainingAmount = n - i * amount;
			ways += dpChangeWaysHelper(denom, remainingAmount, index+1, map);
		}
		map[amount][index] = ways;
		return ways;
		
	}
	
	public static void main(String[] args) {
		int[] denom = new int[]{25,10,5,1};
		System.out.println(changeWays(denom, 50, 0));
		
		System.out.println(dpChangeWays(denom, 50, 0));
	}
	
	

}
