package array.problems;
//http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArrays {
	public static int findmed(int[] a, int[] b) {
		return findmed(a, 0, a.length-1, b, 0, b.length-1);
	}
	
	public static int findmed(int[] a, int al, int ah, int[] b, int bl, int bh) {
		if (ah-al == 1 && bh - bl ==1)
			return (Math.max(a[al], b[bl]) + Math.min(a[ah], b[bh]))/2;
		
		int m1 = medAscArray(a,al,ah);
		int m2 = medAscArray(b,bl,bh);
		if (m1 == m2) return m2;
		else if(m1 > m2) {
			return findmed(a, al, (al+ah)/2,b,(bl+bh)/2,bh);
					
		}else{
			return findmed(a, (al+ah)/2,ah ,b,bl,(bl+bh)/2);
		}
	}
	public static int medAscArray(int[] a, int lo, int hi) {
		int n = (hi+lo)/2;
		if(n % 2 ==  0) {
			return a[n];
		}
		
		return (a[n] + a[n + 1]) / 2;
	}
	public static void main(String[] args) {
		System.out.println("jsn !!");
		int[] a = new int[]{1,12,15,26,38};
		int[] b = new int[]{2,13,17,20,45};
		System.out.println(findmed(a,b));
		
	}

}
