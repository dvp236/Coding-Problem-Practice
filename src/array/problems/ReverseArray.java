package array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * @author dharmik
 * Implement functionality to reverse an arraylist
 * @param <T>
 */

public class ReverseArray<T> {
	
	//reverse Arraylist using inbuilt collections method.
	public static<T> ArrayList<T> reverseArray(ArrayList<T> arr){
		Collections.reverse(arr);
		return arr;
	}
	
	//This method could be used as reference to reverse any array.
	public static int[] reverseArrayInt(int[] arr){
		int left=0, right=arr.length -1 ;
		
		while(left <= right){
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
		
		return arr;
	}
	
	

}
