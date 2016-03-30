package array.problems;

public class ArrayHopper {

	private static String greedyArrayhop(int[] a){
		
		StringBuilder path = new StringBuilder(a.length-1);
		
		for(int i=0; i < a.length; ){
			
			path.append(String.valueOf(i)+", ");
			
			if(a[i] == 0 && i!=a.length-1){
				return "failure";
			}
			
			if(i+a[i] >= a.length-1){
			
				path.append(a.length-1+", out");
				break;
			}
			
			
			
			int nextindex = i+1;
			int nextmaxval = 0;
			for(int j = i+1; j<a.length-1 && j < i+a[i];j++){
				if(a[j] >= nextmaxval){
					nextmaxval = a[j];
					nextindex = j;
				}
			}
			i = nextindex;
			
		}
		
		return path.toString();
	}
	

}
