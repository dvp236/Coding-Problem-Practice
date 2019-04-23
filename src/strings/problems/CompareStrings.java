package strings.problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * @author dharmik
 * compare the permutations of the string. 
 *
 */
public class CompareStrings {

	//This method takes two strings and returns true if they are anagram
	//Time Complexity of the algorithm is O(n)
	public static boolean isAnagram(String s1,String s2){
		//null check
		if(s1==null || s2==null){
			System.out.println("null string");
			return false;
		}
		//check if length of both String are same
		if(s1.length() != s2.length()){
			return false;
		}
		//convert both string into char array	
		char[] s1char=s1.toCharArray();
		char[] s2char=s2.toCharArray();
		
		//get the sum of ASCII values of each char from both char array
		int s1Sum =0;
		int s2Sum =0;
		for(int i=0;i<s1char.length;i++){
			s1Sum += (int)s1char[i];
			s2Sum += (int)s2char[i];
		}
		//check if ASCII sum of both the string chars is equal
		return s1Sum==s2Sum;
	}
	
	//This is another algorithm to compare anagrams 
	//It uses HashMap
	//Time complexity of algorithm is O(n).
	public boolean isAnagram_2(String s1,String s2){
		//null check
		if(s1==null || s2==null){
			return false;
		}
		//check length of string
		if(s1.length() != s2.length()){
			return false;
		}
		
		//for each character Key in the hashmap increase the integer value for string s1
		// and decrease the integer value for given character of String s2
		HashMap<Character,Integer> hs=new HashMap<>();
		for(int i=0;i<s1.length();i++){
			char s1Char = s1.charAt(i);
		    int currSum=hs.containsKey(s1Char)? hs.get(s1Char):0;
		    //for each char in S1, increase value by1
		    hs.put(s1Char, ++currSum);
		    
		    char s2Char = s2.charAt(i);
		    currSum = hs.containsKey(s2Char)? hs.get(s2Char):0;
		    //for each char in S2, decrease value by 1
		    hs.put(s2Char, --currSum);
		  
		}
		
		//Check if all the values are 0
		for(Integer val:hs.values()){
			if(val !=0){
				return false;
			}
		}
		return true;
	}
	
	//expensive but concise
	//time complexity - O(nlogn) - n is length of bigger string
	public static boolean isAnagram3(String s1, String s2) {
		//null check
		if(s1==null || s2==null){
			System.out.println("null string");
			return false;
		}
		//check if length of both String are same
		if(s1.length() != s2.length()){
			return false;
		}
			
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		Arrays.sort(c1); Arrays.sort(c2);
		String sorteds1 = new String(c1);
		String sorteds2 = new String(c2);
		
		return sorteds1.equals(sorteds2);
	}
	
	public static void main(String[] args) {
		System.out.println(isAnagram3("art", "tar"));
	}
	
}
