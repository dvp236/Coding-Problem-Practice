package strings.problems;

public class ReverseString {
	
	public String reverseSB(String st){
		StringBuilder sb =  new StringBuilder(st);
		sb = sb.reverse();
		return sb.toString();
	}
	
	public String myreverse(String st){
		char[] res = st.toCharArray();
		int left = 0, right = st.length() -1 ;
		while(left <= right){
			char temp = res[left];
			res[left] = res[right]; 
			res[right] = temp;
			left++;
			right--;
		}
		return new String(res);
	}
	
	public static void main(String[] args){
		String st = "bhumi patel";
		ReverseString r = new ReverseString();
		System.out.println(r.reverseSB(st));
		System.out.println(r.myreverse(st));
		
	}
}
