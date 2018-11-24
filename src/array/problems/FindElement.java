package array.problems;

import java.util.ArrayList;

/**
 * 
 * @author dharmik
 *	Find element from the ascending array where a[i] = i
 */
public class FindElement {
	
	
	/**
	 * Time complexity O(log(n)). finds only one element that gets caught first. Works when elements are distinct.
	 * @param a the ascending array 
	 * @return returns index of perfect element where {@code a[i] = i}
	 */
	public int findPerfectElement(int a[]){
		//applying binary search on array
		int lo = 0, hi = a.length-1;
		while(lo <= hi){
			int mid = (lo+hi)/2 ;
			if (a[mid] == mid){
				return mid; 
			}
			else if(a[mid] > mid){
				hi = mid -1 ;
			}
			else {
				lo = mid + 1;
			}
		}
		return -1;
		
	}
	
	/**
	 * TimeComplexity: WorstCase- O(N). This Method finds perfect element from the ascending array that may contain 
	 * duplicate entries of elements. This method uses modified version of binary search.
	 * @param a the ascending array
	 * @return returns the index of element where {@code a[i] == i}
	 */
	public int findPerfectElementDuplicateAllowedArray(int[] a) {
		return findPerfectDuplicateHelper(a, 0, a.length - 1);
	}
	//helper method
	public int findPerfectDuplicateHelper(int[] a, int start, int end) {
		if (end < start) return -1;
		int midIndex, midValue;
		midIndex = (start + end) / 2;
		midValue = a[midIndex];
		
		//if a[i] == i, return it
		if (midValue == midIndex) return midIndex;
		
		int leftIndex = Math.min(midIndex-1, midValue);
		//search left part
		int left = findPerfectDuplicateHelper(a, start, leftIndex);
		//return if perfect index found
		if(left != -1) return left;
		
		//search right part
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = findPerfectDuplicateHelper(a, rightIndex, end);
		//return perfect element or -1 if not found
		return right;
	}
	
	/**
	 * Time complexity O(n). find all such elements where a[i] = i
	 * @param a the ascending array 
	 * @return an ArrayList of all the elements where {@code a[i] = i}
	 */
	public ArrayList<Integer> findAllElements(int[] a ){
		ArrayList<Integer> result  = new ArrayList<Integer>();
		for(int i=0;i<a.length;i++){
			if(a[i]== i){
				result.add(i);
			}
		}
		return result;
	}
	
	/**
	 * For the purpose of unit testing
	 */
	public static void main(String[] args) {
		int[] a = new int[] {1,2,8,8,8,8,8,8,8,8,8,8,8,88};
		
		
		
		FindElement search = new FindElement();
		System.out.println(search.findPerfectElement(a));
		System.out.println(search.findPerfectElementDuplicateAllowedArray(a));
	}

}
