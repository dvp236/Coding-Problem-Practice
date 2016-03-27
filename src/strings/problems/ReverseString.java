package strings.problems;

/**
 * 
 * @author dharmik
 * Write different solutions to reverse string
 */
public class ReverseString {
	
	//Returns reverse string. Uses java's StringBuilder class. 
	public String reverseSB(String st){
		StringBuilder sb =  new StringBuilder(st);
		sb = sb.reverse();
		return sb.toString();
	}
	
	//custom method to reverse string.
	//time complexity O(n).
	public String myreverse(String st){
	
		char[] res = st.toCharArray();
		int left = 0, right = st.length() -1 ;
		
		//this loop will execute n/2  times.
		while(left <= right){
			char temp = res[left];
			res[left] = res[right]; 
			res[right] = temp;
			left++;
			right--;
		}
		
		return new String(res);
	}
	
	//Method to reverse an integer
	public int reverseInt(int n){
		int result = 0;
		
		while(n > 0){
			result = result*10 + n%10;
			n = n/10;
		}
		
		return result;
	}
	
	public static void main(String[] args){
		String st = "bhumi patel";
		ReverseString r = new ReverseString();
		System.out.println(r.reverseSB(st));
		System.out.println(r.myreverse(st));
		System.out.println(r.reverseInt(1234));
	}
}
