package strings.problems;

import java.util.ArrayList;

public class getAllAnagrams {
	public static ArrayList<String> getAnagrams(String s){
		ArrayList<String> result = new ArrayList<String>(2*s.length());
		helper(result,"",s);
		return result;
	}
	//helper(r,"",abc) -> helper(r,a,bc),helper(r,b,ac),helper(r,c,ab)
	//helper(r,a,bc) -> helper(r,ab,c), helper(r,ac,b)
	//helper(r,ab,c) -> helper(r,abc,"")-> base case.
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
	public static void main(String[] args){
		String s = "abc";
		ArrayList<String> list;
		//System.out.println(s.substring(0,2));
		list = getAnagrams(s);
		for(String a : list){
			//if(a.length() == s.length())
			System.out.println(a);
		}
		
	}
}
