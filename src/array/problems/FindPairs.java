package array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPairs {

	public static void main(String[] args) {
		int[] a = {7,1,2,3,4,5,6};
		Arrays.sort(a);
		List<int[]> res = new ArrayList<>();
		System.out.println(Arrays.asList(a).indexOf(1));
		int target = 9;
		for(int i=0;i<a.length;i++){
			int temp = target-a[i];
			
			if(Arrays.binarySearch(a, temp) != -1){
				
				int[] t ={a[i],temp};
				res.add(t);
			}
				
		}
		for(int[] c : res){
			System.out.println(Arrays.toString(c));
		}
		
	}

}
