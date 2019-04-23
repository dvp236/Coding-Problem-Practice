package array.problems;

public class MaxSubArray {
	public static int maxLeftRightSubArray(int[] a, int lo, int mid, int hi) {
		int left_max = Integer.MIN_VALUE;
		int sum = 0;
		//go towards left from the mid
		for (int i = mid; i >= lo; i--) {
			sum += a[i];
			if (sum > left_max) {
				left_max = sum;
			}
		}
		int right_max = Integer.MIN_VALUE;
		sum  = 0;
		//go rightward from mid
		for (int i = mid+1;  i <= hi; i++) {
			sum += a[i];
			if (sum > right_max) right_max = sum;
		}
		//return max
		return left_max + right_max;
	}
	public static int maxSubArray(int[] a, int lo, int hi) {
		if(lo == hi) return a[lo];
		
		int mid = (lo + hi)/2;
		int leftSubArray = maxSubArray(a, lo, mid);
		int rightSubArray = maxSubArray(a, mid+1, hi);
		int maxLeftAndRight = maxLeftRightSubArray(a, lo, mid, hi);
		return Math.max(Math.max(leftSubArray, rightSubArray), maxLeftAndRight);
	}
	
	//Kadane algo
	public static int kMaxSubArray(int[] a) {
		if (a.length == 0 || a == null) {
			return 0;
		}
		int maxSoFar = a[0];
		int maxEndingHere = a[0];
		//we can also use array dp[] which keeps max till i in dp[i]. but that takes extra memory
		//can be used if use case demand that.
		for (int i = 1; i < a.length; i++) {
			//handling negative
			maxEndingHere = Math.max(a[i], maxEndingHere + a[i]);
			maxSoFar = Math.max(maxEndingHere, maxSoFar);
		}
		return maxSoFar;
	}
	
	public static int kMaxSubArray1(int[] a) {
		if (a.length == 0 || a == null) {
			return 0;
		}
		int _start=0, start = 0, end = 0;
		int maxSoFar =0;
		int maxEndingHere = a[0];
		//we can also use array dp[] which keeps max till i in dp[i]. but that takes extra memory
		//can be used if use case demand that.
		for (int i = 1; i < a.length; i++) {
			//handling negative
			//maxEndingHere = Math.max(a[i], maxEndingHere + a[i]);
			if(a[i] > maxEndingHere + a[i]) {
				_start = i;
				maxEndingHere  = a[i];
			} else {
				maxEndingHere += a[i];
			}
			
			if (maxEndingHere > maxSoFar) {
				maxSoFar = maxEndingHere;
				start = _start;
				end = i;
			}
		}
		System.out.println("start - "+start+" --- end -"+end);
		return maxSoFar;
	}

	public static void main(String[] args) {
		int[] a = new int[] {-8,-6,-7,2,3,4,1,-9,19,-1};
		int[] b = new int[] {-2,-3,4,-1,2,-1,5,-3,0};

		System.out.println(maxSubArray(a, 0, a.length - 1));
		System.out.println(kMaxSubArray(b));
		System.out.println(kMaxSubArray1(b));

	}

}
