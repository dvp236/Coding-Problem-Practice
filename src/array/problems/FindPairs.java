package array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
/**
 * 
 * @author dharmik
 * Find pairs of element from an array a where sum of pairs 
 * equals to given target number.
 */
public class FindPairs {
	
	//Complexity O(nlog(n))
	public static HashSet<List<Integer>> getPairs(int[] a, int target){
		//sorting with cost nlog(n)
		Arrays.sort(a);
		HashSet<List<Integer>> resultSet = new HashSet<>();
		//n loop iteration.
		for(int i=0;i<a.length;i++){
			int temp = target-a[i];
			
			//Binary Search complexity log(n)
			if(Arrays.binarySearch(a, temp) != -1){
				final int min = a[i] < temp ? a[i] : temp;
				final int max = a[i] == min ? temp : a[i];
				//using list to ensure immutability instead of int array
				//immutability required for hashset to work properly
				List<Integer> pair = Arrays.asList(min,max);
				resultSet.add(pair);
			}
				
		}
		return resultSet;
	}
	
	public static void main(String[] args) {
		int[] a = {7,1,2,3,4,5,6};
		Arrays.sort(a);
		HashSet<List<Integer>> res= getPairs(a, 9);
		
		for(List<Integer> c : res){
			System.out.println(Arrays.toString(c.toArray()));
		}
		
	}

}
