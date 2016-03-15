package array.problems;

import java.util.ArrayList;

/**
 * 
 * @author dharmik
 *	Find element from the array where a[i] = i
 */
public class FindElement {
	
	//Time complexity O(log(n))
	//finds only one element that gets caught first
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
	//Time complexity O(n)
	//find all such elements where a[i] = i
	public ArrayList<Integer> findAllElements(int[] a ){
		ArrayList<Integer> result  = new ArrayList<Integer>();
		for(int i=0;i<a.length;i++){
			if(a[i]== i){
				result.add(i);
			}
		}
		return result;
	}
	

}
