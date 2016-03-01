package strings.problems;


/**
 * 
 * @author dharmik
 * Determine if the two strings are One edit away from eachother.
 */
public class OneAway {
	
	//Check if two strings are one edit away.
	//i.e google and gogle is one edit away since putting single 'o' can make two strings same
	public boolean isOneAway(String st,String st2){
		//determine the bigger string
		String bigger = st.length()>= st2.length() ? st : st2;
		String smaller= st.length() < st2.length() ? st : st2;
		
		int indexbig=0, indexsmall=0;
		boolean flag=false;
		//loop over both the string till the end
		while(indexbig < bigger.length() && indexsmall < smaller.length()){
			
			//if character at index does not match it returns false
			if (bigger.charAt(indexbig) != smaller.charAt(indexsmall)){
				//flag is used to allow for one non match between strings
				if (flag){
					return false;
				}	
				flag = true;
			}else{
				indexsmall++;
			}
			
			indexbig++;
		}
		return true;
		
	}
}
