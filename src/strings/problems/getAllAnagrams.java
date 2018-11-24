package strings.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class getAllAnagrams {
	
	public static ArrayList<String> getAnagrams(String s){
		ArrayList<String> result = new ArrayList<String>(2*s.length());
		helper(result,"",s);
		return result;
	}
	//helper(r,"",abc) -> helper(r,a,bc),helper(r,b,ac),helper(r,c,ab)
	//helper(r,a,bc) -> helper(r,ab,c), helper(r,ac,b)
	//helper(r,ab,c) -> helper(r,abc,"")-> base case.
	//Time complexity - O(2^n+1)
	private static void helper(ArrayList<String> result, String pre, String s){
		if(s.length() == 0){
			result.add(pre);
		}
		else{
			for(int i=0;i<s.length();i++){
				helper(result, pre+s.charAt(i),s.substring(0,i)+s.substring(i+1,s.length()));
			}
		}
		
	}
	
	//Just another solution.
	public static void getAnagrams2(String s){
		char[] a = new char[s.length()];
		for(int i=0;i<s.length();i++){
			a[i] = s.charAt(i);
		}
		helper2(a,s.length());
	}
	
	private static void helper2(char[] a, int n){
		if(n==1){
			System.out.println(Arrays.toString(a));
			return;
		}
		else{
			for(int i=0;i<n;i++){
				swap(a,i,n-1);
				helper2(a,n-1);
				swap(a,i,n-1);
			}
		}
	}
	private static void swap(char[] a,int i,int j){
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args){
		String s = "aac";
		ArrayList<String> list;
		list = getAnagrams(s);
		for(String a : list){
			//if(a.length() == s.length())
			System.out.println(a);
		}
		//getAnagrams2(s);
	}
}
