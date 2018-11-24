package array.problems;

public class SubArraySum {
	public static void targetSum(int[] a, int target) {
		if (a == null || a.length == 0) throw new IllegalArgumentException("Array cant be null or empty");
		int i = 0, sum = 0;
		for (int j = 0; j < a.length; j++) {
			sum += a[j];
			while (i < a.length && sum > target) {
				sum -= a[i];
				i++;
			}
			if (sum == target) {
				System.out.println("target found between: "+i+" - "+j);
			}
		}
	}
	public static void main(String[] args) {
		int[] a = new int[]{1,1,2,4,6,4,5,6,7,10,17};
		targetSum(a, 17);
	}

}
