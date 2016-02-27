package strings.problems;

/**
 * 
 * @author dharmik
 * Check if the permutation of the String is Palindrome or not.
 * 
 */
public class PalindromPermutation {
	//Time Complexity O(n)
	public boolean isPalindromPermutation(String st){
		//check if length of string is odd 
		if(st.length()%2==0){
			return false;
		}
		
		//counterOdd increments when character is encountered first time
		//and decrements by 1 when it encounters the character again
		int counterOdd=0;
		int[] chrsPlot = new int[256];
		char[] ch = st.toCharArray();
		
		for(int i =0;i<ch.length;i++){
			//in char plot increment counter by 1 at the index of perticular char
			int charVal = (int)ch[i];
			chrsPlot[charVal]++;
			
			//increment counter if its odd entry
			//and decrement likewise
			if (chrsPlot[charVal]%2==1){
				counterOdd++;
			}else{
				counterOdd--;
			}
			
		}
		
		//make sure if only one character has odd number of occurrences.
		return counterOdd<=1;
	}

}
