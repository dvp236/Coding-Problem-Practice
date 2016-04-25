package strings.problems;

import java.util.Arrays;

public class ReverseVowelsOfString {
	public static String reverseStringVowels(String str){
		int left = -1;
		int right = str.length();
		
		String vowels = "aeiouAEIOU";
		char[] result = str.toCharArray();
		while(left < right){
			while(vowels.indexOf(result[++left])<0 && left < right);
			while(vowels.indexOf(result[--right])<0 && left < right);
			if(left >= right) break;
			char temp = result[left];
			result[left] = result[right];
			result[right] = temp;
		}
		
		return new String(result);
	}
	public static void main(String[] args) {
		String s = "leetcode";
		System.out.println(reverseStringVowels(s));
	}

}
