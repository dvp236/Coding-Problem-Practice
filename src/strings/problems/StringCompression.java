package strings.problems;

/**
 * 
 * @author dharmik
 * Implement a String compression algorithm:
 * Input: aaabbcccc Output: a3b2c34
 * Input: abcd Output: abcd
 *
 */

public class StringCompression {

	private static String compressIt(String st){
		//using StringBuilder for cost effective concat operation
		StringBuilder sb = new StringBuilder("");
		
		//convert string to char array
		char[] ch = st.toCharArray();
		int cnt=0;
		
		//iterate over all characters 
		for(int i =0 ; i<ch.length;i++){
			cnt++;
			
			//write the char and count value if next char is not same 
			if(i+1 >= ch.length || ch[i] != ch[i+1]){
				sb.append(String.valueOf(ch[i])+String.valueOf(cnt));
				cnt=0;
			}
		
		}
		
		//return original string if compressed string is longer than original
		//or return the compressed string
		String comp = sb.length() < st.length() ? sb.toString() : st;
		return comp;
	}
	
	public static void main(String[] args) {
		
		String str="aaabbcccc";
		String cstr =compressIt(str);
		System.out.println(cstr);
	}

}
