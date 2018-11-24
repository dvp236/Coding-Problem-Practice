package array.problems;

//implement question asked in GS
//[1,2,3,4] target =6 -> return 2 i.e subarray with min length that whose sum >= target
public class MinSubarray {
	//to implement efficient one - sort the array. and then loop over from last index.
	//total complexity o(nlogn)
	
	//O(n2)
	public static int minSubArr(int[] a, int target) {
		int sum =0;
		int min = Integer.MAX_VALUE;
		
		for(int i = 0; i <a.length; i++  ) {
			sum = 0;
			int temp = 0;
			for (int j = i; j < a.length; j++) {
				sum = sum + a[j];
				temp++;
				if(sum >= target){
					if(temp < min) min = temp;
				}
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	//Time Complexity = O(N). Each element visited atmost 2 times. 
	public static int minSubArrayLen(int[] nums, int s) {
	    int n = nums.length;
	    int ans = Integer.MAX_VALUE;
	    int left = 0;
	    int sum = 0;
	    // one more improvement - when find element bigger than s, just return 1;
	    // that way you dont have to run left pointer up to that big element.
	    for (int i = 0; i < n; i++) {
	    	if(nums[i] > 0)
	    		sum += nums[i];
	        while (sum >= s) {
	            ans = Math.min(ans, i + 1 - left);
	            if(nums[left] < 0){
	            	left++;
	            }
	            else {
	            	sum -= nums[left++];
	            }
	            	
	        }
	    }
	    return (ans != Integer.MAX_VALUE) ? ans : 0;
	}

	//find a min subset with sum
	public static int subsetmin(int[] a, int n, int target, int min) {
		if(target <= 0) return min;
		if(n == 0) return min;
		
		return Math.min(subsetmin(a, n-1,target,min), subsetmin(a,n-1, target - a[n-1],min-1));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{1,2,1,1,1,9,1,1};
		int[] b = new int[]{- 8, 11, -4, 15, -6};
		int arr1[] = {1, 4, 45, 6, 10, 19};
		System.out.println(minSubArr(b,20));
		System.out.println(minSubArrayLen(b, 20));
		//System.out.println(subsetmin(a,a.length,11,a.length+1));
		//System.out.println(subsetmin(arr1,arr1.length,51,arr1.length+1));
		//System.out.println(subsetmin(a,a.length,11,a.length+1));

	}

}
