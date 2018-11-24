package array.problems;

public class FindKthElement {
	//Average case O(N). Worst case O(N^2);
	public static int findKth(int[] a, int k) {
		if (k <= 0 || k > a.length) {
			throw new IllegalArgumentException("check value of k");
		}
		int lo = 0, hi = a.length -1;
		int index = partition(a, lo, hi);
		k--;  //to map index to real world index
		//idea is to find an index of pivot, if pivot index is k then it has found its position in array
		while(k != index) {
			//if (k == index) return a[k];
			if (k > index) {
				lo = index+1;
				index = partition(a, lo, hi);
			} else {
				hi = index-1;
				index = partition(a,lo,hi);
			}
		}
		return a[k];
		
	}
	
	//partition subroutine of quicksort 
	private static int partition(int[] a, int lo, int hi) {
		int pivot = a[lo];
		int i = lo + 1;
		int j = lo + 1;
		
		while (j <= hi) {
			if (a[j] < pivot) {
				swap(a,i,j);
				i++;
			}
			j++;
		}
		swap(a,lo,i-1);
		return i-1;
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static void main(String[] args) {
		System.out.println("jsn");
		int[] a = new int[] {1,5,4,2,2,7,6};
		System.out.println(findKth(a, 3));
	}
	
}
