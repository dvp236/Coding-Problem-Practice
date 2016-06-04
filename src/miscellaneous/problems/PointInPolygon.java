package miscellaneous.problems;
/**
 * 
 * @author dharmik patel
 * Check if point is in the polygon 
 *
 */

public class PointInPolygon {
	public boolean isInsidePolygon(double x, double y, double[] pointsX, double[] pointsY){
		int n = pointsX.length-1;
		int j = n ;
		boolean result = false;
		//here we want to count number of time we cross the boundary.
		//if it is odd number the point is in the polygon.
		for(int i=0 ; i<n; i++){
			//first loop ensures there is no devision by 0 in second if loop
			if((pointsY[i] < y && pointsY[j]>=y 
					|| pointsY[j] < y && pointsY[i] >=y)
				&& (pointsX[i] <= x || pointsX[j] <=x )){
				if(pointsX[i] +(y-pointsY[i])/(pointsY[j]-pointsY[i])*(pointsX[j] - pointsX[i])<x){
					result = !result;
				}
			}
			//j is the last points, i is current 
			j = i;
		}
		return result;
	}
}
