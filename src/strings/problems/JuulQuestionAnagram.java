package strings.problems;
import java.io.*;
import java.util.*;
public class JuulQuestionAnagram {
	

	/*
	Intructions
	Implement group_by_anagram by processing the inputs and grouping them by anagrams. 
	An anagram is a word formed by rearranging the letters of another, such as cinema, formed from iceman.

	Expected Output:
	Array with the first element being an Array[Array(String)] containing grouped anagrams.
	The second element should be a Array(String) that contains all the words that were not 
	matched against any other as anagram


	[
	  [
	    ['art', 'rat', 'tar'], 
	    ['desserts', 'stressed'], 
	    ['elbow', 'below'],
	    ['state', 'taste'],    
	  ],
	  [
	    'dusty', 
	    'tart', 
	    'cat',
	  ]
	]

	group_by_anagram(['art', 'desserts', 'elbow', 'state', 'dusty', 'rat', 'tart', 'cat', 'below', 'taste', 'stressed', 'tar'])
	 */


	  
	  
	  private static boolean isAnagram(String s1, String s2) {
	    
	    if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) return false;
	   
	    if (s1.length() != s2.length()) return false;
	    
	    HashMap<Character, Integer> map = new HashMap<>();
	    for (int i = 0; i < s1.length(); i++) {
	      map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i),0) +1);
	      map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i),0) - 1);
	    }
	    
	    for (char key: map.keySet()){
	      if (map.get(key) != 0) return false;
	    }
	    
	    return true;
	    
	    
	  }
	  
	  public static void groupBy(String[] words) {
	    List<List<String>> answer = new ArrayList<>();
	    List<List<String>> result = new ArrayList<>();
	    
	    HashSet<String> processed = new HashSet<String>();
	    List<String> nonGrams = new ArrayList<String>();
	    
	    for (int i = 0; i < words.length; i++) {
	      String si = words[i];
	      if (processed.contains(si)) continue;
	      List<String> anagrams = new ArrayList<String>();
	      anagrams.add(si);
	      for (int j = i+1; j < words.length; j++) {
	        String sj = words[j];
	        if (!processed.contains(sj)) {
	          if (isAnagram(si,sj)) {
	            anagrams.add(sj);
	            processed.add(sj);
	            processed.add(si);
	          }
	        }
	      }
	      if(anagrams.size() == 1) {
	        nonGrams.add(si);
	      } else {
	        result.add(anagrams);
	      }
	    }
	    
	    
	    //answer.add(result);
	    //answer.add(nonGrams);
	    
	    for (List<String> anag : result) {
	      System.out.println(anag);
	    }
	    System.out.println("nongrams - ");
	     System.out.println(nonGrams);

	  }
	  
	  
	  public static void main(String[] args) {
	    
	    
	    String[] words = new String[]{"art", "desserts", "elbow", "state", "dusty", "rat", "tart", "cat", "below", "taste", "stressed", "tar"};
	    
	    groupBy(words);
	    
	    
	    // System.out.println(isAnagram("abc", "bac"));
	    // System.out.println(isAnagram("art", "tar"));
	    // System.out.println(isAnagram("aaac", "tarr"));
	    // System.out.println(isAnagram("abc", "bacc"));
	    
	    // for (int i = 1; i <= 100; i++) {
	    //   if (i % 3 == 0 && i % 5 == 0) {
	    //     System.out.println("FizzBuzz");
	    //   }
	    //   else if (i % 3 == 0) {
	    //     System.out.println("Fizz");
	    //   }
	    //   else if ( i % 5 == 0) {
	    //     System.out.println("Buzz");
	    //   } else {
	    //     System.out.println(i);
	    //   }
	    // }
	  }
	

}

