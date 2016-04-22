package array.problems;
/**
 * @author dharmik
 * For given Array: a = [1,2,3,4]
 * return Multiplier array i.e [24,12,8,6]
 * Element at Each place in result Arraay 
 * is multiplication of all other elements of original array.
 * 
 */
import java.util.Arrays;

public class MultiplicatedArray {
	//Time Complexity: O(n) Space Complexity: O(1)
	public static int[] getMultiplicatedArray(int[] a){
		int mulOfArray=1;
		//here we do multiplication of all elements of array
		for(int i=0; i<a.length; i++){
			mulOfArray = mulOfArray*a[i];
		}
		//now to get result array we divide the multiplication result 
		//by the element at index i itself. 
		for(int i=0; i<a.length; i++){
			a[i]=mulOfArray/a[i];
		}
		
		return a;
	}

	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		System.out.println(Arrays.toString(getMultiplicatedArray(a)));
	}

}
