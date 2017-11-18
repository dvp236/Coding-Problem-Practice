package array.problems;

public class RotatedArray {
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
	
	
}
