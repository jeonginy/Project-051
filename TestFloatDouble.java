public class TestFloatDouble {
	private static double round(double v, int i) {
//		  23.456 * 100.0
//		  2345.6 + 0.5 
//		  (int) 2346.1 -> 2346
//		  2346 / 100.0 
//		  23.46
		double  r   =  v * Math.pow(10, i) + 0.5;
		int     r2  =  (int) r;
		double  r3  = (double) r2 / Math.pow(10, i);           
		return  r3;
	}
	
	public static void main(String[] args) {
		
		float f = 0.0f;
		for (int i = 1; i <=10000; i++) {
			f = f + 0.1f;
		}
		System.out.println( f );
		
		double d = 0.0;
		for (int i = 1; i <=10000; i++) {
			d = d + 0.1;
		}
		System.out.println( d );
		
		double org = 23.4578;
		double d1   = round(org, 3);
		System.out.println( d1 );
		System.out.printf( "%.3f \n", org );



	}

}







