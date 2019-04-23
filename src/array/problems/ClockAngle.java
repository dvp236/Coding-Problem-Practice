package array.problems;

public class ClockAngle {
	
	public static void angle(int h, int m) {
		if (h <0 || m < 0 || h >12 || m > 60) 
            System.out.println("Wrong input"); 
  
        if (h == 12) 
            h = 0; 
        if (m == 60)  
            m = 0; 
        
        int h_angle = (int) (0.5 * (h*60 + m));
        int m_angle = m * 6;
        
        int angle = Math.abs(h_angle - m_angle);
        
        //internal angle
        angle = Math.min(360-angle, angle);
        
        //external
        angle = Math.max(360 - angle, angle);
	}
	
	public static void main(String[] args) {
		
	}

}
