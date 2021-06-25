
class Time {
	
	private int hour;
	private int minute;
	private int second;

	public Time() {		//	Default
		this(0, 0, 0);	 
	}
	
	public Time(int h, int m, int s) {		// The second one
		this.setTime(h, m, s);		

	}

	private void setTime(int h, int m, int s) {		//	method for setting time
		hour = ( ( h > 0 && h <= 23 ) ? h : 0 );
		minute = ( ( m >= 0 && m < 60 ) ? m : 0 );
		second = ( ( s >= 0 && s < 60 ) ? s : 0 );
		
	}

	@Override
	public String toString() {			
		String fmt = "%02d:%02d:%02d";
		String result = String.format(fmt, hour, minute, second);
		return result;
	}
}

public class SetTimeTest {
	public static void main(String [] args) {
		Time t = new Time();				//	Default 
		Time t1 = new Time(13, 27, 6);		//	The second one
		Time t2 = new Time(99, 77, 64);		//	Wrong value
		System.out.println(t.toString());
		System.out.println(t1.toString());
		System.out.println(t2.toString());
		
	}
}
