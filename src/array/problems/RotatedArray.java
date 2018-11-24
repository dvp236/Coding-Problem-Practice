package array.problems;

public class RotatedArray {
	
	public static int findMinInRotatedArray(int[] a) {
		int min;
		//6,7,1,2,3,4,5
		//5,6,7,8,1,2
		
		int lo = 0, hi = a.length-1;
		//18,2,6,7,8,9,10
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (a[mid] < a[mid+1] && a[mid] < a[mid-1]) {
				return a[mid];
			}
			if (a[mid] < a[lo]) hi = mid - 1;
			else lo = mid + 1;
		}
		return a[lo];
		
	}
	
	//we have to return the minimum value index.
	public static int rotatecount(int[] a) {
		//12,13,2,6,7,8,9
		int lo = 0, hi = a.length -1 ;
		while(lo < hi) {
			int mid = (lo+hi)/2;
			if(mid != lo && a[mid] < a[mid - 1]) return mid;
			if(mid != hi && a[mid] > a[mid + 1]) return mid + 1;
			if(a[lo] > a[mid]) hi = mid -1;
			else lo = mid+1;
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] a = new int[]{18,2,3,7,8,9,10,11};
		System.out.println(rotatecount(a));
		System.out.println(findMinInRotatedArray(a));
	}
	
	
}
